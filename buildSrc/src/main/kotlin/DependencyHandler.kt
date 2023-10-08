import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.api(dependencyNotation: String): Dependency? =
    add("api", dependencyNotation)


fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)


fun DependencyHandler.debugImplementation(dependencyNotation: String): Dependency? =
    add("debugImplementation", dependencyNotation)


fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? =
    add("testImplementation", dependencyNotation)


fun DependencyHandler.androidTestImplementation(dependencyNotation: String): Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.addAppModuleDependencies() {
    implementation(AppDependencies.LIFECYCLE_RUNTIME_KTX)
    implementation(AppDependencies.COMPOSE_UI)
    implementation(AppDependencies.COMPOSE_ACTIVITY)
    implementation(AppDependencies.COMPOSE_UI_GRAPHICS)
    implementation(AppDependencies.COMPOSE_UI_TOOLING_PREVIEW)
    implementation(AppDependencies.COMPOSE_MATERIAL)
    implementation(AppDependencies.COMPOSE_MATERIAL_3)
    implementation(AppDependencies.COMPOSE_COIL)
    debugImplementation(AppDependencies.COMPOSE_UI_TOOLING)
}

fun DependencyHandler.addCoreModuleDependencies() {
    implementation(CoreDependencies.KOTLINX_SERIALIZATION)
    implementation(CoreDependencies.KTOR_CORE)
    implementation(CoreDependencies.KTOR_ANDROID)
    implementation(CoreDependencies.KTOR_SERIALIZATION)
    implementation(CoreDependencies.KTOR_LOGGING)
}

fun DependencyHandler.addSharedModuleDepencies(){
    implementation(SharedDependencies.CORE_KTX)
    implementation(SharedDependencies.KOIN)
    implementation(SharedDependencies.KOIN_COMPOSE)
    implementation(SharedDependencies.RX_JAVA)
    implementation(SharedDependencies.RX_JAVA_ANDROID)
    implementation(SharedDependencies.RX_JAVA_ADAPTER)
}