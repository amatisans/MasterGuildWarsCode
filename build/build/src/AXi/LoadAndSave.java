package AXi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoadAndSave {
	
	//File file = new File(System.getProperty("user.dir"), "myfile.txt");
	
	private double trans;
	private String server;
	private int updateTime;
	
	public void load() throws IOException{
		// Open the file
		FileInputStream fstream = new FileInputStream("GWOSavePreferences.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String instrg;

		//Read File Line By Line
		if((instrg = br.readLine()) != null)   {
			trans = Double.parseDouble(instrg);
		}
		
		if((instrg = br.readLine()) != null)   {
			server = instrg;
		}
		
		if((instrg = br.readLine()) != null)   {
			updateTime = Integer.parseInt(instrg);
		}

		//Close the input stream
		br.close();
		
	}
	
	public void save()throws IOException
	{
		  File file = new File ("GWOSavePreferences.txt");
		  BufferedWriter out = new BufferedWriter(new FileWriter(file)); 
		  out.write(Double.toString(trans));
		  out.newLine();
		  out.write(server);
		  out.newLine();
		  out.write(Integer.toString(updateTime));
		  out.close();
	}
	
	public boolean isFileThere(){
		File f = new File("GWOSavePreferences.txt");
		if(f.exists() && !f.isDirectory()) {
			return true;
		}else{
			return false;
		}
	}
	
	

	
	
	public void setTrans(Double _trans){
		trans = _trans;
	}
	public void setServer(String _server){
		server = _server;
	}
	public void setUpDateTime(int _updateTime){
		updateTime = _updateTime;
	}
	public int getUpDateTime(){
		return updateTime;
	}
	public Double getTrans(){
		return trans;
	}
	public String getServer(){
		return server;
	}

}
