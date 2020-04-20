# DockFX - Demo

This `README.md` provides additional information for running the DockFX Demo applications in Java 11.

## Developer Setup

## JavaFX Runtime

If you get the error `Error: JavaFX runtime components are missing, and are required to run this application`,
this is because the the `public static void main(String[] args)` method is defined in your Application-extension, 
running the project will require JavaFX in your module path on startup.

See [this stack overflow post](https://stackoverflow.com/questions/55760343/error-javafx-runtime-components-are-missing-javafx-11-and-openjdk-11-and-ecli)
for more details.

To achieve this you need to add the `--module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml,javafx.web` 
to your VM Arguments, see section below.

### VM Arguments

To run the DockFX Demo applications from Eclipse (and possibly other IDEs) you will need to add some **VM Arguments**.

To do this:  

1. **right click** on the *.java file you want to run (i.e. `DockFX.java`, or `TwoDockPanes.java`) and select
Run As --> Run configurations.
2. Select the **Arguments** tab, then copy the arguments listed and paste them into the **VM Arguments** text area, and select **Apply**.
3. You can then run the file using the **Run** button, or any of the other Eclipse shortcuts.


```
	--module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml,javafx.web 
	--add-exports=javafx.graphics/com.sun.javafx.css=ALL-UNNAMED 
	--add-exports=javafx.graphics/com.sun.javafx.scene.input=ALL-UNNAMED 
	--add-exports=javafx.graphics/com.sun.javafx.util=ALL-UNNAMED 
	--add-exports=javafx.controls/com.sun.javafx.scene.control.behavior=ALL-UNNAMED 
	--add-exports=javafx.controls/com.sun.javafx.scene.control=ALL-UNNAMED
	--add-exports=javafx.controls/com.sun.javafx.scene.control.skin.resources=ALL-UNNAMED
```