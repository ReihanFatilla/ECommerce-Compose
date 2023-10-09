object CoreDependencies {
    const val KTOR_CORE = "io.ktor:ktor-client-core:${BuildDependencyVersions.KTOR_VERSION}"
    const val KTOR_ANDROID = "io.ktor:ktor-client-android:${BuildDependencyVersions.KTOR_VERSION}"
    const val KTOR_SERIALIZATION = "io.ktor:ktor-client-serialization:${BuildDependencyVersions.KTOR_VERSION}"
    const val KTOR_LOGGING = "io.ktor:ktor-client-logging:${BuildDependencyVersions.KTOR_VERSION}"

    const val KOTLINX_SERIALIZATION = "org.jetbrains.kotlinx:kotlinx-serialization-json:${BuildDependencyVersions.SERIALIZATION_VERSION}"

    const val ROOM_RUNTIME = "androidx.room:room-runtime:${BuildDependencyVersions.ROOM_VERSION}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${BuildDependencyVersions.ROOM_VERSION}"
    const val ROOM_KTX = "androidx.room:room-ktx:${BuildDependencyVersions.ROOM_VERSION}"
}