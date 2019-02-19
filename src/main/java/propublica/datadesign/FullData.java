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
	 * returns the ArrayList 
	 */

	public FullData (ArrayList<String[]> myEntries) {  
		Data = new ArrayList<DefendentsFactors>();
		for(int i = 0; i < myEntries.size(); i++) {
			String[] entry = myEntries.get(i);

			if (entry[6].equals("0")){
				DefendentsFactors current;
				try {
					current = new DefendentsFactors(entry[0],entry[1], entry[2], entry[3],
							entry[4], entry[5], entry[6], "  " ,  " " , entry[9]);
					this.Data.add(current);
				}
				catch(IllegalArgumentException e){

				}
							
			} else {
				DefendentsFactors current = new DefendentsFactors(entry[0],entry[1], entry[2], entry[3],
						entry[4], entry[5], entry[6], entry[7] ,  entry[8] , entry[9]);
				Data.add(current);
			}
		}

	}

	public DefendentsFactors getrow(int v) {
		return Data.get(v);
	}

	public void addrow (DefendentsFactors newrow) {
		Data.add(newrow);
	}

	public double AnalysisAfAmBiasedLOWRisk() { //28%
		double numerator =0;
		double denomerator= 0;
		for (int i = 0; i < Data.size(); i++) {
			if (Data.get(i).getRace() == Race.AFRICANAMERICAN) {
				if (Data.get(i).ScoreAnalysisBiasedToLow() == true) {
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

	public double AnalysisAfAmBiasedHIGHRisk() { //44.9%
		double numerator =0;
		double denomerator= 0;
		for (int i = 0; i < Data.size(); i++) {
		//	System.out.println(Data.get(i).getRace());
			if (Data.get(i).getRace() == Race.AFRICANAMERICAN) {
			//	System.out.println(i);
				if (Data.get(i).ScoreAnalysisBiasedToHigh() == true) {
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

	public double AnalysisCaucasianBiasedLOWRisk() { //47.7%
		double numerator =0;
		double denomerator= 0;
		for (int i = 0; i < Data.size(); i++) {
			if (Data.get(i).getRace() == Race.CAUCASIAN) {
				if (Data.get(i).ScoreAnalysisBiasedToLow() == true) {
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

	public double AnalysisCaucasianBiasedHIGHRisk() { //23.5%
		double numerator =0;
		double denomerator= 0;
		for (int i = 0; i < Data.size(); i++) {
			if (Data.get(i).getRace() == Race.CAUCASIAN) {
				if (Data.get(i).ScoreAnalysisBiasedToLow() == true) {
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




