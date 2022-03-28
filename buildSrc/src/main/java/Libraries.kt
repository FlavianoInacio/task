object Libraries {

    object Koin {
        private const val VERSION = "3.2.0-beta-1"

        // Koin for Kotlin apps
        const val KOIN = "io.insert-koin:koin-core:$VERSION"

        // Testing
        const val KOIN_TEST = "io.insert-koin:koin-test:$VERSION"
    }

    object AndroidX {
        const val CORE = "androidx.core:core-ktx:1.7.0"

        object View {
            const val APP_COMPACT = "androidx.appcompat:appcompat:1.4.1"
            const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.3"
        }
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:1.5.0"
    }
    object Test {
        const val JUNIT = "junit:junit:4.13.2"
        const val EXT = "androidx.test.ext:junit:1.1.3"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:3.4.0"
    }

}