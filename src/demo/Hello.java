package demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Hello extends Application {
	//private static boolean checkLauncher = true;
	
	public static void main(String[] args) {
		//checkField("sun.launcher.LauncherHelper$FXHelper", "fxLaunchName");
		/*
		if (checkLauncher) {
			checkLauncher = false;
			if (isNativeImage()) {
				if (launchApplication(args))
					return;
			}
		}
		*/
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Hello!");
		Button btn = new Button();
		btn.setText("Hello");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		
		Scene s = new Scene(root, 300, 250);
		
		stage.setScene(s);
		
		stage.show();
	}
	/*
	static boolean isNativeImage() {
		return "executable".equals(System.getProperty("org.graalvm.nativeimage.kind"));
	}

	static void checkField(String className, String fieldName) {
		try {
			Class<?> clazz = Class.forName(className);
			Field field = clazz.getField(fieldName);
			if (!field.canAccess(null))
				field.setAccessible(true);
			System.out.println(field.getName() + ": " + String.valueOf(field.get(null)));
		} catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException | RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	static void checkFields(String className) {
		try {
			Class<?> clazz = Class.forName(className);
			Field[] fields = clazz.getDeclaredFields();
			if (fields != null) {
				for (Field field : fields) {
					int modifiers = field.getModifiers();
					if (Modifier.isStatic(modifiers) && !Modifier.isFinal(modifiers)) {
						if (!field.canAccess(null))
							field.setAccessible(true);
						System.out.println(field.getName() + ": " + String.valueOf(field.get(null)));
					}
				}
			}
		} catch (ClassNotFoundException | IllegalAccessException | RuntimeException e) {
			e.printStackTrace();
		}
	}
	/ *
	private static boolean launchApplication(String[] args) {
		try {
			Class<?> clazz = Class.forName("sun.launcher.LauncherHelper$FXHelper");
			Field field = clazz.getDeclaredField("fxLaunchName");
			if (!field.canAccess(null))
				field.setAccessible(true);
			if (field.get(null) == null) {
				clazz = Class.forName("com.sun.javafx.application.LauncherImpl");
				Method method = clazz.getMethod("launchApplication", String.class, String.class, String[].class);
				method.invoke(null, new Object[] { Hello.class.getCanonicalName(), "LM_CLASS", args } );
				/ *
				Method method = clazz.getDeclaredMethod("setFXLaunchParameters", String.class, int.class);
				if (!method.canAccess(null))
					method.setAccessible(true);
				
				method.invoke(null, new Object[] { Hello.class.getCanonicalName(), 1 } );
				
				method = clazz.getMethod("main", String[].class);
				method.invoke(null, new Object[] { args } );
				* /
				return true;
			}
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private static void check() {
		try {
			Class<?> clazz = Class.forName("sun.launcher.LauncherHelper$FXHelper");
			System.out.println(clazz);
			if (clazz != null) {
				Field field = clazz.getDeclaredField("fxLaunchName");
				if (!field.canAccess(null))
					field.setAccessible(true);
				System.out.println(field + ": " + String.valueOf(field.get(null)));
			}
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	//*/
}
