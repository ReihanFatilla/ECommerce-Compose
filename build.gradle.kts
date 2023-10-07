// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id(BuildPlugins.ANDROID_APPLICATION).version(BuildDependencyVersions.ANDROID_VERSION).apply(false)
    id(BuildPlugins.ANDROID_KOTLIN).version(BuildDependencyVersions.KOTLIN_VERSION).apply(false)
    id(BuildPlugins.ANDROID_LIBRARY).version(BuildDependencyVersions.ANDROID_VERSION).apply(false)
}
