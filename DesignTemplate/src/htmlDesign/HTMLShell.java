package htmlDesign;

import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.TabPane.TabClosingPolicy;
//import javafx.event.*;
import javafx.geometry.*;



import java.lang.StringBuffer;


public class HTMLShell extends Application implements buttonToEditorFilter {
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	TreeItem<String> root, first;
	TreeView<String> tree;
	TextArea Editor;
	
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
					HTMLStructureTab.setId("tab");
					
					ButtonFactory style1 = new ButtonFactory("<Style>", "structure","media scoped type");
					SplitMenuButton style = style1.getButton();
					style.setOnAction(e-> btnAdd_Clicked(style)); 
					/*ButtonFactory div1 = new ButtonFactory("<Div>", "structure");
					Button div = div1.getPlain();
					div.setOnAction(e-> btnAdd_Clicked(div)); 
					ButtonFactory span1 = new ButtonFactory("<Span>", "structure");
					SplitMenuButton span = span1.getButton();
					span.setOnAction(e-> btnAdd_Clicked(span)); 
					ButtonFactory header1 = new ButtonFactory("<Header>", "structure");
					SplitMenuButton header = header1.getButton();
					header.setOnAction(e-> btnAdd_Clicked(header)); 
					ButtonFactory footer1 = new ButtonFactory("<footer>", "structure");
					SplitMenuButton footer = footer1.getButton();
					footer.setOnAction(e-> btnAdd_Clicked(footer)); 
					ButtonFactory main1 = new ButtonFactory("<main>", "structure");
					SplitMenuButton main = main1.getButton();
					main.setOnAction(e-> btnAdd_Clicked(main)); 
					ButtonFactory section1 = new ButtonFactory("<section>", "structure");
					SplitMenuButton section = section1.getButton();
					section.setOnAction(e-> btnAdd_Clicked(section)); 
					ButtonFactory article1 = new ButtonFactory("<article>", "structure");
					SplitMenuButton article = article1.getButton();
					article.setOnAction(e-> btnAdd_Clicked(article)); 
					ButtonFactory aside1 = new ButtonFactory("<aside>", "structure");
					SplitMenuButton aside = aside1.getButton();
					aside.setOnAction(e-> btnAdd_Clicked(aside)); 
					//ButtonFactory details1 = new ButtonFactory("<details>", "structure","open");
					//SplitMenuButton details = details1.getButton();
					//details.setOnAction(e-> btnAdd_Clicked(details)); 
					ButtonFactory dialog1 = new ButtonFactory("<dialog>", "structure");
					SplitMenuButton dialog = dialog1.getButton();
					dialog.setOnAction(e-> btnAdd_Clicked(dialog)); 
					ButtonFactory summary1 = new ButtonFactory("<summary>", "structure");
					SplitMenuButton summary = summary1.getButton();
					summary.setOnAction(e-> btnAdd_Clicked(summary)); 

					ButtonFactory somebutton = new ButtonFactory("<PIG>", "structure", "ACCEPT ALT");
					SplitMenuButton pig = somebutton.getButton();
					pig.setOnAction(e-> btnAdd_Clicked(pig)); */
					
					//send button to text builder
					
					HBox MainHbox = new HBox(style);//, div, span, header, footer, main, section, article, aside);//, details, dialog, summary);
					//add buttons to HBOX On Tabpane
					
					
					MainHbox.setMinHeight(50);
					MainHbox.setMaxHeight(50);
					HTMLStructureTab.setContent(MainHbox);
					
				Tab HTMLListTab = new Tab("HTML LIST");
				HTMLStructureTab.setId("tab");
				
				
				MainTab.getTabs().addAll(HTMLStructureTab, HTMLListTab);
				TopBorderPane.setCenter(MainTab);
				
		//textArea
				
		Editor = new TextArea();
		Editor.setWrapText(true);
		Editor.setPrefWidth(100);
		Editor.setPrefHeight(100);
		
		
		
		//Footer
		
		Label Footer = new Label();
				
		
		//put the top pane into the main border pane
		MainBorderPane.setTop(TopBorderPane);
		MainBorderPane.setLeft(tree);
		MainBorderPane.setBottom(Footer);
		MainBorderPane.setCenter(Editor);
		
		Scene scene = new Scene(MainBorderPane, 800, 600);
		scene.getStylesheets().add(getClass().getResource("HTMLdesign.css").toExternalForm());
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("HTML EDITOR");
		primaryStage.show();
		
	}
	
/*	public void tree_SelectionChange(TreeItem<String> item){
		if(item != null){
			root.setText(item.getValue());
		}
	}*/

	
	//need an implements class.
	public void btnAdd_Clicked(SplitMenuButton button) {
		
		
		String buttonFirst = button.getText();
		String attributes = "";
				//send text to tree here
	
		
		ObservableList<MenuItem>item = button.getItems();
		for(MenuItem checkMenuItem:item){
			if (((CheckMenuItem) checkMenuItem).isSelected())
			//System.out.println(checkMenuItem.getText());
				attributes += " " + checkMenuItem.getText() + "=''";
			};
			
					//or here if you want attributes added to tree
			
			String buttonLast = new String(buttonFirst);
			buttonFirst = new StringBuffer(buttonFirst).insert(buttonFirst.length() -1, attributes).toString();
			
			
			buttonLast = new StringBuffer(buttonLast).insert(1, "/").toString();
	
		//int x =Editor.getCaretPosition();
		Editor.insertText(Editor.getCaretPosition(),"\n" + buttonFirst + " \n\n" + buttonLast /*+ getAttributes*/);
		 //send to parser to check for last > then read to < make tree
		
	
	}
	
	public void btnAdd_Clicked(Button button){
		String buttonFirst = button.getText();
		String buttonLast = new String(buttonFirst);
		buttonLast = new StringBuffer(buttonLast).insert(1, "/").toString();
		
		Editor.insertText(Editor.getCaretPosition(),"\n" + buttonFirst + " \n\n" + buttonLast /*+ getAttributes*/);
		 //send to parser to check for last > then read to < make tree
		
		
		
	}
	
	
}
