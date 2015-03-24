package AXi;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Node {
	
	ImageIcon image; 
	String title; 
	String info;

	public Node(ImageIcon _image, String _title, String _info){
		image = _image;
		title = _title;
		info = _info;
		
	}
	
	public void printNode(){
		System.out.println("Node " + title + " belongs to " + info);
	}

}
