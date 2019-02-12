
/* Name: Menna Khaliel
 * File: DefendentsFactors.java
 * 
 * The main class for Lab 1 
 * 
 * This program creates one row based on the data from 
 * compas-scores.csv that's obtained from Probublica's analysis.
 * It makes a simple analysis based on two factors from the data 
 * which are score of defendants and two-years redcideivsm 
 * It checks whether the inputs of each criteria in the row
 * is a valid input or not based on an analysis of the given data in the file. 
 */

package propublica.datadesign;

public class DefendentsFactors {

	enum Sex {MALE , FEMALE};
	enum Race {AFRICANAMERICAN, OTHER, HISPANIC, CAUCASIAN};
	enum ScoreText {LOW, HIGH, MEDIUM};
	enum CChargeDegree {F, M}; 

	//THINGS LIKE MALE SHOULD BE IN CAPS (ENUM PARAMETERS)



	// initializing the ten fields that exist in the row
	private Sex sex;
	private Race race;
	private	CChargeDegree cchargeDegree;
	private	String rchargeDesc;
	private	int decileScore;
	private	ScoreText scoreText;
	private	int twoyearrecid;
	private String cchargeDesc;
	private	String rchargeDegree;
	private	String sexRace;


	//setting the constructor
	public DefendentsFactors (String Sex, String Race,CChargeDegree cchargeDegree, 
			String rchargeDesc, int decileScore, ScoreText scoreText, 
			int twoyearrecid, String cchargeDesc, String rchargeDegree, String sexRace) {

		this.sex = sex;
		this.race = race;
		this.cchargeDegree = cchargeDegree;
		this.rchargeDesc = rchargeDesc;
		this.decileScore = decileScore;
		this.scoreText = scoreText;
		this.twoyearrecid = twoyearrecid;
		this.cchargeDesc = cchargeDesc;
		this.rchargeDegree = rchargeDegree;
		this.sexRace = sexRace;
	}


	//Setting Getters and Setters

	public Sex getSex() {
		return sex;
	}



	public void setSex(Sex sex) {
		this.sex = sex;
	}



	public Race getRace() {
		return race;
	}



	public void setRace(Race race) {
		this.race = race;
	}



	public CChargeDegree getCchargeDegree() {
		return cchargeDegree;
	}



	public void setCchargeDegree(CChargeDegree cchargeDegree) {
		this.cchargeDegree = cchargeDegree;
	}



	public String getRchargeDesc() {
		return rchargeDesc;
	}



	public void setRchargeDesc(String rchargeDesc) {
		this.rchargeDesc = rchargeDesc;
	}



	public int getDecileScore() {
		return decileScore;
	}



	public void setDecileScore(int decileScore) {
		this.decileScore = decileScore;
	}



	public ScoreText getScoreText() {
		return scoreText;
	}



	public void setScoreText(ScoreText scoreText) {
		this.scoreText = scoreText;
	}



	public int getTwoyearrecid() {
		return twoyearrecid;
	}



	public void setTwoyearrecid(int twoyearrecid) {
		this.twoyearrecid = twoyearrecid;
	}



	public String getCchargeDesc() {
		return cchargeDesc;
	}



	public void setCchargeDesc(String cchargeDesc) {
		this.cchargeDesc = cchargeDesc;
	}



	public String getRchargeDegree() {
		return rchargeDegree;
	}



	public void setRchargeDegree(String rchargeDegree) {
		this.rchargeDegree = rchargeDegree;
	}



	public String getSexRace() {
		return sexRace;
	}



	public void setSexRace(String sexRace) {
		this.sexRace = sexRace;
	}

	/*
	 *returns true or false based on determining if the machine is
	 *biased and creates High Risk. It compares the the score test 
	 *if it's high with no recid in two years, then it's biased
	 *@param1 scoreText is the the score
	 *@param2 twoyearrecid is an input of 1 or 0 which means that there 
	 *was a recid in case of 1 and not in case of 0
	 *return boolean true or false based on the analysis 
	 */

	private boolean ScoreAnalysisBiasedToHigh () {

		if (this.scoreText == ScoreText.HIGH && this.twoyearrecid == 0) {
			return true;
		}

		else {
			return false;
		}
	}


	/*
	 *returns true or false based on determining if the machine is
	 *biased and creates Low Risk. It compares the the score test 
	 *if it's high with no recid in two years, then it's biased
	 *@param1 scoreText is the the score
	 *@param2 twoyearrecid is an input of 1 or 0 which means that there 
	 *was a recid in case of 1 and not in case of 0
	 *return boolean true or false based on the analysis 
	 */

	private boolean ScoreAnalysisBiasedToLow () {

		if (this.scoreText == ScoreText.LOW && this.twoyearrecid == 1) { 
			return true;
		}
		else {
			return false;
		}
	}

