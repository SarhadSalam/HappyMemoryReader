package gui;

import analytics.ChannelDifferentiator;
import analytics.ReadData;
import analytics.signals;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import server.MuseOscServer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class home extends Application
{
	
	private static String stringName;
	
	/**
	 * More fxml
	 */
	@FXML
	public Button thetaButton;
	@FXML
	public Button gammaButton;
	@FXML
	public Label statusMonitor;
	
	private Stage primaryStage;
	
	@FXML
	public MenuBar menuBar;
	
	/**
	 * The field below are from the trackFace.fxml file located in res/fxml.
	 */
	@FXML
	public VBox imageContainer;
	
	/**
	 * The field below are from the trackFace.fxml file located in res/fxml.
	 */
	@FXML
	public Button betaButton;
	
	/**
	 * The field below are from the trackFace.fxml file located in res/fxml.
	 */
	@FXML
	public Button cameraButton;
	/**
	 * The field below are from the trackFace.fxml file located in res/fxml.
	 */
	@FXML
	public ImageView originalFrame;
	/**
	 * The field below are from the trackFace.fxml file located in res/fxml.
	 */
	@FXML
	public CheckBox plotSingularGraph;
	/**
	 * The field below are from the trackFace.fxml file located in res/fxml.
	 */
	@FXML
	public CheckBox simultaneousGraphCB;
	/**
	 * The field below are from the trackFace.fxml file located in res/fxml.
	 */
	@FXML
	public Button alphaButton;
	
	/**
	 * The following method are event handlers for different buttons.
	 *
	 * @param actionEvent Event Handler
	 */
	@FXML
	protected void simultaneousGraph(ActionEvent actionEvent)
	{
		if( plotSingularGraph.isSelected() )
		{
			plotSingularGraph.fire();
		}
	}
	
	/**
	 * The following method are event handlers for different buttons.
	 *
	 * @param actionEvent Event Handler
	 */
	@FXML
	protected void lbpClassifier(ActionEvent actionEvent)
	{
		if( simultaneousGraphCB.isSelected() )
		{
			simultaneousGraphCB.fire();
		}
	}
	
	/**
	 * The following method are event handlers for different buttons.
	 *
	 * @param actionEvent Event Handler
	 */
	@FXML
	protected void alpha(ActionEvent actionEvent)
	{
		
	}
	
	/**
	 * The following method are event handlers for different buttons.
	 *
	 * @param keyEvent Event Handler
	 */
	@FXML
	protected void handleKeyInput(KeyEvent keyEvent)
	{
	}
	
	/**
	 * The following method are event handlers for different buttons.
	 *
	 * @param actionEvent Event Handler
	 */
	@FXML
	protected void handleAboutAction(ActionEvent actionEvent)
	{
	}
	
	/**
	 * The following method launches a new session.
	 *
	 * @param actionEvent The action Event
	 *
	 * @throws Exception Exception
	 */
	@FXML
	protected void launchNewSession(ActionEvent actionEvent) throws Exception
	{
		try
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/Home.fxml"));
			Parent newRoot = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(newRoot));
			stage.show();
		} catch( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * The method exits...
	 *
	 * @param actionEvent action event
	 */
	@FXML
	protected void exit(ActionEvent actionEvent)
	{
		Platform.exit();
	}
	
	/**
	 * The starting method.
	 *
	 * @param primaryStage The stage object.
	 *
	 * @throws Exception In case it couldn't load the fxml file.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		this.primaryStage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("../fxml/Home.fxml"));
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setTitle("We are tired");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	/**
	 * Method exists to initialize the gui from an external client/method.
	 *
	 * @param args Default args from main class.
	 */
	public static void launchGUI(String[] args)
	{
		launch(args);
	}
	
	@FXML
	public void beta(ActionEvent actionEvent)
	{
	}
	
	@FXML
	public void gamma(ActionEvent actionEvent)
	{
	}
	
	@FXML
	public void theta(ActionEvent actionEvent)
	{
	}
	
	@FXML
	public void startSavingData(ActionEvent actionEvent)
	{
		long initial = System.currentTimeMillis();
		MuseOscServer.startServer();
		try
		{
			saveData();
			ReadData.readData();
		} catch( URISyntaxException | IOException e )
		{
			e.printStackTrace();
		}
		
		statusMonitor.setText("Data Saved, time taken: "+( System.currentTimeMillis()-initial )/1000+"s");
	}
	
	private static void saveData() throws FileNotFoundException
	{
		ArrayList<ChannelDifferentiator> sd = signals.list;
		String name = "model"+System.currentTimeMillis()+".txt";
		PrintWriter writer = new PrintWriter("W:\\hackTheNorth\\src\\main\\resources\\models\\"+name);
		for( int i = 0; i<sd.size(); i++ )
		{
			ChannelDifferentiator cd = sd.get(i);
			writer.println(i+","+cd.getFreqChannel1()+","+cd.getFreqChannel2()+","+cd.getFreqChannel3()+","+cd.getFreqChannel4());
		}
		writer.close();
	}
	
	@FXML
	public void startAnalyzing(ActionEvent actionEvent)
	{
	
	}
	
	@FXML
	public void updateData(ActionEvent actionEvent) throws IOException, URISyntaxException
	{
		statusMonitor.setText("The method is very slow and will take >2min");
		ReadData.readData();
	}
}
