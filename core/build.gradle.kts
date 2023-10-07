plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.ANDROID_KOTLIN)
}

android {
    namespace = AppConfig.CORE_NAMESPACE
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        proguardFiles(
            getDefaultProguardFile("proguard-android-optimize.txt"),
            "proguard-rules.pro"
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    addCoreModuleDependencies()
}