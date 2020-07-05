plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.3")

    viewBinding {
        isEnabled = true
    }

    defaultConfig {
        applicationId = "com.mataku.rx2_with_coroutines_sample"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "API_KEY", "${rootProject.ext["API_KEY"]}")
        buildConfigField("String", "SHARED_SECRET", "${rootProject.ext["SHARED_SECRET"]}")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }

    signingConfigs {
        getByName("debug") {
            storeFile = file("../debug.keystore")
        }
        create("release") {
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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

    implementation(Dep.Kotlin.stdlib)
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.coreKtx)
    implementation(Dep.material)
    implementation(Dep.moshi)

    implementation(Dep.Retrofit.retrofit2)
    implementation(Dep.Retrofit.moshiConverter)
    implementation(Dep.Retrofit.rxjava2Adapter)
    implementation(Dep.OkHttp.okhttp3)
    implementation(Dep.OkHttp.loggingInterceptor)

    testImplementation(Dep.Test.junit)
    testImplementation(Dep.Test.kotlinTestJunit)
    testImplementation(Dep.Test.androidxTestCore)
    testImplementation(Dep.Test.mockitoCore)
}