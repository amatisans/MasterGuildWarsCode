package AXi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Tabs{

	public String    title;
	public ImageIcon image;
	public String[]  text;
	public String    toolTip;
	public JPanel    panel;
	
	public JScrollPane scrollFrame;

	
	Node[] node;
	
	public Tabs(String _title, ImageIcon _image, String[] _text, String _toolTip){
		title = _title;
		image = _image;
		text = _text;
		toolTip = _toolTip;
		
	}
	
	public Tabs(String _title, ImageIcon _image, Node[] _node, String _toolTip){
		title = _title;
		image = _image;
		node = _node;
		toolTip = _toolTip;
	}
	
	public void makeTextPanel() {
		panel = new JPanel(false);
		panel.setLayout(new GridLayout((text.length/3), 3));
		for(int i=0; i<text.length; i++){
			JLabel filler = new JLabel(text[i]);
			panel.add(filler);
		}
		scrollFrame = new JScrollPane(panel);
		panel.setAutoscrolls(true);
	}
	
	public void makeNodePanel() {
		panel = new JPanel(false);
		panel.setLayout(new GridLayout((node.length), 1));
		for(int i=0; i<node.length; i++){
			JPanel setter = new JPanel(new BorderLayout());
			setter.add((new JLabel(node[i].image)), BorderLayout.WEST);
			setter.add((new JLabel(node[i].title)), BorderLayout.CENTER);
			setter.add((new JLabel(node[i].info)), BorderLayout.EAST);
			panel.add(setter);
			
		}
		scrollFrame = new JScrollPane(panel);
		panel.setAutoscrolls(true);
	}

}
