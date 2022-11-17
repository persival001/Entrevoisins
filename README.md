
# Entrevoisin

"Entrevoisin" is an application to list neighbors, view their profile and add them to a list of favorites



## Deployment

To import a project in Android Studio, you should open Android Studio Project: Click on "Open an existing Android Studio project" to open the Android Studio Project.

 
Step 1 :

1 - Select your Android Studio Project directory from the 'Open file to Project' dialogue and click on the OK button.


2 - Wait until the project sync and builds project in Android Studio.


Step 2 :

Open Gradle or Eclipse ADT project : Click on “Import Project (Gradle, Eclipse ADT etc)” to open Eclipse build project for placing the project in Android studio without fail.

1 - Here, browse your project in Android Studio by navigating the location where you kept your project, your project’s folder will appear with an Android logo on it like this:

2 - Select the app and click OK, this will take some time for the Gradle to build, wait for the loading time. (You might get an error here stating the different SDK location, the error looks like this):

3 - In case of the above error just go to Project Directory and you’ll then find the file named “local.properties” in the root folder of your project. Open this file and scroll to the last 2 lines “ndk” and “SDK” and change the location with the one of your SDK and save the file.
Again open the Android Studio Project or else if already opened in Android studio, go to Gradle->Rebuild.


Step 3 :

To build and run your app: In the toolbar, select your app from the run configurations drop-down menu.

1 - From the target device drop-down menu, select the device you want to run your app.


Note: If you don't have any devices configured, then you need to either connect a device via USB or create an AVD to use the Android Emulator

° Click on the Run button in Toolbar or Select the Run menu in the menubar


Step 4 :

Edit project :

By default, while you import project in Android Studio, the Android Studio displays your project files in the Android view. This view does not reflect the actual file hierarchy on disk, but is organized by modules and file types to simplify navigation between key source files of your Android Studio Project, hiding certain files or directories that are not commonly used. Some of the structural changes compared to the structure on disk include the following:

1 - Shows all the project's build-related configuration files in a top-level Gradle Script group.
2 - Shows all manifest files for each module in a module-level group(when you have different manifest files for different product flavors and build types).
3 - Shows all alternative resource files in a single group, instead of in separate folders per resource qualifier. For example, all density versions of your launcher icon are visible side-by-side.

Within each Android app module, files are shown in the following groups:

1 - manifests: Contains the AndroidManifest.xml file.
2 - java: Contains the Java source code files, separated by package names, including JUnit test code.
3 - res: Contains all non-code resources, such as XML layouts, UI strings, and bitmap images, divided into corresponding sub-directories. For more information about all possible resource types, see Providing Resources.
4 - Gradle Scripts: Two types of Gradle file are used in android projects One type is Project level Gradle which contains application repositories, dependencies, and project-level variables, Second type are modules level Gradle which contain app version name, version code, min version, application ID, dependencies for this module, debug and release build types, build flavors, etc

## Screenshots
![Screenshot_20221117_161204](https://user-images.githubusercontent.com/89270238/202485562-b99e8b10-0202-4c8c-aea7-ff644de78b38.png)
![Screenshot_20221117_161218](https://user-images.githubusercontent.com/89270238/202485612-111eb23e-091c-4040-b258-4955e6ecdd50.png)
![Screenshot_20221117_161251](https://user-images.githubusercontent.com/89270238/202485623-9842696e-5fce-4f0d-a6e5-df2a7663ecaf.png)


