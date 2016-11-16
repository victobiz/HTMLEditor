package htmlDesign;

public enum Atrib {
	
	ACCEPT, ALT;
	
	public String toString(){
		switch(this){
		case ACCEPT:
			return "Accept";
		case ALT:
			return "Alt";
		default: return "error";
		}
		
	}

}
