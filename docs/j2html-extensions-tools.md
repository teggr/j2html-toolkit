# j2html-toolkit-integration-tools

Support for generating Java classes containing the CSS class names from published CSS libraries.

The reactor contains two standalone artifacts: `j2html-toolkit-integration-tools-api` at `integration/tools/api`, and `j2html-toolkit-integration-tools-plugin` at `integration/tools/plugin`. Use the plugin dependency below to run the generator from Maven.

* Quick support for any CSS library
* Auto complete for CSS classes within Java classes

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>exec-maven-plugin</artifactId>
    <version>3.1.0</version>
    <configuration>
        <mainClass>io.github.teggr.j2html.toolkit.integration.tools.ExtractCssClassesToJava</mainClass>
        <arguments>
        <argument>${project.basedir}/src/bootstrap/css/bootstrap.css</argument>
            <argument>io.github.teggr.j2html.toolkit.integration.bootstrap</argument>
            <argument>Bootstrap</argument>
        <argument>${project.basedir}/src/main/java</argument>
        </arguments>
        <includePluginDependencies>true</includePluginDependencies>
    </configuration>
    <dependencies>
        <dependency>
            <groupId>io.github.teggr</groupId>
            <artifactId>j2html-toolkit-integration-tools-plugin</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-nop</artifactId>
            <version>2.0.16</version>
        </dependency>
    </dependencies>
</plugin>

```