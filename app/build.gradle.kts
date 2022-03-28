plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Application.COMPILE_SDK

    defaultConfig {
        applicationId = Application.ID
        minSdk = Application.MIN_SDK
        targetSdk = Application.TARGET_SDK
        versionCode = Application.VERSION_CODE
        versionName = Application.VERSION_NAME

        testInstrumentationRunner = Application.INSTRUMENTATION_RUNNER
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

    // add project
    implementation(project(Project.Dir.DOMAIN))
    implementation(project(Project.Dir.DATA))
    implementation(project(Project.Dir.DESIGN_SYSTEM))

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