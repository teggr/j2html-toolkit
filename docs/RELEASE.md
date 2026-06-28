# Release the artefacts to maven

```shell
# clear out 
mvn clean

# tag the code
git tag <version>

# set the version for all extensions and then the example webapp
mvn -Pcentral versions:set -DremoveSnapshot -DprocessAllModules
mvn -Pcentral --projects spring/j2html-example-webapp versions:set -DremoveSnapshot

# check that the poms are correct
mvn -Pcentral org.kordamp.maven:pomchecker-maven-plugin:1.14.0:check-maven-central
# deploy new version to central
mvn -Pcentral deploy -DignorePublishedComponents=true

# set the new versions for all extensions and then the example webapp
mvn -Pcentral versions:set -DnextSnapshot -DprocessAllModules
mvn -Pcentral --projects spring/j2html-example-webapp versions:set -DnextSnapshot

# commit the new versions for all extensions and the example webapp
mvn -Pcentral versions:commit -DprocessAllModules
mvn -Pcentral --projects spring/j2html-example-webapp versions:commit

# commit and push the github repo

# create github release
https://github.com/teggr/j2html-extensions/releases
```

For manual publishing: https://central.sonatype.com/publishing/deployments (GH)

## Plugins

* https://www.mojohaus.org/versions/versionsmaven-plugin/index.html
* https://maven.apache.org/plugins/maven-gpg-plugin/index.html
* https://kordamp.org/pomchecker/pomchecker-maven-plugin/index.html

## Maintenance

* https://central.sonatype.com/publishing
* https://central.sonatype.com/search?q=dev.rebelcraft