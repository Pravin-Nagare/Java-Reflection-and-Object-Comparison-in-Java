package objComp.util;
import objComp.util.Logger;

public class Second {
	
	private Double doubleValue;
	private int intValue;
	private Logger logger = Logger.getInstance();
	
	public Second(){
		logger.printToStdout(1, "Constructor of Second is called");
	}
	
	public void setIntValue(int iIn){
		logger.printToStdout(2, "setIntValue of First is called");
		intValue=iIn;
	}
	
	public void setDoubleValue(double dIn) {
		logger.printToStdout(2, "setDoubleValue of First is called");
		doubleValue = dIn;
	}
	
	@Override
	public int hashCode() {
		logger.printToStdout(2, "hashCode of Second is called");
		return 37* this.intValue * (this.doubleValue != null ? this.doubleValue.hashCode() : 0);
	}
	
	@Override
	public boolean equals(Object obj) {
		logger.printToStdout(2, "equals of Second is called");
		Second secObj = null;
		if(obj instanceof Second){
			secObj = (Second)obj;
		}
		
		if(this.intValue == secObj.intValue && this.doubleValue.equals(secObj.doubleValue))
		{
			return true;	
		}
		return false;
	}
}
