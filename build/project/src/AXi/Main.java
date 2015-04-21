package AXi;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.json.JSONException;

public class Main extends Application {
	private static String server;
	public static WorldInfo wi;
	
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("gw2mapoverlayv2.fxml"));
			Scene scene = new Scene(root);
			scene.setFill(null);
			stage.setScene(scene);
			stage.setOpacity(0.9);
			stage.setAlwaysOnTop(true);
			stage.initStyle(StageStyle.UTILITY);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//Load Preferences
		//if(no preferences){
			//Load Server Selection
			ServerSelection ss = new ServerSelection();
			server = ss.HomeWorld();
		//}else
			//server = preferences.server
			
		//Load JSON
		loadJSON lj = new loadJSON();
		try {
			wi = lj.load(server);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}		
		
		Application.launch(Main.class, args);
	}
}
