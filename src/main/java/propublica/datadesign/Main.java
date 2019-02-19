package propublica.datadesign;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReaderHeaderAware;

import propublica.datadesign.DefendentsFactors.CChargeDegree;
import propublica.datadesign.DefendentsFactors.Race;
import propublica.datadesign.DefendentsFactors.ScoreText;
import propublica.datadesign.DefendentsFactors.Sex;
/*
 * Name: Menna Khaliel
 * File: Main.Java
 * 
 * This file runs my main methods and tests for my program
 */


/*
 * For Part (3)-1 and 2 in the Lab description:
 * The data did not violate my precondition assumptions
 * A data that would violate my precondition assumption is:
 * (DefendentsFactors("Male", "African-American","G", Driving License Suspended, 
				"13", "Medium", "2", "Battery", "(M2)", "Male-African-American");
		in the third cell, it is G and it should be only F or M
		in the fourth, it is not a string
		in the fifth, it should be between 1 and 10
		in the sixth, it should be either 1 or 0  
 */

public class Main 
{
	
	
	public static void main(String[] args)
	{
		//The code that gets the data from the CSV file
		CSVReaderHeaderAware reader = null;
		try {
			reader = new CSVReaderHeaderAware(new FileReader("compas-scores.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String[]> myEntries = null;
		try {
			myEntries = new ArrayList<String[]>(reader.readAll());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	// valid input for the row
		DefendentsFactors df = new DefendentsFactors(Sex.MALE, Race.AFRICANAMERICAN, CChargeDegree.M, 
				"Driving License Suspended", 6 , ScoreText.MEDIUM, 1 , 
				"Battery", "(F2)", "Male-African-American");
	
		//has invalid input for the row (descile score can't be higher than 10)
		DefendentsFactors dd = new DefendentsFactors("Male", "African-American","M", "Driving License Suspended", 
				"13", "Medium", "0", "Battery", "(M2)", "Male-African-American");
				
		
		 FullData full = new FullData(myEntries); //takes the data from CSV file and import it to my FullData class
		 System.out.println("Percentage of African-American Defendants who Labeled as High Risk but didn't re-offend: " + full.AnalysisAfAmBiasedHIGHRisk());
		 System.out.println("Percentage of African-American Defendants who Labeled as Low Risk but did re-offend: " + full.AnalysisAfAmBiasedLOWRisk());
		 System.out.println("Percentage of White Americans Defendants who Labeled as High Risk but didn't re-offend: " + full.AnalysisCaucasianBiasedHIGHRisk());
		 System.out.println("Percentage of White Americans Defendants who Labeled as Low Risk but did re-offend: " + full.AnalysisCaucasianBiasedLOWRisk());
		 
		
	}
	
	
	
}
