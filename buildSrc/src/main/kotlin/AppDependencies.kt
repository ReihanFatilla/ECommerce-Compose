object AppDependencies {
    // lifecycle runtime
    const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${BuildDependencyVersions.LIFECYCLE_RUNTIME_VERSION}"

    // Compose Activity
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${BuildDependencyVersions.COMPOSE_ACTIVITY_VERSION}"

    // Compose UI
    const val COMPOSE_UI = "androidx.compose.ui:ui:${BuildDependencyVersions.COMPOSE_UI_VERSION}"
    const val COMPOSE_UI_GRAPHICS = "androidx.compose.ui:ui-graphics:${BuildDependencyVersions.COMPOSE_UI_VERSION}"
    const val COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${BuildDependencyVersions.COMPOSE_UI_VERSION}"
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:${BuildDependencyVersions.COMPOSE_UI_VERSION}"

    // Material
    const val COMPOSE_MATERIAL_3 = "androidx.compose.material3:material3:${BuildDependencyVersions.MATERIAL_3_VERSION}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${BuildDependencyVersions.COMPOSE_UI_VERSION}"

    // Coil
    const val COMPOSE_COIL = "io.coil-kt:coil-compose:${BuildDependencyVersions.COIL_VERSION}"

    // Compose Destination
    const val COMPOSE_DESTINATIONS_ANIMATION = "io.github.raamcosta.compose-destinations:animations-core:${BuildDependencyVersions.COMPOSE_DESTINATION_VERSION}"
    const val COMPOSE_DESTINATIONS = "io.github.raamcosta.compose-destinations:core:${BuildDependencyVersions.COMPOSE_DESTINATION_VERSION}"
    const val COMPOSE_DESTINATIONS_KSP = "io.github.raamcosta.compose-destinations:ksp:${BuildDependencyVersions.COMPOSE_DESTINATION_VERSION}"

    // Work Manager
    const val WORK_MANAGER = "androidx.work:work-runtime-ktx:${BuildDependencyVersions.WORK_MANAGER_VERSION}"
}