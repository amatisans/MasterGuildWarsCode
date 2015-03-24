package AXi;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class InputDialogWithDropdownListbox {
	//LIST OF NA SERVERS
	  public static String HomeWorld() {
	    String[] choices = { "Anvil Rock", "Blackgate", "Borlis Pass", 
	    		"Crystal Desert", "Darkhaven", "Devona's Rest", 
	    		"Dragonbrand" , "Ehmry Bay" , "Eredon Terrace", "Ferguson's Crossing",
	    		"Fort Aspenwood", "Gate of Madness", "Henge of Denravi", "Isle of Janthir",
	    		"Jade Quarry", "Kaineng", "Maguuma", "Northern Shiverpeaks", "Sanctum of Rall",
	    		"Sea of Sorrows", "Sorrow's Furnace", "Stormbluff Isle", "Tarnished Coast", 
	    		"Yak's Bend"};
	    String input = (String) JOptionPane.showInputDialog(null, "Please Select Server:",
	        "From Where Do You Hail?", JOptionPane.QUESTION_MESSAGE, createImageIcon("./Icons/Other/LOGO.png"),
	        choices, // Array of choices
	        choices[1]); // Initial choice
	    //System.out.println(input);
	    return input;
	  }
	  
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
