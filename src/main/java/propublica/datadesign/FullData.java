/* Name: Menna Khaliel 
 * File: FullData.java
 * 
 * The program runs the replication of Propublica's data analysis  
 * 
 * This program creates an Array List that takes 
 * data from the CSV file and assign it to the arrays of type
 * DefendentsFactors (which is the class that holds one row from the data 
 * that was created in the previous lab) and put it in the ArrayList.
 * It also replicates Propublica's data analysis for the 4 percentages of the 
 * white and African-American and their labeling as high or low risk
 */


package propublica.datadesign;

import java.util.ArrayList;
import java.util.Arrays;
import propublica.datadesign.DefendentsFactors.Race;
public class FullData {

	
	
	private ArrayList<DefendentsFactors> Data;  //initializing an ArrayList of type Defendents
	//Factors, which is the row that holds the 10 entries from the CSV file
	
	/*return an ArrayList that holds Arrays of type DefendentsFactors
	 * that each hold a row from the full data in the CSV file
	 * @param entry : The array inside the ArrayList of full data
	 * @param current : stores  an array of type DefendentFactors that have the row filled 
	 * returns the ArrayList of rows for the full data from the file
	 */

	public FullData (ArrayList<String[]> myEntries) {  
		Data = new ArrayList<DefendentsFactors>();
		for(int i = 0; i < myEntries.size(); i++) {
			String[] entry = myEntries.get(i);

			if (entry[6].equals("0")){ //if two year recid is 0, then the next two cells will be empty, then put an empty string into them
				DefendentsFactors current;
				try {
					current = new DefendentsFactors(entry[0],entry[1], entry[2], entry[3], //store the data entries inside the DefendentsFactors rows
							entry[4], entry[5], entry[6], "  " ,  " " , entry[9]);
					this.Data.add(current); //add the arrays of rows of DefendentsFactors to the arraylist
				}
				catch(IllegalArgumentException e){

				}
							
			} else {
				DefendentsFactors current = new DefendentsFactors(entry[0],entry[1], entry[2], entry[3],
						entry[4], entry[5], entry[6], entry[7] ,  entry[8] , entry[9]);
				Data.add(current); //add the arrays of rows of DefendentsFactors to the arraylist
			}
		}

	}

	public DefendentsFactors getrow(int v) {
		return Data.get(v);
	}

	public void addrow (DefendentsFactors newrow) {
		Data.add(newrow);
	}

	
	/*
	 * returns percentage of type double
	 * @param1 denomerator: number of African-American who re-offend
	 * @param2 numerator : number of African-American who re-offend but labeled low risk
	 * returns the division of denomerator over numerator  multiply 100 to get the percentage
	 */
	public double AnalysisAfAmBiasedLOWRisk() { //28%
		double numerator =0;
		double denomerator= 0;
		for (int i = 0; i < Data.size(); i++) {
			if (Data.get(i).getRace() == Race.AFRICANAMERICAN) {
				if (Data.get(i).ScoreAnalysisBiasedToLow() == true) { //import the row to the method that check if it's biased or not 
					//created in DefendentsFactors file from last lab
					denomerator = 1 + denomerator;
					numerator = 1 + numerator;
				} else {
					denomerator = 1 + denomerator;
				}
			}
		}
		double AfAmLOWRisk = (numerator/denomerator)*100;
		return AfAmLOWRisk;
	}
	
	/*
	 * returns percentage of type double
	 * @param1 denomerator: number of African-American who didn't re-offend
	 * @param2 numerator : number of African-American who didn't re-offend but labeled high risk
	 * returns the division of denomerator over numerator  multiply 100 to get the percentage
	 */

	public double AnalysisAfAmBiasedHIGHRisk() { //44.9%
		double numerator =0;
		double denomerator= 0;
		for (int i = 0; i < Data.size(); i++) {
		//	System.out.println(Data.get(i).getRace());
			if (Data.get(i).getRace() == Race.AFRICANAMERICAN) {
			//	System.out.println(i);
				if (Data.get(i).ScoreAnalysisBiasedToHigh() == true) { //import the row to the method that check if it's biased or not 
					//created in DefendentsFactors file from last lab
					denomerator = 1 + denomerator;
					numerator = 1 + numerator;
				} else {
					denomerator = 1 + denomerator;
				}

			}
		}
		double AfAmHIGHRisk = (numerator/denomerator)*100;
		return AfAmHIGHRisk;
	}
	
	/*
	 * returns percentage of type double
	 * @param1 denomerator: number of Caucasians who re-offend
	 * @param2 numerator : number of African-American who re-offend but labeled low risk
	 * returns the division of denomerator over numerator  multiply 100 to get the percentage
	 */

	public double AnalysisCaucasianBiasedLOWRisk() { //47.7%
		double numerator =0;
		double denomerator= 0;
		for (int i = 0; i < Data.size(); i++) {
			if (Data.get(i).getRace() == Race.CAUCASIAN) {
				if (Data.get(i).ScoreAnalysisBiasedToLow() == true) { //import the row to the method that check if it's biased or not 
					//created in DefendentsFactors file from last lab
					denomerator = 1 + denomerator;
					numerator = 1 + numerator;
				} else {
					denomerator = 1 + denomerator;
				}
			}
		}
		double CaucasianLOWRisk = (numerator/denomerator)*100;
		return CaucasianLOWRisk;
	}
	
	/*
	 * returns percentage of type double
	 * @param1 denomerator: number of Caucasians who didn't re-offend
	 * @param2 numerator : number of Caucasians who didn't re-offend but labeled high risk
	 * returns the division of denomerator over numerator  multiply 100 to get the percentage
	 */


	public double AnalysisCaucasianBiasedHIGHRisk() { //23.5%
		double numerator =0;
		double denomerator= 0;
		for (int i = 0; i < Data.size(); i++) {
			if (Data.get(i).getRace() == Race.CAUCASIAN) {
				if (Data.get(i).ScoreAnalysisBiasedToLow() == true) { //import the row to the method that check if it's biased or not 
					//created in DefendentsFactors file from last lab
					denomerator = 1 + denomerator;
					numerator = 1 + numerator;
				} else {
					denomerator = 1 + denomerator;
				}
			}
		}
		double CaucasianLOWRisk = (numerator/denomerator)*100;
		return CaucasianLOWRisk;
	}
}

/*
 * For Part (4) 3- of the lab 
 * Charges such as "Driving License Suspended" Should not be counted as the person re-offended
 * which will lead to decreasing the number of people re-offended and subsequently would reduce the percentage evaluation
 * 
 */



