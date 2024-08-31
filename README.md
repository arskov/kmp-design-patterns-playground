# Playground for Kotlin Multiplatform code

## Configuration

1. For playing with mobil platforms install (assuming you are on the Mac machine):
   - Android Studio
   - XCode. To avoid "Xcode does not support simulator tests for ios_x64. Check that requested SDK is installed", select **MacOS** and **iOS** platforms for development during installation. Or you can install iOS development support later via "XCode Settings -> Platforms -> Install iOS platform".
2. Set up the Android SDK location via either ANDROID_HOME or create the local.properties file and put
    ```properties
    sdk.dir=/Users/USERNAME/Library/Android/sdk
    ```
3. Depending on the CPU architecture of your machine, if you are on an Intel Mac then use `iosX64` platform target, or if you are on Arm, then use `iosArm64` target in `build.gradle.kts`. 
 
## Running Tests

TBD