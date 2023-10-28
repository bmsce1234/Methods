package stevejobs;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExampleTest {
   public static void main(String[] args) throws IOException {
      
      ExampleTest.readTextFileUsingBufferdReader("C:\\Users\\shri\\Desktop\\anktxt.txt");
   }
   
   public static void readTextFileUsingBufferdReader(String fileName) { 
	   try { 
		   FileReader textFileReader = new FileReader(fileName); 
		   BufferedReader bufReader = new BufferedReader(textFileReader); 
		   char[] buffer = new char[8096]; int numberOfCharsRead = bufReader.read(buffer); 
		    while (numberOfCharsRead != -1) {
		    	System.out.println(String.valueOf(buffer, 0, numberOfCharsRead)); 
		    	numberOfCharsRead = textFileReader.read(buffer); 
		    	} 
		    bufReader.close(); 
		    } catch (IOException e) { 
		    	e.printStackTrace(); 
		    	}
	   }
	   
   }

   //Read more: https://javarevisited.blogspot.com/2016/07/10-examples-to-read-text-file-in-java.html#ixzz71dJwBol8
