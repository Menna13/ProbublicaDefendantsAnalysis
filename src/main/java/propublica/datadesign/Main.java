package propublica.datadesign;
import java.io.FileReader;
import java.util.ArrayList;

import com.opencsv.*;
/* Name: Menna Khaliel
 * File: Main.java
 * 
 * The main method that tests the rows created by the the class and methods in the DefendentsFactors file

 */

public class Main 
{
	public static void main( String[] args )
	{

		// valid input for the row
		DefendentsFactors(Sex.MALE, Race.AFRICANAMERICAN, CChargeDegree.M, 
				"Driving License Suspended", 6 , ScoreText.Medium, false , "Battery", "(F2)", "Male-African-American");
		
		//has invalid input for the row (descile score can't be higer than 10)
		DefendentsFactors("Male", "African-American","M", 
				"Driving License Suspended", "13", "Medium", "false", "Battery", "(M2)", "Male-African-American"));

		CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader("yourfile.csv"));
		ArrayList<String[]> myEntries = new ArrayList<String[]>(reader.readAll());
		reader.close();

	}
	
	
}
