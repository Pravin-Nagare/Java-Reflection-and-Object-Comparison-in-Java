package objComp.driver;

import objComp.util.PopulateObjects;
import objComp.util.Logger;

public class Driver {

	public static void main(String[] args) {
		
		String inputFile = args[0];
		Integer NUM_ITERATIONS = Integer.parseInt(args[1]);
		long finishTime = 0;
		double totalTime = 0;
		PopulateObjects pObjects = null;
		Logger logger = Logger.getInstance();
		
		if(args.length < 3) {
			System.err.println("Number of arguments should be 3\n");
			System.exit(1);
		}
		
		Logger.setLoggerValue(args[2]);
		
		long startTime = System.currentTimeMillis();
		for(Integer i=0; i<NUM_ITERATIONS; i++){
			
			pObjects = new PopulateObjects();
			pObjects.deserObjects(inputFile);								
		}
		
		finishTime = System.currentTimeMillis();
		totalTime = (finishTime-startTime)/NUM_ITERATIONS;
		
		pObjects.printFirstObjects();
		pObjects.printSecondObjects();
		logger.printToStdout(0, "Total time: "+ totalTime/1000 + " seconds");			
	}

}
