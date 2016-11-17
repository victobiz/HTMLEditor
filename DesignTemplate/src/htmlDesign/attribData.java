package htmlDesign;

import java.util.HashMap;
import java.util.Map;

public class attribData {
	
	private Map<String, String> Data = new HashMap<String, String>();
	
	
	public attribData(){
		Data.put(""+ Atrib.ACCEPT,new String ("DKD"));
		Data.put("" +Atrib.ALT, "dkkdkdk");
		Data.put("" +Atrib.ACCEPT, "List of types the server accepts, typically a file type.");
		Data.put("" +Atrib.ACCEPT_CHARSET, "List of supported charsets.");
		Data.put("" +Atrib.ACCESSKEY, "	Defines a keyboard shortcut to activate or add focus to the element.");
		Data.put("" +Atrib.ACTION, "The URI of a program that processes the information submitted via the form.");
		Data.put("" +Atrib.ALIGN, "Specifies the horizontal alignment of the element.");
		Data.put("" +Atrib.ALT, "Alternative text in case an image can't be displayed.");
		Data.put("" +Atrib.ASYNC, "Indicates that the script should be executed asynchronously.");
		Data.put("" +Atrib.AUTOCOMPLETE, "Indicates whether controls in this form can by default have their values automatically completed by the browser.");
		Data.put("" +Atrib.AUTOFOCUS, "The element should be automatically focused after the page loaded.");
		Data.put("" +Atrib.AUTOPLAY, "The audio or video should play as soon as possible.");
		Data.put("" +Atrib.AUTOSAVE, "Previous values should persist dropdowns of selectable values across page loads.");

	}
	
	public String getData(String event){
		 if (!Data.containsKey(event)) {
	            return null;
	        }

	        return Data.get(event);
	    }
	
		
}
