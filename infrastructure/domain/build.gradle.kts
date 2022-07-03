plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN)
}


android {
    compileSdk = Application.SDK.COMPILE_SDK

    defaultConfig {
        minSdk = Application.SDK.MIN_SDK
        targetSdk = Application.SDK.TARGET_SDK

        testInstrumentationRunner = Application.TEST.INSTRUMENTATION_RUNNER
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {

    implementation(project(Project.Dir.COMMON))

    testImplementation(Libraries.Test.JUNIT)
    androidTestImplementation(Libraries.Test.EXT)
    androidTestImplementation(Libraries.Test.ESPRESSO)


    testImplementation(Libraries.Koin.Test.KOIN_JUNIT)
    testImplementation(Libraries.Koin.Test.KOIN)
}