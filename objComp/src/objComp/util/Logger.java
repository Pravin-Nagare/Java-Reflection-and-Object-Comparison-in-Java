package objComp.util;



public class Logger {
	public static int LOGGER_VALUE;
	
	private volatile static Logger logger;
	private Logger(){
		
	}
	
	/**@return		Logger	 		
	 * @param 		No Arguments
	 * @exception 	No Exception
	 */
	public static Logger getInstance() {
			if(logger == null){
				synchronized (Logger.class){
					logger = new Logger();
				}
			}
			return logger;
	 }
	
	/**		
	 * @param 		Integer, String
	 * @exception 	No Exception
	 */
	
	public void printToStdout(int level,String loggerMessage){
		if(level==LOGGER_VALUE){
			System.out.println(loggerMessage);
		}
	}
	
	public static void setLoggerValue(String arg){
		if(!(arg.equals("0") || arg.equals("1") || arg.equals("2") || arg.equals("3") ))
		{
			System.err.println("Logger value should be in between 0-3");
			System.exit(1);
		}
		Logger.LOGGER_VALUE=Integer.parseInt(arg);
	}
	
	/** Get value of static member DEBUG_VALUE
	 * @param 		No Arguments
	 * @exception 	No Exception
	 * @return 		Integer Static member DEBUG_VALUE
	 */
	public static int getDebugValue(){
		return LOGGER_VALUE;
	}
	
}
