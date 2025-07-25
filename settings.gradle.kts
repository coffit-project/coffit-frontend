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
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Coffit"
include(":app")
include(":core")
include(":data")
include(":design")
include(":feature:home")
include(":feature:login")
include(":feature:upload")
include(":feature:analyze")
include(":feature:recommend")
include(":feature:history")
include(":test:home")
include(":test:analyze")
include(":test:history")
include(":test:login")
include(":test:recommend")
include(":test:upload")
