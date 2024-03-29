pluginManagement {
    repositories {
        google()
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

rootProject.name = "MondlyTest"
include(":app")
include(":feature:products")
include(":core:data")
include(":core:domain")
include(":core:network")
include(":core:model")
include(":core:common")
include(":sharedtest")
