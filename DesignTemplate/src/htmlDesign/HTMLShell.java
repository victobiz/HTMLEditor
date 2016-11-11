package htmlDesign;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.TabPane.TabClosingPolicy;
//import javafx.event.*;
import javafx.geometry.*;



public class HTMLShell extends Application {
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	TreeItem<String> root, first;
	TreeView<String> tree;
	
	@Override public void start(Stage primaryStage){
		
		//make the main border pane
		BorderPane MainBorderPane = new BorderPane();
		
			//create the top border pane
			BorderPane TopBorderPane = new BorderPane();
			//TopBorderPane.setPrefSize(100, 600);
		
				//Create and add Menu Bar features
				MenuBar MainMenu = new MenuBar();
				Menu File = new Menu("FILE");
				MainMenu.getMenus().addAll(File);
		
				TopBorderPane.setTop(MainMenu);
				
				
				//Create and add Tab pane
				
				//this will need to be seperated in modular method.
				
				root = new TreeItem<String>("<!DOCTYPE>");
				root.setExpanded(true);
				
				first = new TreeItem<String>("<HTML>");
				first.setExpanded(true);
				
				root.getChildren().add(first);
				
				tree = new TreeView<String>(root);
				tree.setShowRoot(true);
				
				//for selecting model can add delete and insert functions
				/*tree.getSelectionModel().selectedItemProperty()
			    .addListener( (v, oldValue, newValue) -> tree_SelectionChange(newValue) );*/
				
				
				
			
			
				
				
				TabPane MainTab = new TabPane();
				//make the tabs not close on demand
				MainTab.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
				
				Tab HTMLStructureTab = new Tab("HTML STRUCTURE");
				
					Button htmlButton = new Button("heyo button");
					HBox MainHbox = new HBox(htmlButton);
					MainHbox.setStyle("-fx-background-color: blue;");
					MainHbox.setMinHeight(50);
					MainHbox.setMaxHeight(50);
					HTMLStructureTab.setContent(MainHbox);
					
				Tab HTMLListTab = new Tab("HTML LIST");
				MainTab.getTabs().addAll(HTMLStructureTab, HTMLListTab);
				TopBorderPane.setCenter(MainTab);
				
		//textArea
				
		TextArea Editor = new TextArea();
		
		//Footer
		
		Label Footer = new Label();
				
		
		//put the top pane into the main border pane
		MainBorderPane.setTop(TopBorderPane);
		MainBorderPane.setLeft(tree);
		MainBorderPane.setBottom(Footer);
		MainBorderPane.setCenter(Editor);
		
		Scene scene = new Scene(MainBorderPane, 800, 600);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("HTML EDITOR");
		primaryStage.show();
		
	}
	
/*	public void tree_SelectionChange(TreeItem<String> item){
		if(item != null){
			root.setText(item.getValue());
		}
	}*/

}
