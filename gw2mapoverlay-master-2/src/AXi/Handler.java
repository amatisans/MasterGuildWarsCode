package AXi;

import java.io.IOException;

import org.json.JSONException;

public class Handler {
	
	private WorldInfo wi;
	private String server;

	public void start() throws IOException, JSONException{
		//Load in preferences
		//Initialize setting
		load();
		//Update JSON
		jsonLoad();
		//Launch GUI
		launch();
		//Initiate recurring JSON call
		//Wait for close
		//Save preferences
		//Close successfully
		
	}
	
	/*
	 * This is the method that will call and handle
	 * the loading of saved preferences
	 */
	public void load(){
		InputDialogWithDropdownListbox idwdl =  new InputDialogWithDropdownListbox();
		server = idwdl.HomeWorld();
	}
	
	/*
	 * This is the method that will call and handle
	 * the loading of JSON data
	 */
	public void jsonLoad() throws IOException, JSONException{
		loadJSON lj = new loadJSON();
		wi = lj.load(server);
	}
	
	/*
	 * This is the method that will call and handle
	 * the updating of JSON on initial load as well
	 * as be called from the recurring call
	 */
	public void update(){
		
	}
	
	/*
	 * This is the method that will call and handle
	 * the displaying of the GUI
	 */
	public void launch(){
		MainGUI gui = new MainGUI(wi);
		gui.display();
	}
	
	/*
	 * This is the method that will call and handle
	 * the recalling of update()
	 */
	public void reUpdate(){
		
	}
	
	/*
	 * This is the method that will call and handle
	 * the saving of custom preferences
	 */
	public void save(){
		
	}
	
}
