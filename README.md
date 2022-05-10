# swing-flatlaf-template

[![Maven Basic Package](https://github.com/xbmlz/swing-flatlaf-template/actions/workflows/maven-package.yml/badge.svg)](https://github.com/xbmlz/swing-flatlaf-template/actions/workflows/maven-package.yml)

English | [简体中文](./README-zh.md)

Swing + [FlatLaf](https://github.com/JFormDesigner/FlatLaf) + [jpackage](https://docs.oracle.com/en/java/javase/15/docs/specs/man/jpackage.html) +
[Maven](http://maven.apache.org) template project for generating native desktop applications.

## Features

1. Build nice, small cross-platform Swing desktop apps with native installers
    - Apx 30-40mb .dmg, .msi and .deb installers - check out the example builds in
      [releases](https://github.com/viodo/swing-flatlaf-template/releases).
    - Note that the macOS builds are not signed, and therefore macOS will report as
      damaged/unopenable. There
      are [a few ways to deal with this](https://github.com/wiverson/maven-jpackage-template/issues/49),
      depending on your situation.
2. Just use Maven - no shell scripts required.
    - Use standard Maven dependency system to manage dependencies
3. Generate [macOS (.dmg), Windows (.msi) and Unix (e.g. deb/rpm)](https://github.com/wiverson/maven-jpackage-template/releases)
   installers/packages automatically
   with [GitHub Actions](https://github.com/wiverson/maven-jpackage-template/tree/main/.github/workflows).

## Installation

1. Install [OpenJDK Java 17](https://adoptium.net/?variant=openjdk17) or
   [Oracle Java 17](https://www.oracle.com/java/technologies/javase-downloads.html).
   - Verify by opening a fresh Terminal/Command Prompt and typing `java --version`.
2. Install [Apache Maven 3.6.3](http://maven.apache.org/install.html) or later and make sure it's on your path.
   - Verify this by opening a fresh Terminal/Command Prompt and typing `mvn --version`.
3. macOS: verify XCode is installed and needed agreements accepted.
   - Launch XCode and accept the license, or verify in Terminal with the command `sudo xcodebuild -license`.
5. Windows: install [Wix 3 binaries](https://github.com/wixtoolset/wix3/releases/).
   - Installing Wix via the installer should be sufficient for jpackage to find it.
3. Clone/download this project.
6. Final step: run `mvn clean install` from the root of the project to generate the `target\TestApp.dmg`
   or `target\TestApp.msi` (installer).
   - Note that the actual generated installer will include a version number in the file name.

Because these builds use stripped down JVM images, the
[generated installers are in the 30-40mb range](https://github.com/wiverson/maven-jpackage-template/releases).

On macOS you should [add signing to avoid error messages](https://github.com/wiverson/maven-jpackage-template/issues/49)
related to the security system(s).

## Build

To generate an installer, just run...

`mvn clean install`

To do everything up until the actual installer generation (including generating the custom JVM)...

`mvn clean package`

## Thanks

 - [wiverson/maven-jpackage-template](https://github.com/wiverson/maven-jpackage-template)
 - [JFormDesigner/FlatLaf](https://github.com/JFormDesigner/FlatLaf)
