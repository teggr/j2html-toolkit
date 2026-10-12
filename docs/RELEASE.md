# Release the artefacts to Maven Central

Releases are started manually from GitHub Actions. The workflow publishes the snapshot version as a release, creates a matching GitHub Release, then advances the selected branch to the next patch snapshot.

## Configure repository secrets

Add these actions secrets under **Settings > Secrets and variables > Actions**:

| Secret | Value |
| --- | --- |
| `CENTRAL_USERNAME` | Username from a Sonatype Central user token |
| `CENTRAL_PASSWORD` | Password from the same Sonatype Central user token |
| `GPG_KEY_ID` | ID or fingerprint of the signing key |
| `GPG_PRIVATE_KEY` | ASCII-armored private signing key |
| `GPG_PASSPHRASE` | Passphrase for the signing key |

Before publishing under `io.github.teggr`, verify that this namespace is registered to the account used by the Central publishing credentials.

The workflow needs `contents: write` permission to create the GitHub Release and push the next-snapshot POM changes. The selected branch must allow pushes from `github-actions[bot]`; adjust branch protection or dispatch from a branch where the workflow is allowed to push.

## Publish a release

1. Ensure the branch to release has a root POM version ending in `-SNAPSHOT`, for example `0.0.4-SNAPSHOT`.
2. Open **Actions > Publish release > Run workflow**, select the branch, and run it.
3. The workflow removes `-SNAPSHOT` from the current version and deploys the artifacts with the `central` Maven profile. It runs the Maven Central POM checker before deployment, automatically publishes a valid deployment, and waits for Maven Central publication to complete.
4. After a successful Maven Central deployment, the workflow creates a GitHub Release tagged with that release version and GitHub-generated release notes.
5. The workflow advances the POM versions to the next patch snapshot (for example, `0.0.4-SNAPSHOT` to `0.0.5-SNAPSHOT`) and commits/pushes that change to the selected branch.

The workflow does not create a GitHub Release or push a version change if Maven Central deployment fails. If the release already exists for the same source commit, a rerun reuses it so the snapshot-version commit can be retried.

## Build requirements

JDK 17 or newer is required to build, test, and publish this repository.

## Maintenance

* [Sonatype Central publishing](https://central.sonatype.com/publishing)
* [Sonatype Central deployments](https://central.sonatype.com/publishing/deployments)
* [Maven GPG Plugin](https://maven.apache.org/plugins/maven-gpg-plugin/)
* [Maven Versions Plugin](https://www.mojohaus.org/versions/versions-maven-plugin/)
* [POM Checker](https://kordamp.org/pomchecker/pomchecker-maven-plugin/)
