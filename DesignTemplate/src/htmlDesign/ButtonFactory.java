package htmlDesign;

import java.util.List;

import javafx.collections.ObservableList;
//import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
//import java.beans.EventHandler;


public class ButtonFactory /*implements MouseListener*/ {

	
	private SplitMenuButton splitButton = new SplitMenuButton();
	private Button plainButton = new Button();
	//private String[] attributeForCheckbox;
	//private String buttonString;		
	
		public ButtonFactory(){
			this.splitButton.setText("null button");
			this.splitButton.setId("null Tab");
			this.plainButton.setText("null button");
			this.plainButton.setId("null Tab");
			//this.buttonString =null;
		}
		
		public ButtonFactory(String id, String text){
			this.plainButton.setText(id);
			this.plainButton.setId(text);
			
			//this.setattrib
			
		}
		
		public ButtonFactory(String id, String text, String attribute){			
			this.splitButton.setText(id);
			this.splitButton.setId(text);	
			attributeParse(attribute);
			//this.buttonString=makeString();
			 
			
		}
		
		//parses input and adds checkMenuItemsToButtonList
		private String[] attributeParse(String attribute) {
			//split the string by spaces
			
			String[]y=attribute.split(" ");
			System.out.println(y.length);
			
			//make the string capitalized and add to split button
			//for (String s: y){
				for(int i = 0; i < y.length; i++){
				y[i].toUpperCase();
				System.out.print(y);
				String x =""+ Atrib.valueOf(y[i]);
				
				//format the checkMenus
				MenuFormat z = new MenuFormat(x);
				CheckMenuItem item = z.getMenuItem();
				//add items to split menu
				splitButton.getItems().add(item);
			}
			
			
			return y;
		}
		
		
		public SplitMenuButton getButton(){
			return this.splitButton;
		}

		

		
		
		/*public String getString(){
			returns this.buttonString;
		}
		
	
		
		
		public String makeString(){
			
			String buttonFirst = splitButton.getText();
			String attributes = "";
			String combined;
			
		
			
			ObservableList<MenuItem>item = splitButton.getItems();
			for(MenuItem MenuItem:item){
				if (((CheckMenuItem) MenuItem).isSelected())
				//System.out.println(checkMenuItem.getText());
					attributes += " " + MenuItem.getText() + "=''";
				};
				
						//or here if you want attributes added to tree
				
				String buttonLast = new String(buttonFirst);
				buttonFirst = new StringBuffer(buttonFirst).insert(buttonFirst.length() -1, attributes).toString();
				
				
				buttonLast = new StringBuffer(buttonLast).insert(1, "/").toString();
				combined = "\n" + buttonFirst + " \n\n" + buttonLast;
				
			return combined;
			
		
		}*/
}
