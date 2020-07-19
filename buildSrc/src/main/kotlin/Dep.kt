object Dep {

    private const val KOTLIN_VERSION = "1.3.72"

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.1.0"
        const val coreKtx = "androidx.core:core-ktx:1.3.0"
        const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$KOTLIN_VERSION"
    }

    object Gradle {
        const val androidGradlePlugin = "com.android.tools.build:gradle:4.1.0-beta03"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"
    }

    object Test {
        const val junit = "junit:junit:4.13"
        const val kotlinTestJunit = "org.jetbrains.kotlin:kotlin-test-junit:$KOTLIN_VERSION"
        const val androidxTestCore = "androidx.test:core:1.2.0"
        const val mockitoCore = "org.mockito:mockito-core:2.25.1"
    }

    object Retrofit {
        const val retrofit2 = "com.squareup.retrofit2:retrofit:2.9.0"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:2.9.0"
        const val rxjava2Adapter = "com.squareup.retrofit2:adapter-rxjava2:2.9.0"
    }

    object OkHttp {
        const val okhttp3 = "com.squareup.okhttp3:okhttp:4.7.2"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.7.2"
    }

    object Rxjava {
        const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.19"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
    }

    const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    const val glide = "com.github.bumptech.glide:glide:4.11.0"
    const val glideCompiler = "com.github.bumptech.glide:compiler:4.11.0"
    const val material = "com.google.android.material:material:1.1.0"
    const val moshi = "com.squareup.moshi:moshi:1.9.3"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:1.9.3"
}