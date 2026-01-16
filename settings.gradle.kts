pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("http://maven.geelib.360.cn/nexus/repository/replugin/")
            isAllowInsecureProtocol = true
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("http://maven.geelib.360.cn/nexus/repository/replugin/")
            isAllowInsecureProtocol = true
        }
    }
}

rootProject.name = "RePluginApp"
include(":app")
 