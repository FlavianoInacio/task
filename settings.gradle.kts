pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Task_App"
include (":app")
include (":infrastructure")
include (":infrastructure:domain")
include (":infrastructure:data")
include (":infrastructure:desing_system")
