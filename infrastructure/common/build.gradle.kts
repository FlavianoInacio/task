plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 26
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    api(Libraries.Util.LOG_CAT)
    api(Libraries.AndroidX.CORE)
    api(Libraries.AndroidX.View.APP_COMPACT)
    api(Libraries.Google.MATERIAL)
    api(Libraries.AndroidX.View.CONSTRAINT_LAYOUT)
    api(Libraries.Koin.KOIN)
    api(Libraries.Koin.KOIN_ANDROID)
}