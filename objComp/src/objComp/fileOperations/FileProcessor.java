package objComp.fileOperations;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import objComp.util.Logger;

public class FileProcessor {
	
	public String inFile=null;
	private String outFile=null;
	private FileInputStream input=null;
	private BufferedReader reader=null;
	private File file = null;
	private Logger logger = Logger.getInstance(); 
	public FileProcessor(String inFile){
			logger.printToStdout(3, "Constructor of FileProcessor is called");
			this.inFile = inFile;
	}
	
	public void writeToFile(String output){
		logger.printToStdout(2, "writeToFile of FileProcessor is called");
		BufferedWriter bw=null;
		try {
	          File file = new File(outFile);
	          FileWriter fw;
	          if(file.exists()){    
	        	  fw = new FileWriter(file, true);
	          }
	          else{
	        	   fw = new FileWriter(file);
	          }
	          bw = new BufferedWriter(fw);
	          bw.write(output);
	    } 
		catch ( IOException e ) {
				System.err.println("IO exception occured.");
	    }
		finally{
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				System.err.println("Error in file closing.");
			}
	        
		}	
    }	
		
	
	public void openfile(){
		logger.printToStdout(2, "openfile of FileProcessor is called");
		try {
			File file = new File(inFile);
			input  = new FileInputStream(file);
			reader = new BufferedReader(new InputStreamReader(input));
		}catch(FileNotFoundException e){
			System.err.println("File Not Found.");
			System.exit(1);
		}finally{
			
		}				
	}
	
	public String readLine(){
		logger.printToStdout(2, "readLine of FileProcessor is called");
		String fileLine = null;
		try{
			
			return (fileLine = reader.readLine());			
		}catch(Exception e){
			System.err.println("Could not read file.");
			return fileLine;		
		}finally{
			
		}
	}
	
	public void close(){
		try {
			reader.close();
		}catch (IOException e) {
			System.err.println("Error in file clossing");
		}finally{
			
		}		
	}
}
