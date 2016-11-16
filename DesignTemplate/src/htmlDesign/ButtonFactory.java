package htmlDesign;

import javafx.collections.ObservableList;
//import javafx.collections.ObservableList;
import javafx.scene.control.*;


public class ButtonFactory {

	
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
		
		public ButtonFactory(String big, String little){
			this.plainButton.setText(big);
			this.plainButton.setId(little);
			
			//this.setattrib
			
		}
		
		public ButtonFactory(String big, String little, String attribute){			
			this.splitButton.setText(big);
			this.splitButton.setId(little);	
			attributeParse(attribute);
			//this.buttonString=makeString();
			 
			
		}
		
		//parses input and adds checkMenuItemsToButtonList
		private String[] attributeParse(String attribute){
			//split the string by spaces
			
			String[]y=attribute.split(" ");
			System.out.println(y.length);
			
			//make the string capitalized and add to split button
			for (String s: y){
				s.toUpperCase();
				Atrib x = Atrib.valueOf(s);
				
				//add items to checkMenu
				splitButton.getItems().addAll(new CheckMenuItem("" + x));	
			}
			
			for (int i= 0; i<y.length ;i++){
				System.out.print(y[i]);
				
			}
			
			return y;
		}
		
		
		public SplitMenuButton getButton(){
			return this.splitButton;
		}
		
		/*public String getString(){
			return this.buttonString;
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
