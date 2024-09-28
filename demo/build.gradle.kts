plugins {
    id("com.android.application")
}

android {
    namespace = "com.liulishuo.filedownloader.demo"
    signingConfigs {
        create("release") {
            keyAlias = "FileDownloaderDemoKey"
            keyPassword = "liulishuo"
            storeFile = file("filedownloaderdemo.jks")
            storePassword = "liulishuo"
        }
    }
    compileSdk = 34
    buildToolsVersion = "34.0.0"

    defaultConfig {
        minSdk = 14
        targetSdk = 33

        // val file = project.rootProject.file("local.properties")
        // val needLog = if (file.exists()) {
        //     Properties().apply {
        //         load(file.inputStream())
        //     }.getProperty("needLog")
        // } else null
        // buildConfigField("boolean", "DOWNLOAD_NEED_LOG", needLog == "true" ? "true" : "false")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    lintOptions {
        warning("InvalidPackage")
    }
}

dependencies {
    implementation("com.android.support:appcompat-v7:28.0.0")
    implementation("com.android.support:recyclerview-v7:28.0.0")
    implementation("com.android.support:design:28.0.0")
    debugImplementation("cn.dreamtobe.threaddebugger:threaddebugger:1.3.3")
    releaseImplementation("cn.dreamtobe.threaddebugger:threaddebugger-no-op:1.3.3")
    implementation(project(":library"))
    implementation("com.squareup.okio:okio:1.14.0")
}
