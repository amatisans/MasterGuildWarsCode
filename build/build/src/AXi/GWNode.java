package AXi;


public class GWNode {
	
	String image; 
	String title; 
	String info;

	public GWNode(String _image, String _title, String _info){
		image = _image;
		title = _title;
		info = _info;
		
	}
	
	public void printNode(){
		System.out.println("Node " + title + " belongs to " + info);
	}

}