	//setting a constructor that takes only string inputs
	public DefendentsFactors (String Sex, String Race, String CChargeDegree, 
			String rchargeDesc, String decileScore, String ScoreText, 
			String twoyearrecid, String cchargeDesc, String rchargeDegree, String sexRace) {


		this.decileScore = Integer.parseInt(decileScore);
		this.twoyearrecid = Integer.parseInt(twoyearrecid);
		this.sex = sex;
		this.race = race;
		this.cchargeDegree = cchargeDegree;
		this.scoreText = scoreText;
	}

	/*
	 * return the decile score as a String and throws
	 * and exception if it's not valid (if it's less
	 *  than 0 or greater than 10) based on the data 
	 *  from csv file
	 *  @param decileScore the integer input to convert to String
	 *  returns an exception if the input is invalid 
	 *  and string score number if it's valid
	 */

	private void ConvertDecile (String decileScore){
		//creating a new variable and converting the integer decileScore into string 
		int initialdecileScore = Integer.parseInt(decileScore); 
		//testing whether it's valid input or not
		if (initialdecileScore <= 10 && initialdecileScore > 0) { 
			//assigning the number converted into string to decileScore
			this.decileScore = Integer.parseInt(decileScore); 
		}	else { 
			//throws an exception if it's not
			throw new IllegalArgumentException("Invalid Input"); 
		}
	}


	/*
	 * return the twoyearrecid as a string and throws
	 * an exception if it's not valid (if it's anything 
	 * other than 0 and 1 based on the data from the csv file
	 * @param twoyearrecid the integer input to convert to String
	 * returns an exception if the input is invalid
	 * and string number (either 1 or 0) if it's valid
	 */

	private void Converttwoyearrecid (String twoyearrecid){
		//creating a new variable and converting the integer twoyearrecid into string
		int initialtwoyearrecid = Integer.parseInt(twoyearrecid);
		//testing whether it's valid input or not
		if (initialtwoyearrecid == 0) {
			//assigning the number converted into string to twoyearrecid
			this.twoyearrecid = Integer.parseInt(twoyearrecid); 
		}
		else if (initialtwoyearrecid == 1) {
			//assigning the number converted into string to twoyearrecid
			this.twoyearrecid = Integer.parseInt(twoyearrecid);
		}else {
			//throws an exception if it's not
			throw new IllegalArgumentException("Invalid Input"); 
		}
	}

	/*
	 * ensures that this field holds valid inputs 
	 * (Male and Female) based on the data from the csv file
	 * @param sex is either Male or Female 
	 * returns an exception if the input is invalid
	 * and calls for MALE or FEMALE from enum Sex if it's valid
	 */

	private void CheckSex (String sex) {
		if (sex == "Male") {
			//calls for the matching input from enum Sex
			this.sex = Sex.MALE; 
		}else if (sex == "Female") {
			//calls for the matching input from enum Sex
			this.sex = Sex.FEMALE;
		}else {
			//throws an exception if it's not valid
			throw new IllegalArgumentException("Invalid Input");  
		}
	}

	/*
	 * ensures that this field holds valid inputs
	 * (African-American, Hispanic, Caucasian, Other)
	 * @param race is one of the five specified inputs
	 * returns an exception if the input is invalid
	 * and calls for the inputs from enum Race if it's valid
	 */

	private void Checkrace(String race){
		if (race == "African-American") {
			//calls for the matching input from enum Race
			this.race = Race.AFRICANAMERICAN;
		} else if (race == "Hispanic") {
			this.race = Race.HISPANIC;
		} else if (race == "Caucasian") {
			this.race = Race.CAUCASIAN;
		} else if (race == "Other") {
			this.race = Race.OTHER;		
		}
		else {
			//throws an exception if it's not valid
			throw new IllegalArgumentException("Invalid Input");
		}
	}

	/*
	 * ensures that this field holds valid inputs (F, M)
	 * @param cchargeDegree is either F or M
	 * returns an exception if the input is invalid
	 * and calls for the inputs from enum CheckCChargeDegree if it's valid
	 */

	private void CheckCChargeDegree (String cchargeDegree) {
		if (cchargeDegree == "M") {
			//calls for the matching input from enum CheckCChargeDegree
			this.cchargeDegree = CChargeDegree.M;
		}else if (cchargeDegree == "F") {
			this.cchargeDegree = CChargeDegree.F;
		}else {
			//throws an exception if it's not valid
			throw new IllegalArgumentException("Invalid Input");
		}
	}

	/*
	 * ensures that this field holds valid inputs
	 * (High, Medium, Low)
	 * @param scoreText is to be one of the three 
	 * specified inputs
	 * returns an exception if the input is invalid
	 * and calls for either on of the inputs 
	 * from enum CheckScoreText if it's valid
	 */

	private void CheckScoreText (String scoreText) {
		if (scoreText == "Low") {
			//calls for the matching input from enum ScoreText
			this.scoreText = ScoreText.LOW;
		}else if (scoreText == "Medium") {
			this.scoreText = ScoreText.MEDIUM;
		}else if (scoreText == "High") {
			this.scoreText = ScoreText.HIGH;
		}else {
			//throws an exception if it's not valid
			throw new IllegalArgumentException("Invalid Input");
		}
	}
}


















