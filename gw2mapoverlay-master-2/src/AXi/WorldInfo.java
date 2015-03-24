package AXi;

import org.json.JSONArray;

public class WorldInfo {
	
	public int redScore;
	public int blueScore;
	public int greenScore;

	public AreaInfo redHome;
	public AreaInfo greenHome;
	public AreaInfo blueHome;
	public AreaInfo center;
	
	public WorldInfo (int _redScore, int _blueScore, int _greenScore,
					  AreaInfo _redHome, AreaInfo _greenHome, AreaInfo _blueHome, AreaInfo _center){
		
		redScore = _redScore;
		blueScore = _blueScore;
		greenScore = _greenScore;
		
		redHome = _redHome;
		greenHome = _greenHome;
		blueHome = _blueHome;
		center = _center;
		
	}
	
	public void printWorld(){
		System.out.println("Red's score: " + redScore);
		System.out.println("Blue's score: " + blueScore);
		System.out.println("Green's score: " + greenScore);
		System.out.println();
		
		System.out.println("RedHome");
		redHome.printArea();
		
		System.out.println("GreenHome");
		greenHome.printArea();
		
		System.out.println("BlueHome");
		blueHome.printArea();
		
		System.out.println("Center");
		center.printArea();	
	}
	
}
