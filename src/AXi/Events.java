package AXi;

import java.awt.event.ActionListener;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

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
	@FXML private Slider sliderOpac;
	
	//Greens labels
	@FXML private Label green00;
	@FXML private Label green01;
	@FXML private Label green02;
	@FXML private Label green03;
	@FXML private Label green04;
	@FXML private Label green05;
	@FXML private Label green06;
	@FXML private Label green07;
	@FXML private Label green08;
	@FXML private Label green09;
	@FXML private Label green010;
	@FXML private Label green011;
	@FXML private Label green012;
	@FXML private Label green013;
	@FXML private Label green014;
	@FXML private Label green015;
	@FXML private Label green016;
	@FXML private Label green017;
	@FXML private Label green10;
	@FXML private Label green11;
	@FXML private Label green12;
	@FXML private Label green13;
	@FXML private Label green14;
	@FXML private Label green15;
	@FXML private Label green16;
	@FXML private Label green17;
	@FXML private Label green18;
	@FXML private Label green19;
	@FXML private Label green110;
	@FXML private Label green111;
	@FXML private Label green112;
	@FXML private Label green113;
	@FXML private Label green114;
	@FXML private Label green115;
	@FXML private Label green116;
	@FXML private Label green117;
	@FXML private Label green20;
	@FXML private Label green21;
	@FXML private Label green22;
	@FXML private Label green23;
	@FXML private Label green24;
	@FXML private Label green25;
	@FXML private Label green26;
	@FXML private Label green27;
	@FXML private Label green28;
	@FXML private Label green29;
	@FXML private Label green210;
	@FXML private Label green211;
	@FXML private Label green212;
	@FXML private Label green213;
	@FXML private Label green214;
	@FXML private Label green215;
	@FXML private Label green216;
	@FXML private Label green217;
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
	
	Timer timer;
		
	Tab savedTab;

	@FXML
	private void handleButtonAction(ActionEvent event) {
		outputTextArea.appendText("Button Action\n");
	}

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
		
		/*************************
		 * Mess with Transparency
		 *************************/
		anchorPaneMain.setOpacity(1.0);
		sliderOpac.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue){
				anchorPaneMain.setOpacity(sliderOpac.getValue() / 100);
			}
		});

		/***************************
		 * Get Check Boxes Working
		 ***************************/
		checkboxGreen.setSelected(true);
		savedTab = tabPaneMain.getTabs().get(0);
		checkboxGreen.setOnAction((event) -> {
		boolean selected = checkboxGreen.isSelected();
			if(selected == false){
				tabPaneMain.getTabs().remove(1);
			}
			else{
				tabPaneMain.getTabs().add(1, savedTab);
			}
		});
		
		/*********************
		 * Load in Node Data
		 *********************/
		tabGreenTab.setText(Main.wi.greenHome.map);
		tabGreenTab.setTooltip(new Tooltip("Green Server"));
		tabBlueTab.setText(Main.wi.blueHome.map);
		tabBlueTab.setTooltip(new Tooltip("Blue Server"));
		tabRedTab.setText(Main.wi.redHome.map);
		tabRedTab.setTooltip(new Tooltip("Red Server"));
		tabCenterTab.setText(Main.wi.center.map);
		tabCenterTab.setTooltip(new Tooltip("E. Battlegrounds Server"));
		updateInfo(Main.wi);
		//timer = new Timer(2000, (ActionListener) new UpdateTask());
		//timer.setInitialDelay(2000);
		//timer.start();
		
		java.util.Timer timer = new java.util.Timer();

		timer.schedule(new TimerTask() {
		    public void run() {
		         Platform.runLater(new Runnable() {
		            public void run() {
		        		updateInfo(Main.wi);
		            }
		        });
		    }
		}, 2000, 2000);
	}
	
	class UpdateTask extends TimerTask {
		public void run(){
			//updateInfo(Main.wi);
		}
		
	}
	
	public void updateInfo (WorldInfo wi){	
		System.out.println(green[2][0].getId());
	    for(int i=0; i < green.length; i++){
	    	Image greenImage = new Image(getClass().getResourceAsStream(wi.greenHome.nodes[i].image));
	    	green[i][0].setGraphic(new ImageView(greenImage));
	    	green[i][1].setText(wi.greenHome.nodes[i].title);
	    	green[i][2].setText(wi.greenHome.nodes[i].info);
	    	
	    	Image blueImage = new Image(getClass().getResourceAsStream(wi.blueHome.nodes[i].image));
	    	blue[i][0].setGraphic(new ImageView(blueImage));
	    	blue[i][1].setText(wi.blueHome.nodes[i].title);
	    	blue[i][2].setText(wi.blueHome.nodes[i].info);
	    	
	    	Image redImage = new Image(getClass().getResourceAsStream(wi.redHome.nodes[i].image));
	    	red[i][0].setGraphic(new ImageView(redImage));
	    	red[i][1].setText(wi.redHome.nodes[i].title);
	    	red[i][1].setText(wi.redHome.nodes[i].info);
	    }
	    
	}
	

	@FXML
	private void handleAction(ActionEvent event) {
		// Tab savedTab = tabpaneMain.getTabs().get(0);

		System.out.print("OMG");
		boolean selected = checkboxGreen.isSelected();
		if (selected == false) {
			tabPaneMain.getTabs().remove(0);
		} else {
			tabPaneMain.getTabs().add(0, savedTab);
		}
	}
}
