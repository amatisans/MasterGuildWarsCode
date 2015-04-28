package AXi;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Events {

	@FXML private AnchorPane anchorPaneMain;
	@FXML private TabPane tabPaneMain;
	@FXML private Tab tabGreenTab;
	@FXML private Tab tabBlueTab;
	@FXML private Tab tabRedTab;
	@FXML private Tab tabCenterTab;
	@FXML private Pane tabGreenPane;
	@FXML private Button testButton;
	@FXML private TextArea outputTextArea;
	@FXML private Tab greenTab;
	@FXML private CheckBox checkboxGreen;
	@FXML private CheckBox checkboxBlue;
	@FXML private CheckBox checkboxRed;
	@FXML private CheckBox checkboxCenter;
	@FXML private Slider sliderOpac;
	@FXML private TextField secondsUpdateTB;
	@FXML private Button updateButton;
	private int updateTime;
	
	//Greens labels
	@FXML private Label green00, green01, green02, green03, green04, green05, green06, green07, green08, green09, green010, green011, green012, green013, green014, green015, green016, green017, 
						green10, green11, green12, green13, green14, green15, green16, green17, green18, green19, green110, green111, green112, green113, green114, green115, green116, green117, 
						green20, green21, green22, green23, green24, green25, green26, green27, green28, green29,  green210, green211, green212, green213, green214, green215,  green216, green217;
	public Label[][] green;
	
	//Blues labels
	@FXML private Label blue00, blue01, blue02, blue03, blue04, blue05, blue06, blue07, blue08, blue09, blue010, blue011, blue012, blue013, blue014, blue015, blue016, blue017,
                        blue10, blue11, blue12, blue13, blue14, blue15, blue16, blue17, blue18, blue19, blue110, blue111, blue112, blue113, blue114, blue115, blue116, blue117,
	                    blue20, blue21, blue22, blue23, blue24, blue25, blue26, blue27, blue28, blue29, blue210, blue211, blue212, blue213, blue214, blue215, blue216, blue217;
	public Label[][] blue;

	//Reds labels
	@FXML private Label red00, red01, red02, red03, red04, red05, red06, red07, red08, red09, red010, red011, red012, red013, red014, red015, red016, red017,
					    red10, red11, red12, red13, red14, red15, red16, red17, red18, red19, red110, red111, red112, red113, red114, red115, red116, red117,
					    red20, red21, red22, red23, red24, red25, red26, red27, red28, red29, red210, red211, red212, red213, red214, red215, red216, red217;
	public Label[][] red;
	
	//Center labels
	@FXML private Label center00, center01, center02, center03, center04, center05, center06, center07, center08, center09, center010, center011, center012, center013, center014, center015, center016, center017, center018, center019, center020, center021,
						center10, center11, center12, center13, center14, center15, center16, center17, center18, center19, center110, center111, center112, center113, center114, center115, center116, center117, center118, center119, center120, center121, 
						center20, center21, center22, center23, center24, center25, center26, center27, center28, center29, center210, center211, center212, center213, center214, center215, center216, center217, center218, center219, center220, center221;
	private Label[][] center;
	
	private static java.util.Timer timer;
		
	private Tab[] tabs;
	private int greenCurTab, blueCurTab, redCurTab, centerCurTab, settingCurTab;
	@FXML private Label SettingsLblCenter, SettingsLblGreen, SettingsLblBlue, SettingsLblRed;
	
	@FXML private Label lblBarTop;

	@FXML
	private void handleButtonAction(ActionEvent event) {
		outputTextArea.appendText("Button Action\n");
	}

	@SuppressWarnings("null")
	@FXML
	public void initialize() {
		
		green = new Label[][] {
				{green00, green10, green20},
				{green01, green11, green21},
				{green02, green12, green22},
				{green03, green13, green23},
				{green04, green14, green24},
				{green05, green15, green25},
				{green06, green16, green26},
				{green07, green17, green27},
				{green08, green18, green28},
				{green09, green19, green29},
				{green010, green110, green210},
				{green011, green111, green211},
				{green012, green112, green212},
				{green013, green113, green213},
				{green014, green114, green214},
				{green015, green115, green215},
				{green016, green116, green216},
				{green017, green117, green217}};
		
		blue = new Label[][] {
				{blue00, blue10, blue20},
				{blue01, blue11, blue21},
				{blue02, blue12, blue22},
				{blue03, blue13, blue23},
				{blue04, blue14, blue24},
				{blue05, blue15, blue25},
				{blue06, blue16, blue26},
				{blue07, blue17, blue27},
				{blue08, blue18, blue28},
				{blue09, blue19, blue29},
				{blue010, blue110, blue210},
				{blue011, blue111, blue211},
				{blue012, blue112, blue212},
				{blue013, blue113, blue213},
				{blue014, blue114, blue214},
				{blue015, blue115, blue215},
				{blue016, blue116, blue216},
				{blue017, blue117, blue217}};
		
		red = new Label[][] {
				{red00, red10, red20},
				{red01, red11, red21},
				{red02, red12, red22},
				{red03, red13, red23},
				{red04, red14, red24},
				{red05, red15, red25},
				{red06, red16, red26},
				{red07, red17, red27},
				{red08, red18, red28},
				{red09, red19, red29},
				{red010, red110, red210},
				{red011, red111, red211},
				{red012, red112, red212},
				{red013, red113, red213},
				{red014, red114, red214},
				{red015, red115, red215},
				{red016, red116, red216},
				{red017, red117, red217}};
		
		center = new Label[][] {
				{center00, center10, center20},
				{center01, center11, center21},
				{center02, center12, center22},
				{center03, center13, center23},
				{center04, center14, center24},
				{center05, center15, center25},
				{center06, center16, center26},
				{center07, center17, center27},
				{center08, center18, center28},
				{center09, center19, center29},
				{center010, center110, center210},
				{center011, center111, center211},
				{center012, center112, center212},
				{center013, center113, center213},
				{center014, center114, center214},
				{center015, center115, center215},
				{center016, center116, center216},
				{center017, center117, center217},
				{center018, center118, center218},
				{center019, center119, center219},
				{center020, center120, center220},
				{center021, center121, center221}};
		
		/*************************
		 * Mess with Transparency
		 *************************/
		sliderOpac.setValue(Main.trans * 100);
		anchorPaneMain.setOpacity(sliderOpac.getValue() / 100);
		sliderOpac.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue){
				anchorPaneMain.setOpacity(sliderOpac.getValue() / 100);
				Main.saveNewTrans(sliderOpac.getValue() / 100);
			}
		});
		
		/*************************
		 * Mess with UpdateTime
		 *************************/
		secondsUpdateTB.setText(Integer.toString(Main.updateTime));
		updateTime = Main.updateTime;
		updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try{
            		Integer check = Integer.parseInt(secondsUpdateTB.getText());
            		updateTime = check;
            		
            		Main.saveNewUpdate(updateTime);
            		
            		timer.cancel();
            		timer = new java.util.Timer();
            		timer.schedule(new TimerTask() {
            		    public void run() {
            		         Platform.runLater(new Runnable() {
            		            public void run() {
            		        		updateInfo(Main.reload());
            		            }
            		        });
            		    }
            		}, updateTime * 1000, updateTime * 1000);
            	}catch(NumberFormatException nfe){
            		JOptionPane.showMessageDialog(null, "You must put a whole number, no text or symbols.", "Error Page", JOptionPane.INFORMATION_MESSAGE);
            	}

                	
            }
        });

		/***************************
		 * Get Check Boxes Working
		 ***************************/
		tabs = new Tab[]{tabPaneMain.getTabs().get(0),
						 tabPaneMain.getTabs().get(1),
						 tabPaneMain.getTabs().get(2), 
						 tabPaneMain.getTabs().get(3), 
						 tabPaneMain.getTabs().get(4)};
		//0=green
		//1=blue
		//2=red
		//3=center
		//4=settings
		
		//Green CheckBox
		checkboxGreen.setSelected(true);
		greenCurTab = 0;
		checkboxGreen.setOnAction((event) -> {
		boolean selected = checkboxGreen.isSelected();
			if(selected == false){
				updateTabOrder(greenCurTab);
				tabPaneMain.getTabs().remove(greenCurTab);
			}
			else{
				greenCurTab = tabPaneMain.getTabs().size();
				tabPaneMain.getTabs().add(tabPaneMain.getTabs().size(), tabs[0]);
			}
		});
		
		//Blue CheckBox
		checkboxBlue.setSelected(true);
		blueCurTab = 1;
		checkboxBlue.setOnAction((event) -> {
		boolean selected = checkboxBlue.isSelected();
			if(selected == false){
				updateTabOrder(blueCurTab);
				tabPaneMain.getTabs().remove(blueCurTab);
			}
			else{
				blueCurTab = tabPaneMain.getTabs().size();
				tabPaneMain.getTabs().add(tabPaneMain.getTabs().size(), tabs[1]);
			}
		});
		
		//Red CheckBox
		checkboxRed.setSelected(true);
		redCurTab = 2;
		checkboxRed.setOnAction((event) -> {
		boolean selected = checkboxRed.isSelected();
			if(selected == false){
				updateTabOrder(redCurTab);
				tabPaneMain.getTabs().remove(redCurTab);
			}
			else{
				redCurTab = tabPaneMain.getTabs().size();
				tabPaneMain.getTabs().add(tabPaneMain.getTabs().size(), tabs[2]);
			}
		});
		
		//Center CheckBox
		checkboxCenter.setSelected(true);
		centerCurTab = 3;
		checkboxCenter.setOnAction((event) -> {
		boolean selected = checkboxCenter.isSelected();
			if(selected == false){
				updateTabOrder(centerCurTab);
				tabPaneMain.getTabs().remove(centerCurTab);
			}
			else{
				centerCurTab = tabPaneMain.getTabs().size();
				tabPaneMain.getTabs().add(tabPaneMain.getTabs().size(), tabs[3]);
			}
		});
		
		
		/*********************
		 * Load in Node Data
		 *********************/
		tabGreenTab.setText(Main.wi.greenHome.map);
		SettingsLblGreen.setText(Main.wi.greenHome.map);
		tabGreenTab.setTooltip(new Tooltip("Green Server"));
		
		tabBlueTab.setText(Main.wi.blueHome.map);
		tabBlueTab.setTooltip(new Tooltip("Blue Server"));
		SettingsLblBlue.setText(Main.wi.blueHome.map);
		
		tabRedTab.setText(Main.wi.redHome.map);
		tabRedTab.setTooltip(new Tooltip("Red Server"));
		SettingsLblRed.setText(Main.wi.redHome.map);
		
		tabCenterTab.setText(Main.wi.center.map);
		tabCenterTab.setTooltip(new Tooltip("E. Battlegrounds Server"));
		//SettingsLblCenter.setText(Main.wi.center.map);
		
		updateInfo(Main.wi);
		
		
		
		
		timer = new java.util.Timer();

		timer.schedule(new TimerTask() {
		    public void run() {
		         Platform.runLater(new Runnable() {
		            public void run() {
		        		updateInfo(Main.reload());
		            }
		        });
		    }
		}, updateTime * 1000, updateTime * 1000);
		
	}
	
	private void updateTabOrder(int movedTab){
		if(movedTab < centerCurTab)
			centerCurTab--;
		if(movedTab < greenCurTab)
			greenCurTab--;
		if(movedTab < blueCurTab)
			blueCurTab--;
		if(movedTab < redCurTab)
			redCurTab--;
		
	}
	
	/****
	 * Calls updates for each tab 
	 * @param wi
	 */
	public void updateInfo (WorldInfo wi){	
    	System.out.println(updateTime);

		WorldInfo oldwi = Main.oldwi;
		
		updateTab(center, wi.center, oldwi.center);
		updateTab(green, wi.greenHome, oldwi.greenHome);
		updateTab(blue, wi.blueHome, oldwi.blueHome);
		updateTab(red, wi.redHome, oldwi.redHome); 
		

		
	}
	
	/***
	 * Loops to update each tab
	 * @param tab
	 * @param area
	 * @param oldArea
	 */
	private void updateTab(Label[][] tab, AreaInfo area, AreaInfo oldArea){
		for(int c=0; c < tab.length; c++){
			//CENTER
	    	Image image = new Image(getClass().getResourceAsStream(area.nodes[c].image));
	    	tab[c][0].setGraphic(new ImageView(image));
	    	if(takenFrom(oldArea.nodes[c], area.nodes[c])){
	    		tab[c][1].setText(area.nodes[c].title + " Taken From " + oldArea.nodes[c].info);
	    		tab[c][1].setTextFill(Color.RED);
	    		System.out.println(center[c][1].getText());
	    	}else{
	    		tab[c][1].setText(area.nodes[c].title);
	    		tab[c][1].setTextFill(Color.BLACK);
	    	}
	    	tab[c][2].setText(area.nodes[c].info);
		}
		
	}
	private boolean takenFrom(GWNode oldNode, GWNode newNode){
		if(newNode.info.equals(oldNode.info))
			return false;
		else {
			return true;
		}
	}
}
