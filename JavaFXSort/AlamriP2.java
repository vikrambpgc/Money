package JavaFXSort;

//Alamri, Rabab
//Project 2: Sorting
//CS 110-022

import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleButton;

public class AlamriP2 extends Application {
	public static void main(String[] args) {
		AlamriP2.launch(args);
	}

	private static final int BAR_COUNT = 16, GEN_MIN = 1, GEN_MAX = 64;

	private static final String COLOR_PROCESS = "-fx-bar-fill: #eeb111",
			COLOR_INITIAL = "-fx-bar-fill: #00447c",
			COLOR_PROCESS_GREEN = "-fx-bar-fill: #00ff00",
			COLOR_FINAL = "-fx-bar-fill: #ff0000";

	private static final String[] ALGORITHMS = { "Swap Halves", "Full Reverse",
		"Bubble Sort", "Selection Sort", "Insertion Sort"};

	private static int DELAY_MILLIS = 1000;

	private ArrayList<XYChart.Data<String, Number>> bars;

	@Override
	public void start(Stage stage) {
		stage.setTitle("Animated Algorithms");
		stage.setWidth(800);
		stage.setHeight(600);

		final BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10));

		final BarChart<String, Number> chart = new BarChart<String, Number>(
				new CategoryAxis(), new NumberAxis(0, GEN_MAX, 0));
		chart.setLegendVisible(false);
		chart.getYAxis().setTickLabelsVisible(false);
		chart.getYAxis().setOpacity(0);
		chart.getXAxis().setTickLabelsVisible(false);
		chart.getXAxis().setOpacity(0);
		chart.setHorizontalGridLinesVisible(false);
		chart.setVerticalGridLinesVisible(false);

		XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
		chart.getData().add(data);
		bars = new ArrayList<XYChart.Data<String, Number>>();
		for (int i = 0; i < BAR_COUNT; i++) {
			XYChart.Data<String, Number> bar = new XYChart.Data<>(
					Integer.toString(i), GEN_MIN);
			bars.add(bar);
			data.getData().add(bar);
			bar.getNode().setStyle(COLOR_INITIAL);
		}

		final FlowPane inputs = new FlowPane();
		inputs.setHgap(5);
		inputs.setVgap(5);
		

	    
		EventHandler<ActionEvent> randomizer = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				randomizeAll();
			}
		};
		
		// Start of toggle
		final ToggleGroup delayToggleGroup = new ToggleGroup();
		ToggleButton fifty = new ToggleButton("50 ms");
		fifty.setUserData(50);
	    fifty.setToggleGroup(delayToggleGroup);
	    
	    ToggleButton twoFifty = new ToggleButton("250 ms");
	    twoFifty.setUserData(250);
	    twoFifty.setToggleGroup(delayToggleGroup);
	    ToggleButton fiveHundred = new ToggleButton("500 ms");
	    fiveHundred.setUserData(500);
	    fiveHundred.setToggleGroup(delayToggleGroup);
	    ToggleButton sevenFifty = new ToggleButton("750 ms");
	    sevenFifty.setUserData(750);
	    sevenFifty.setToggleGroup(delayToggleGroup);
	    sevenFifty.setSelected(true);
	    
	     HBox hbox1 = new HBox();
	     hbox1.getChildren().add(fifty);
	     hbox1.getChildren().add(twoFifty);
	     hbox1.getChildren().add(fiveHundred);
	     hbox1.getChildren().add(sevenFifty);

	     delayToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	    	    public void changed(ObservableValue<? extends Toggle> ov,
	    	        Toggle old_toggle, Toggle new_toggle) {
	    	            if (delayToggleGroup.getSelectedToggle() != null) {
	    	                   DELAY_MILLIS = (Integer) delayToggleGroup.getSelectedToggle().getUserData();
	    	            }                
	    	        }
	    });

	    //end of toggle
	     
		final Button random = new Button("Randomize");
		random.setOnAction(randomizer);
		inputs.getChildren().add(random);

		EventHandler<ActionEvent> runner = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				(new Thread() {
					public void run() {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								inputs.setDisable(true);
							}
						});
						callBarAlgorithm(((Button) e.getSource()).getText()
								.toString());
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								inputs.setDisable(false);
							}
						});
					};
				}).start();
			}
		};
		for (int i = 0; i < ALGORITHMS.length; i++) {
			final Button algo = new Button(ALGORITHMS[i]);
			algo.setOnAction(runner);
			inputs.getChildren().add(algo);
		}

		pane.setTop(hbox1);
		pane.setCenter(chart);
		pane.setBottom(inputs);

		stage.setScene(new Scene(pane));
		stage.show();
	}

	public void assign(int index, int value) {
		bars.get(index).setYValue(value);
	}

	public int retrieve(int index) {
		return (int) bars.get(index).getYValue();
	}

	public void randomizeAll() {
		for (int i = 0; i < BAR_COUNT; i++)
			assign(i, GEN_MIN
					+ (int) (Math.random() * ((GEN_MAX - GEN_MIN) + 1)));
	}

	public void paint(int index, String style) {
		XYChart.Data<String, Number> which = bars.get(index);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				which.getNode().setStyle(style);
			}
		});
	}

	public void paintAll(String style) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < BAR_COUNT; i++) {
					paint(i, style);
				}
			}
		});
	}

	public void delay() {
		try {
			Thread.sleep(DELAY_MILLIS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void callBarAlgorithm(String name) {
		if (name.equals("Swap Halves")) {
			doSwapHalves();
		} else if (name.equals("Full Reverse")){
			doFullReverse();
		} else if (name.equals("Bubble Sort")){
			doBubbleSort();
		} else if (name.equals("Selection Sort")){
			doSelectionSort();
		} else if (name.equals("Insertion Sort")){
			doInsertionSort();
		} else {
			System.err.println("Unimplemented: " + name);
		}
	}

	public void doSwapHalves() {
		int half = bars.size() / 2;
		for (int i = 0; i < half; i++) {
			int j = i + half + (bars.size() % 2 == 1 ? 1 : 0);

			paint(i, COLOR_PROCESS);
			paint(j, COLOR_PROCESS);

			int temp = retrieve(i);
			assign(i, retrieve(j));
			assign(j, temp);

			delay();

			paint(i, COLOR_INITIAL);
			paint(j, COLOR_INITIAL);
		}
	}
	
	public void doFullReverse() {
		for (int i = 0, j = bars.size() - 1; i <= j; i++, j--) {
			paint(i, COLOR_PROCESS);
			paint(j, COLOR_PROCESS);

			int temp = retrieve(i);
			assign(i, retrieve(j));
			assign(j, temp);

			delay();

			paint(i, COLOR_INITIAL);
			paint(j, COLOR_INITIAL);
		}
		resetAllBarsToInitialColor();
	}
	
	public void doBubbleSort() {
	    for (int i = 0; i < bars.size() - 1; i++) {
	        for (int j = 0; j < bars.size() - i - 1; j++) {
			  paint(j, COLOR_PROCESS);
			  paint(j+1, COLOR_PROCESS_GREEN);
	          if (retrieve(j) > retrieve(j+1)) {
	            int temp = retrieve(j);
	            assign(j, retrieve(j+1));
	            assign(j+1, temp);
	          }
	          delay();
			  paint(j, COLOR_INITIAL);
			  paint(j+1, COLOR_INITIAL);
			  delay();
			  
	        }
	        paint(bars.size() - i -1, COLOR_FINAL);
	    }
	    resetAllBarsToInitialColor();
	}
	
	public void doSelectionSort() {
    for (int i = 0; i < bars.size() - 1; i++)
    {
        int index = i;
        paint(index, COLOR_PROCESS);
        for (int j = i + 1; j < bars.size(); j++) {
        	delay();
        	paint(j, COLOR_PROCESS_GREEN);
        	boolean didGoInside = false;
            if (retrieve(j) < retrieve(index)) {
            	delay();
            	paint(index, COLOR_INITIAL);
                index = j;
                didGoInside = true;              
            }
            delay();
            if (false == didGoInside) {
            	paint(j, COLOR_INITIAL);
            } else {  	
            	paint(index, COLOR_PROCESS);
            }
        }
        int smallerNumber = retrieve(index);  
        assign(index, retrieve(i));
        assign(i, smallerNumber);
        paint(i, COLOR_FINAL);
        if ( i != index) paint(index, COLOR_INITIAL);
        delay();
    }
    resetAllBarsToInitialColor();
	}
	
	public void doInsertionSort() {
	  paint(0, COLOR_FINAL);
    for (int j = 1; j < bars.size(); j++) {
  	  delay();
  	  paint(j, COLOR_PROCESS);
        int key = retrieve(j);
        int i = j-1;
  	  delay();
  	  paint(i, COLOR_PROCESS_GREEN);
        while (i > -1 && retrieve(i) > key ) {
      	  		delay();
      	  		paint(i, COLOR_PROCESS_GREEN);
	                assign(i+1, retrieve(i));
	                assign(i, key);
	       	  		delay();
      	  		paint(i, COLOR_FINAL);
	                i--;
        }
	  	  delay();
	  	  if (i > -1) paint(i, COLOR_FINAL);
        assign(i+1, key);
        delay();
        paint(j, COLOR_FINAL);
    }
    	delay();
		resetAllBarsToInitialColor();
	}
	
	public void resetAllBarsToInitialColor() {
		for (int i = 0; i < bars.size(); i++) {
			paint(i, COLOR_INITIAL);
		}
	}
}