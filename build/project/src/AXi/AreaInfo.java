package AXi;

public class AreaInfo {
	public String map;
	public int redScore;
	public int blueScore;
	public int greenScore;
	
	public GWNode[] nodes = new GWNode[19];
	
	public AreaInfo(String _map, int _red, int _blue, int _green, GWNode[] _nodes){
		map = _map;
		redScore = _red;
		blueScore = _blue;
		greenScore = _green;
		nodes = _nodes;
		
	}
	
	public void printArea(){
		System.out.println("Red's score for " + map + ": " + redScore);
		System.out.println("Blue's score for " + map + ": " + blueScore);
		System.out.println("Green's score for " + map + ": " + greenScore);
		
		for (int i=0; i<nodes.length; i++){
			nodes[i].printNode();
		}
		System.out.println("");
		
	}

}
