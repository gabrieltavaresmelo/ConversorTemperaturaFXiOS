package br.com.temperatura;

import br.com.temperatura.controller.ConversorOverviewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApplication extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Conversor de Temperatura");
		
		try {
			rootLayout = new BorderPane();			
			Scene scene = new Scene(rootLayout);
			
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		showConversorOverview();
	}

	private void showConversorOverview() {
		try {			
			ConversorOverviewController controller = new ConversorOverviewController();
	        rootLayout.setCenter(controller.getConversorNode());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
