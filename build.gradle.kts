// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(libs.replugin.plugin.gradle)
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

// 这个plugin需要放在android配置之后,因为需要读取android中的配置项
apply(plugin = "replugin-plugin-gradle")

configure<com.qihoo360.replugin.gradle.plugin.ReClassConfig> {
    // 插件名
    pluginName = "repluginapp"
    // 宿主app的包名
    hostApplicationId = "com.demo.androidseedproject"
    // 宿主app的启动Activity
    hostAppLauncherActivity = "com.demo.main.ui.SplashActivity"
}