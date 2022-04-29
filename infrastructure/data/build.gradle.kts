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
    // project
    implementation(project(Project.Dir.DOMAIN))

    implementation(Libraries.Util.LOG_CAT)
    implementation(Libraries.AndroidX.CORE)
    implementation(Libraries.AndroidX.View.APP_COMPACT)
    implementation(Libraries.Google.MATERIAL)
    implementation(Libraries.AndroidX.View.CONSTRAINT_LAYOUT)
    testImplementation(Libraries.Test.JUNIT)
    androidTestImplementation(Libraries.Test.EXT)
    androidTestImplementation(Libraries.Test.ESPRESSO)

    // Koin
    api(Libraries.Koin.KOIN)
    api(Libraries.Koin.KOIN_ANDROID)
    androidTestImplementation(Libraries.Koin.Test.KOIN)
    androidTestImplementation(Libraries.Koin.Test.KOIN_JUNIT)
}