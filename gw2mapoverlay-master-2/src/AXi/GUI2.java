package AXi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI2 extends JPanel {

	JFrame frame = new JFrame();
	public JButton tab1;
	public JButton tab2;
	public JButton tab3;
	public JButton tab4;
	public JButton settings;

	public JPanel groupPanel = new JPanel();
	public JScrollPane jsf = new JScrollPane();

	//int leftRight = 850;
	//int upDown = 800;

	String[] text = { "1.1", "1.2", "1.3", "2.1", "2.2", "2.3", "3.1", "3.2",
			"3.3", "4.1", "4.2", "4.3", "5.1", "5.2", "5.3", "6.1", "6.2",
			"6.3", "1.1", "1.2", "1.3", "2.1", "2.2", "2.3", "3.1", "3.2",
			"3.3", "4.1", "4.2", "4.3", "5.1", "5.2", "5.3", "6.1", "6.2",
			"6.3", "1.1", "1.2", "1.3", "2.1", "2.2", "2.3", "3.1", "3.2",
			"3.3", "4.1", "4.2", "4.3", "5.1", "5.2", "5.3", "6.1", "6.2",
			"6.3", "1.1", "1.2", "1.3", "2.1", "2.2", "2.3", "3.1", "3.2",
			"3.3", "4.1", "4.2", "4.3", "5.1", "5.2", "5.3", "6.1", "6.2",
			"6.3", "1.1", "1.2", "1.3", "2.1", "2.2", "2.3", "3.1", "3.2",
			"3.3", "4.1", "4.2", "4.3", "5.1", "5.2", "5.3", "6.1", "6.2",
			"6.3", "1.1", "1.2", "1.3", "2.1", "2.2", "2.3", "3.1", "3.2",
			"3.3", "4.1", "4.2", "4.3", "5.1", "5.2", "5.3", "6.1", "6.2",
			"6.3", "1.1", "1.2", "1.3", "2.1", "2.2", "2.3", "3.1", "3.2",
			"3.3", "4.1", "4.2", "4.3", "5.1", "5.2", "5.3", "6.1", "6.2",
			"6.3", "1.1", "1.2", "1.3", "2.1", "2.2", "2.3", "3.1", "3.2",
			"3.3", "4.1", "4.2", "4.3", "5.1", "5.2", "5.3", "6.1", "6.2",
			"6.3", "1.1", "1.2", "1.3", "2.1", "2.2", "2.3", "3.1", "3.2",
			"3.3", "4.1", "4.2", "4.3", "5.1", "5.2", "5.3", "6.1", "6.2",
			"6.3", "1.1", "1.2", "1.3", "2.1", "2.2", "2.3", "3.1", "3.2",
			"3.3", "4.1", "4.2", "4.3", "5.1", "5.2", "5.3", "6.1", "6.2",
			"6.3", "1.1", "1.2", "1.3", "2.1", "2.2", "2.3", "3.1", "3.2",
			"3.3", "4.1", "4.2", "4.3", "5.1", "5.2", "5.3", "6.1", "6.2",
			"6.3" };
	String[] text2 = { "Much WOW", "very seperated", "Such Tab" };
	String[] emptyText = { "", "", "" };

	ImageIcon icon = createImageIcon("");

	public GUI2() {
		tab1 = new JButton("Tab1");
		tab1.addActionListener(new tab1Listener());
		// tab1.setBackground(new Color(0, 0, 0, 0));

		tab2 = new JButton("Tab2");
		tab2.addActionListener(new tab2Listener());
		// tab2.setBackground(new Color(0, 0, 0, 0));

		tab3 = new JButton("Tab3");
		tab3.addActionListener(new tab3Listener());
		// tab3.setBackground(new Color(0, 0, 0, 0));

		tab4 = new JButton("+");
		tab4.addActionListener(new plusListener());
		// tab4.setBackground(new Color(0, 0, 0, 0));

		settings = new JButton("settings");
		settings.addActionListener(new settingsListener());
		// settings.setBackground(new Color(0, 0, 0, 0));

		Tabs p1 = new Tabs("Tab 1", icon, text, "");
		p1.makeTextPanel();
		//p1.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));

		jsf = p1.scrollFrame;

		groupPanel.setLayout(new FlowLayout());
		groupPanel.add(tab1);
		groupPanel.add(tab2);
		groupPanel.add(tab3);
		groupPanel.add(settings);

		setLayout(new BorderLayout());
		add(groupPanel, BorderLayout.NORTH);
		add(jsf, BorderLayout.SOUTH);
	}

	public void display() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.add(this, BorderLayout.CENTER);

		// set ALL to clear //DONT Do
		// frame.setUndecorated(true);

		// set to clear
		// frame.setBackground(new Color(0, 0, 0, 0));

		// Set's the window to be "always on top"
		frame.setAlwaysOnTop(true);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	private class tab1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Tabs p1 = new Tabs("Tab 1", icon, text, "");
			p1.makeTextPanel();
			//p1.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));

			jsf = p1.scrollFrame;
			JPanel jp = new JPanel();
			jp.setLayout(new BorderLayout());
			jp.add(groupPanel, BorderLayout.NORTH);
			jp.add(jsf, BorderLayout.SOUTH);

			frame.remove(jsf);
			// frame.add(jp, BorderLayout.CENTER);
			frame.add(jsf);

			// set ALL to clear //DONT Do
			// frame.setUndecorated(true);

			// set to clear
			frame.setBackground(new Color(0, 0, 0, 0));

			// Set's the window to be "always on top"
			frame.setAlwaysOnTop(true);

			// Display the window.
			frame.pack();
			frame.setVisible(true);

		}
	}

	private class tab2Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.remove(jsf);

			Tabs p2 = new Tabs("Tab 2", icon, text2, "");
			p2.makeTextPanel();
			//p2.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));

			jsf = p2.scrollFrame;
			JPanel jp = new JPanel();
			jp.setLayout(new BorderLayout());
			jp.add(groupPanel, BorderLayout.NORTH);
			jp.add(jsf, BorderLayout.SOUTH);

			// frame.add(jp, BorderLayout.CENTER);
			frame.add(jsf);

			// set ALL to clear //DONT Do
			// frame.setUndecorated(true);

			// set to clear
			frame.setBackground(new Color(0, 0, 0, 0));

			// Set's the window to be "always on top"
			frame.setAlwaysOnTop(true);

			// Display the window.
			frame.pack();
			frame.setVisible(true);
		}
	}

	private class tab3Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Tabs p3 = new Tabs("Tab 3", icon, emptyText, "");
			p3.makeTextPanel();
			//p3.scrollFrame.setPreferredSize(new Dimension(leftRight, upDown));

			jsf = p3.scrollFrame;
			JPanel jp = new JPanel();
			jp.setLayout(new BorderLayout());
			jp.add(groupPanel, BorderLayout.NORTH);
			jp.add(jsf, BorderLayout.SOUTH);

			frame.remove(jsf);
			// frame.add(jp, BorderLayout.CENTER);
			frame.add(jsf);

			// set ALL to clear //DONT Do
			// frame.setUndecorated(true);

			// set to clear
			frame.setBackground(new Color(0, 0, 0, 0));

			// Set's the window to be "always on top"
			frame.setAlwaysOnTop(true);

			// Display the window.
			frame.pack();
			frame.setVisible(true);
		}
	}

	private class plusListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

		}
	}

	private class settingsListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

		}
	}

	/*
	 * Returns an ImageIcon, or null if the path was invalid.
	 */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = MainGUI.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

}
