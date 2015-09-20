package objComp.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import objComp.util.Logger;
import objComp.fileOperations.FileProcessor;

public class PopulateObjects {
	
	private Map<First, Integer> fMap = new HashMap<First, Integer>();
	private Map<Second, Integer> sMap = new HashMap<Second, Integer>();
	private FileProcessor fp = null;
	private Method method = null;
	private Logger logger = Logger.getInstance();
	
	public PopulateObjects(){
		logger.printToStdout(1, "Constructor of PopulateObjects is called");
	}

	public void deserObjects(String inputFile) {
		logger.printToStdout(2, "getObject of PopulateObjects is called");
		fp  = new FileProcessor(inputFile);
		fp.openfile();
		String line  = null;
		while((line = fp.readLine()) != null){
			String clsName = line.split(":")[1];
			Object obj = getObject(clsName);			
		}
		fp.close();
	}
	
	public Object getObject(String clsName){
		logger.printToStdout(2, "getObject of PopulateObjects is called");
		Class clasName = null;
		Object obj = null;
		try {
				clasName = Class.forName(clsName);
		} catch (ClassNotFoundException e) {
			System.err.println(clsName + "Class not found");
		}
		try {
				obj = clasName.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				System.err.println("Cannot create instance of class:" + clsName);
		}
		
		Object[] paramObjects = new Object[1];
	    Class[] signature = new Class[1];
	    int count=0;
	    while(count<2){
	    String param = fp.readLine();
		String[] params = param.split(",");
		String type = params[0].replaceFirst("type=", "").trim();
		String var = params[1].replaceFirst("var=", "").trim();
		String value = params[2].replaceFirst("value=", "").trim();
		
		if(type.equals("int"))
		{
			signature[0] = Integer.TYPE;
			paramObjects[0] = new Integer(value);
		}
		else if(type.equals("String"))
		{
			signature[0] = String.class;
			paramObjects[0] = new String(value);
		}
		else if(type.equals("double"))
		{
			signature[0] = Double.TYPE;
			paramObjects[0] = new Double(value);
		}
		
		String methodName = "set" + var;
		
		try {
			method = clasName.getMethod(methodName, signature);
		} catch (NoSuchMethodException | SecurityException e) {
			System.err.println("No such method:" + methodName);
		}
		try {
			Object result = method.invoke(obj, paramObjects);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			System.err.println("No access to method:" + methodName);
		}
		count++;
	    }
				putInMap(obj);
		return obj;
	}	
	
	public void putInMap(Object obj){
		logger.printToStdout(2, "putInMap of PopulateObjects is called");
		First f = null;
		Second s = null;		
		if(obj instanceof First){
			f = (First)obj;
			if(fMap.containsKey(f)){
				int count = fMap.get(f);
				count++;
				fMap.put(f, count);
			}
			else{
				fMap.put(f, 1);
			}
		}
		else if(obj instanceof Second){
			s = (Second)obj;
			if(sMap.containsKey(s)){
				int count = sMap.get(s);
				count++;
				sMap.put(s, count);
			}
			else{
				sMap.put(s, 1);
			}
		}
	}
	
	public void printFirstObjects(){
		logger.printToStdout(2, "printFirstObjects of PopulateObjects is called");
		Integer uniqFirstCount = 0;
		Integer totalFirst = 0;
		uniqFirstCount = fMap.size();
		
		for(Map.Entry<First, Integer> entry: fMap.entrySet()){
			Integer count = entry.getValue();
			totalFirst += count; 
		}
		
		logger.printToStdout(0, "Number of non-duplidate First objects: "+ (uniqFirstCount));
		logger.printToStdout(0, "Total Number of First objects: "+ totalFirst);
	}
	
	public void printSecondObjects(){
		logger.printToStdout(2, "printSecondObjects of PopulateObjects is called");
		Integer uniqSecondCount = 0;
		Integer totalSecond = 0;
		uniqSecondCount = sMap.size();
		
		for(Map.Entry<Second, Integer> entry: sMap.entrySet()){
			Integer count = entry.getValue();
			totalSecond += count; 
		}
		
		logger.printToStdout(0, "Number of non-duplidate Second objects: "+ (uniqSecondCount));
		logger.printToStdout(0, "Total Number of Second objects: "+ totalSecond);
	}
}

