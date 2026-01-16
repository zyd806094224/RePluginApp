# RePluginApp - RePlugin 插件工程

这是一个基于 RePlugin 框架的 Android **插件应用**(Plugin App),用于学习和了解 Android 插件化开发技术。

## 📋 项目简介

本项目是一个独立的 Android 插件模块,使用 360 开源的 RePlugin 插件化框架开发。插件可以被宿主应用动态加载、安装和运行,实现应用功能的模块化和热更新。

**⚠️ 重要提示**: 360 RePlugin 框架已停止维护,本项目仅用于学习和了解插件化技术原理,不建议在生产环境中使用。

## 🎯 项目特点

- **纯插件工程**: 这是一个独立的插件应用,不是完整的宿主应用
- **Jetpack Compose**: 使用现代化的声明式 UI 框架
- **Kotlin 开发**: 100% Kotlin 语言编写
- **插件化架构**: 可被宿主应用动态加载和运行

## 🔗 宿主工程

**本插件工程需要配合宿主工程使用:**

- **宿主工程地址**: https://github.com/zyd809094224/AndroidSeedProject
- **目标分支**: `360-replugin-dev`
- **联合测试**: 请先运行宿主工程,然后在该宿主工程中加载本插件

### 宿主工程配置说明

宿主工程中配置的插件信息:
- **插件名称**: `repluginapp`
- **插件包名**: `com.example.repluginapp`
- **宿主包名**: `com.demo.androidseedproject`
- **宿主启动页**: `com.demo.main.ui.SplashActivity`

## 🛠️ 技术栈

- **语言**: Kotlin 1.9.20
- **最低 SDK**: API 24 (Android 7.0)
- **目标 SDK**: API 34 (Android 14)
- **编译 SDK**: API 34
- **构建工具**: Android Gradle Plugin 8.6.0, Gradle 8.7
- **UI 框架**: Jetpack Compose (BOM 2023.08.00)
- **插件化框架**: RePlugin 3.1.0

## 📦 项目结构

```
RePluginApp/
├── app/                           # 插件应用模块
│   ├── src/main/
│   │   ├── java/                 # Kotlin 源代码
│   │   │   └── com/example/repluginapp/
│   │   │       └── MainActivity.kt    # 插件入口 Activity
│   │   ├── res/                  # 资源文件
│   │   └── AndroidManifest.xml   # 插件清单文件
│   └── build.gradle.kts          # 插件构建配置
├── gradle/
│   └── libs.versions.toml        # 版本目录管理
├── build.gradle.kts              # 项目根构建配置
└── settings.gradle.kts           # Gradle 设置
```

## 🚀 快速开始

### 环境要求

- Android Studio Koala (2024.1.2) 或更高版本
- JDK 17 或更高版本
- Android SDK API 34

### 完整测试流程

1. **克隆宿主工程**:
   ```bash
   git clone https://github.com/zyd809094224/AndroidSeedProject.git
   cd AndroidSeedProject
   git checkout 360-replugin-dev
   ```

2. **打开并运行宿主工程**:
   - 使用 Android Studio 打开宿主工程
   - 运行宿主应用到设备上

3. **构建本插件工程**:
   ```bash
   # 在本工程目录下执行
   ./gradlew assembleDebug
   ```

4. **在宿主工程中加载插件**:
   - 将生成的 `app-debug.apk` 安装到宿主应用
   - 或通过宿主应用的插件管理功能加载

### 单独构建

如果只需要构建插件 APK:

```bash
./gradlew clean assembleDebug
```

生成的 APK 位于: `app/build/outputs/apk/debug/app-debug.apk`

## 🔧 RePlugin 配置

### 插件配置

本插件的 RePlugin 配置位于 `build.gradle.kts`:

```kotlin
configure<com.qihoo360.replugin.gradle.plugin.ReClassConfig> {
    pluginName = "repluginapp"                              // 插件名称
    hostApplicationId = "com.demo.androidseedproject"        // 宿主应用包名
    hostAppLauncherActivity = "com.demo.main.ui.SplashActivity"  // 宿主启动页
}
```

### 依赖管理

项目使用 Gradle 版本目录(Versions Catalog)管理依赖:

```toml
[versions]
replugin = "3.1.0"

[libraries]
replugin-plugin-gradle = { group = "com.qihoo360.replugin", name = "replugin-plugin-gradle", version.ref = "replugin" }
replugin-plugin-lib = { group = "com.qihoo360.replugin", name = "replugin-plugin-lib", version.ref = "replugin" }
```

### Maven 仓库

RePlugin 使用 360 的 Maven 仓库,在 `settings.gradle.kts` 中配置:

```kotlin
maven {
    url = uri("http://maven.geelib.360.cn/nexus/repository/replugin/")
    isAllowInsecureProtocol = true  // 允许 HTTP 协议
}
```

## 📚 学习资源

### RePlugin 框架

- [RePlugin GitHub 仓库](https://github.com/Qihoo360/RePlugin) (已停止维护)
- [RePlugin 官方文档](https://github.com/Qihoo360/RePlugin/wiki)

### 现代化替代方案

由于 RePlugin 已停止维护,建议学习以下官方方案:

- **[Android App Bundles (AAB)](https://developer.android.com/guide/app-bundle)** - Google 官方的动态分发方案
- **[Dynamic Feature Modules](https://developer.android.com/guide/play-core/feature-delivery)** - 官方的动态功能模块
- **[Play Asset Delivery](https://developer.android.com/guide/play-core/asset-delivery)** - 资产动态分发

## 🐛 常见问题

### Q: 插件无法被宿主加载?

**A**: 请检查:
1. 宿主工程的 RePlugin 配置是否正确
2. 插件名称是否匹配
3. 宿主应用是否已安装并运行

### Q: 编译时出现依赖错误?

**A**: 确保:
1. 网络连接正常,能够访问 360 Maven 仓库
2. Gradle 版本与 AGP 版本匹配
3. 已在 `settings.gradle.kts` 中配置了 RePlugin 仓库

### Q: 为什么使用 HTTP 协议的仓库?

**A**: 360 的 Maven 仓库只支持 HTTP 协议,因此需要在配置中允许不安全的协议连接。

## ⚖️ 免责声明

- RePlugin 框架已停止维护,可能存在兼容性和安全漏洞
- 本项目仅用于学习插件化技术原理
- 不建议在生产环境中使用
- 使用本项目代码产生的任何问题,作者不承担责任

## 📮 联系方式

- **宿主工程**: https://github.com/zyd809094224/AndroidSeedProject
- **Issue 讨论**: 欢迎在 GitHub 上提出问题

---

**最后更新**: 2026年1月

**祝学习愉快! 🎓**
