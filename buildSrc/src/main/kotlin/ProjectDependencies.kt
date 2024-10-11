object ProjectDependencies {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.supportLibrary}"
    const val material = "com.google.android.material:material:${Versions.design}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigationComponent}"
    const val navigationUI = "androidx.navigation:navigation-ui:${Versions.navigationComponent}"
    const val navigationDynamicFeatures = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigationComponent}"

    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"

    const val adapterDelegate = "com.hannesdorfmann:adapterdelegates4:${Versions.adapterDelegate}"
    const val adapterDelegateViewBinding = "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-viewbinding:${Versions.adapterDelegate}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"
}