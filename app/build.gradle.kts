plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "my.company.poedit"
    compileSdk = 35  // ⚠️ Пока ставим 34 (36 может не поддерживаться в AndroidPE)

    defaultConfig {
        applicationId = "my.company.poedit"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"  // Пока оставим так, чтобы не усложнять
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // ✅ Прямые зависимости (без libs.versions.toml — проще и надёжнее)
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.activity:activity-ktx:1.8.2")
    
    // ✅ Fragment (для нашей архитектуры)
    implementation("androidx.fragment:fragment-ktx:1.6.2")
}