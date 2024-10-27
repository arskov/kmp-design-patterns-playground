# Playground for Kotlin Multiplatform (Native) code

The purpose of this sample project is to play with different build options for Shared Library and Apple Framework. Test different GC options, observe GC behaviour.

## Build For Native/Apple
Run `./gradlew assemble`. Expect binaries in the (`X64` - Intel CPU machine, `Arm64` - M1,2,3 machine) 
- A shared library: `lib/build/bin/macos[X64,Arm64]/KmpSampleDebugShared/`
- A framework: `lib/build/bin/macos[X64,Arm64]/KmpSampleDebugFramework/`

**Note!**. The build configuration of this project contains `-Xruntime-logs=gc=info` compilation flag, which enables GC log in the stderr.

## Use the shared library or the framework

- The [XCode CLI C++ (KMP Shared Library)](https://github.com/arskov/kmp-cpp) project contains sample code that uses a shared library built from this KMP library in the smaple CLI C++ executable.
- The [XCode CLI Swift (KMP Appple Framework)](https://github.com/arskov/kmp-swift) project contains sample code that uses an XCFramework built by this project  


## [TBD] Mobile Configuration

1. For playing with mobil platforms install (assuming you are on the Mac machine):
   - Android Studio
   - XCode. To avoid "Xcode does not support simulator tests for ios_x64. Check that requested SDK is installed", select **MacOS** and **iOS** platforms for development during installation. Or you can install iOS development support later via "XCode Settings -> Platforms -> Install iOS platform".
2. Set up the Android SDK location via either ANDROID_HOME or create the local.properties file and put
    ```properties
    sdk.dir=/Users/USERNAME/Library/Android/sdk
    ```
3. Depending on the CPU architecture of your machine, if you are on an Intel Mac then use `iosX64` platform target, or if you are on Arm, then use `iosArm64` target in `build.gradle.kts`. 
