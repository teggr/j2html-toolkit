package dev.rebelcraft.j2html.tools;

import com.helger.commons.collection.impl.ICommonsList;
import com.helger.css.ECSSVersion;
import com.helger.css.decl.CSSSelector;
import com.helger.css.decl.CascadingStyleSheet;
import com.helger.css.decl.ICSSSelectorMember;
import com.helger.css.decl.visit.CSSVisitor;
import com.helger.css.decl.visit.DefaultCSSVisitor;
import com.helger.css.reader.CSSReader;
import com.palantir.javapoet.AnnotationSpec;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.TypeSpec;
import dev.rebelcraft.j2html.ext.CssClassMapper;

import javax.annotation.Nonnull;
import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExtractCssClassesToJava {

    /**
     * @param args - css_file package_name class_name output_dir
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        String cssFilePath = args[0];
        String packageName = args[1];
        String className = args[2];
        String outputPath = args[3];

        System.out.println("CSS File: " + cssFilePath);
        System.out.println("Package Name: " + packageName);
        System.out.println("Class Name: " + className);
        System.out.println("Output Path: " + outputPath);

        CascadingStyleSheet css = CSSReader.readFromFile(new File(cssFilePath), StandardCharsets.UTF_8, ECSSVersion.CSS30);

        if (css == null) {

            System.out.println("No CSS found");

        }

        final int[] selectorCount = {0};
        final int[] ignoredPseudos = {0};
        final int[] ignoredHtmlElements = {0};

        Set<String> selectors = new HashSet<>();
        CSSVisitor.visitCSS(css, new DefaultCSSVisitor() {

            @Override
            public void onStyleRuleSelector(@Nonnull CSSSelector cssSelector) {
                super.onStyleRuleSelector(cssSelector);
                // System.out.println(cssSelector);
                selectorCount[0]++;
                ICommonsList<ICSSSelectorMember> allMembers = cssSelector.getAllMembers();
                for (ICSSSelectorMember member : allMembers) {
                    String selector = member.getAsCSSString();
                    if (selector.startsWith(":")) {
                        ignoredPseudos[0]++;
                    } else if (selector.startsWith("*")) {
                        ignoredPseudos[0]++;
                    } else if (selector.startsWith("[")) {
                        ignoredPseudos[0]++;
                    } else if (selector.startsWith(">")) {
                        ignoredPseudos[0]++;
                    } else if (selector.startsWith("+")) {
                        ignoredPseudos[0]++;
                    } else if (selector.startsWith(" ")) {
                        ignoredPseudos[0]++;
                    } else if (selector.startsWith("~")) {
                        ignoredPseudos[0]++;
                    } else if (!selector.startsWith(".")) {
                        ignoredHtmlElements[0]++;
                    } else {
                        // System.out.println(selector);
                        selectors.add(selector);
                    }
                }
            }
        });

        System.out.println();
        System.out.println("Selectors found: " + selectorCount[0]);
        System.out.println("Ignored pseudo selectors: " + ignoredPseudos[0]);
        System.out.println("Ignored HTML element selectors: " + ignoredHtmlElements[0]);
        System.out.println("Unique class Name Selectors: " + selectors.size());

        File file = new File(outputPath);

        List<FieldSpec> variables = new ArrayList<>();
        for (String selector : selectors) {

            String cssClassName = selector.substring(selector.lastIndexOf(".") + 1);
            String variableName = cssClassName.replaceAll("-", "_");
            variables.add(FieldSpec
                    .builder(String.class, variableName, Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                    .initializer("$S", cssClassName)
                    .addAnnotation(AnnotationSpec.builder(CssClassMapper.class)
                            .addMember("field", "$S", variableName)
                            .addMember("className", "$S", cssClassName)
                            .build())
                    .build());

        }

        TypeSpec bootstrapTypeSpec = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addFields(variables)
                .build();

        JavaFile javaFile = JavaFile.builder(packageName, bootstrapTypeSpec).build();

        javaFile.writeTo(file);

    }

}
