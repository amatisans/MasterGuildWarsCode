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
	public static double trans = 0.9;
	public static int updateTime = 10;
	public static WorldInfo wi;
	public static WorldInfo oldwi;
	
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
		LoadAndSave ls = new LoadAndSave();

		if(ls.isFileThere() == false){
			//Load Server Selection
			ServerSelection ss = new ServerSelection();
			server = ss.HomeWorld();
			
			ls.setServer(server);
			ls.setTrans(trans);
			ls.setUpDateTime(updateTime);
			try {
				ls.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				ls.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			server = ls.getServer();
			trans = ls.getTrans();
			updateTime = ls.getUpDateTime();
		}
		//Load JSON
		loadJSON lj = new loadJSON();
		try {
			wi = lj.load(server);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}		
		
		oldwi = wi;
		
		Application.launch(Main.class, args);
	}

	public static WorldInfo reload() {
		oldwi = wi;
		loadJSON lj = new loadJSON();
		try {
			wi = lj.load(server);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}	
		
		return wi;
	}

	public static void saveNewTrans(double _trans) {
		trans = _trans;
		
		LoadAndSave ls = new LoadAndSave();
		ls.setServer(server);
		ls.setTrans(trans);
		ls.setUpDateTime(updateTime);
		try {
			ls.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveNewUpdate(int _updateTime) {
		updateTime = _updateTime;
		
		LoadAndSave ls = new LoadAndSave();
		ls.setServer(server);
		ls.setTrans(trans);
		ls.setUpDateTime(updateTime);
		try {
			ls.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}