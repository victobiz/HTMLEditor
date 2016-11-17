package htmlDesign;

public enum Atrib {
	
	ACCEPT, ALTACCEPT, ACCEPT_CHARSET, ACCESSKEY, ACTION, ALIGN, ALT, ASYNC, AUTOCOMPLETE, AUTOFOCUS, AUTOPLAY, AUTOSAVE,
;
	
	public String toString(){
		switch(this){
		
		
		case ACCEPT:
			return"Accept";
		case ACCEPT_CHARSET:
			return "Accept-Charset";
		case	ACCESSKEY:
			return "Access Key";
		case	ACTION:
			return "Action";
		case	ALIGN:
			return "Align";
		case	ALT:
			return " Alt";
		case	ASYNC:
			return "Async";
		case	AUTOCOMPLETE:
			return "Auto Complete";
		case	AUTOFOCUS:
			return "Auto Focus";
		case	AUTOPLAY:
			return "Auto Play";
		case	AUTOSAVE:
			return "Auto Save";

		default: return "error";
		}
		//put in all attributes
	}

}
