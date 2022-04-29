plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.KOTLIN)
}

android {
    compileSdk = Application.SDK.COMPILE_SDK

    defaultConfig {
        applicationId = Application.ID
        minSdk = Application.SDK.MIN_SDK
        targetSdk = Application.SDK.TARGET_SDK
        versionCode = Application.VERSION.VERSION_CODE
        versionName = Application.VERSION.VERSION_NAME

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
    implementation(Libraries.Koin.Test.KOIN_JUNIT)
}