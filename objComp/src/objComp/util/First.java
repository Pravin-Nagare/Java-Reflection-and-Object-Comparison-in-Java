package objComp.util;
import objComp.util.Logger;

public class First {
	private int intValue;
	private String stringValue;
	private Logger logger = Logger.getInstance();
	
	public First(){
		logger.printToStdout(1, "Constructor of First is called");
	}
	
	public void setIntValue(int iIn){
		logger.printToStdout(2, "setIntValue of First is called");
		intValue=iIn;
	}
	
	public void setStringValue(String sIn) {
		logger.printToStdout(2, "setStringValue of First is called");
		stringValue = sIn;
	}
	
	@Override
	public int hashCode(){
		logger.printToStdout(2, "hashCode of First is called");
		return 37 * this.intValue *(this.stringValue != null ? this.stringValue.hashCode() : 0);
	}
	
	@Override
	public boolean equals(Object obj){
		logger.printToStdout(2, "equals of First is called");
		First fobj = null;
		if(obj instanceof First){
			fobj = (First)obj;
		}
		if(this.intValue == fobj.intValue && this.stringValue.equals(fobj.stringValue))
		{
			return true;
		}
		return false;
	}
}