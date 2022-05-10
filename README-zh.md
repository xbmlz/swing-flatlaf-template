# swing-flatlaf-template

[![Maven Basic Package](https://github.com/xbmlz/swing-flatlaf-template/actions/workflows/maven-package.yml/badge.svg)](https://github.com/xbmlz/swing-flatlaf-template/actions/workflows/maven-package.yml)

简体中文 | [English](./README.md)

Swing + [FlatLaf](https://github.com/JFormDesigner/FlatLaf) + [jpackage](https://docs.oracle.com/en/java/javase/15/docs/specs/man/jpackage.html) +
[Maven](http://maven.apache.org) 模板项目，用于生成桌面应用程序。

## 特性

1. 使用本机安装程序构建漂亮的小型跨平台Swing桌面应用程序
   - 支持 30-40mb .dmg, .msi and .deb - 检出构建示例[releases](https://github.com/viodo/swing-flatlaf-template/releases)。
   - 请注意，macOS版本没有签名，因此macOS将报告为 “已损坏/无法打开”。根据你的情况，有[几种解决的方式](https://github.com/wiverson/maven-jpackage-template/issues/49)。
2. 只使用Maven构建 - 无需shell脚本
   - 使用标准的Maven依赖关系系统来管理依赖关系。
3. 使用[GitHub Actions](https://github.com/viodo/swing-flatlaf-template/tree/matser/.github/workflows)， 生成[macOS（.dmg）、Windows（.msi）和Unix（例如deb/rpm）](https://github.com/wiverson/maven-jpackage-template/releases) 自动安装程序/软件包

## 环境

- [Java 17](https://adoptium.net/?variant=openjdk17) [Maven](https://maven.apache.org/)
- macOS 下需要安装 xcode
- Windows 下需要安装 [WiX Toolset](https://wixtoolset.org/) is required

该项目包含 [GitHub Actions](https://github.com/viodo/swing-flatlaf-template/tree/master/.github/workflows)
将自动生成 macOS、 Windows 和 Linux 下的安装包.

## 安装

1. 安装[OpenJDK Java 17](https://adoptium.net/?variant=openjdk17)或者
[Oracle Java 17](https://www.oracle.com/java/technologies/javase-downloads.html).
   - 打开一个新的终端/命令提示符并键入“java--version”进行验证。
2. 安装[Apache Maven 3.6.3](http://maven.apache.org/install.html)或者以后，确保它在你的路上。
   - 通过打开一个新的终端/命令提示符并键入“mvn--version”来验证这一点。
3. macOS：验证是否安装了XCode并接受了所需的协议。
   - 启动XCode并接受许可证，或者在终端中使用命令“sudo xcodebuild-license”进行验证。
4. Windows：安装[Wix 3二进制文件](https://github.com/wixtoolset/wix3/releases/).
   - 通过安装程序安装Wix应该足以让jpackage找到它。
5. 克隆/下载此项目。
6. 最后一步：从项目的根目录运行`mvn clean install`，生成`target\TestApp.dmg` 或 `target\TestApp.msi`（安装程序）。
   - 请注意，实际生成的安装程序将在文件名中包含一个版本号

因为这些构建使用精简的JVM映像[生成的安装程序在30-40mb范围内](https://github.com/wiverson/maven-jpackage-template/releases).

在macOS上，您应该[添加签名以避免错误消息](https://github.com/wiverson/maven-jpackage-template/issues/49) 与安全系统相关。

## 打包

要生成安装程序，只需运行。。。

`mvn clean install`

要在实际生成安装程序之前完成所有工作（包括生成自定义JVM）。。。

`mvn clean package`

## 鸣谢

- [wiverson/maven-jpackage-template](https://github.com/wiverson/maven-jpackage-template)
- [JFormDesigner/FlatLaf](https://github.com/JFormDesigner/FlatLaf)