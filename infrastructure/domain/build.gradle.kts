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
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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
    implementation(Libraries.AndroidX.CORE)
    implementation(Libraries.AndroidX.View.APP_COMPACT)
    implementation(Libraries.Google.MATERIAL)
    implementation(Libraries.AndroidX.View.CONSTRAINT_LAYOUT)
    testImplementation(Libraries.Test.JUNIT)
    androidTestImplementation(Libraries.Test.EXT)
    androidTestImplementation(Libraries.Test.ESPRESSO)

    // Koin
    implementation(Libraries.Koin.KOIN)
    implementation(Libraries.Koin.KOIN_TEST)
}