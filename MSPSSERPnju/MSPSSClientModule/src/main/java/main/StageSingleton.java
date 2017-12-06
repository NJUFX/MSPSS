package main;

import javafx.stage.Stage;

public class StageSingleton {
	private static Stage stage;

	public static synchronized Stage getStage() {
		return stage;
	}

	public static synchronized void setStage(Stage s) {
		stage = s;
	}
}
