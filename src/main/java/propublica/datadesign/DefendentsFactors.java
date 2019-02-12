package propublica.datadesign;




public class DefendentsFactors {


	private String Sex;
	private String Race;
	private	String cchargeDegree;
	private	String rchargeDesc;
	private	int decileScore;
	private	String scoreTest;
	private	int twoyearrecid;
	private String cchargeDesc;
	private	String rchargeDegree;
	private	String sexRace;


	public DefendentsFactors (String Sex, String Race,String cchargeDegree, String rchargeDesc, int decileScore, String scoreTest, 
			int twoyearrecid, String cchargeDesc, String rchargeDegree, String sexRace) {


		this.Sex = Sex;
		this.Race = Race;
		this.cchargeDegree = cchargeDegree;
		this.rchargeDesc = rchargeDesc;
		this.decileScore = decileScore;
		this.scoreTest = scoreTest;
		this.twoyearrecid = twoyearrecid;
		this.cchargeDesc = cchargeDesc;
		this.rchargeDegree = rchargeDegree;
		this.sexRace = sexRace;
	}

	private String getSex() {
		return this.Sex;
	}

	private String getRace() {
		return this.Race;
	}

	private String getcchargeDesc() {
		return this.cchargeDesc;
	}

	private int gettwoyearrecid() {
		return this.twoyearrecid; 
	}

	private int getdecileScore() {
		return this.decileScore;
	}

	private String getcchargeDegree () {
		return this.cchargeDegree;
	}

	private void setSex (String sex) {

		this.Sex = sex; 
	}

	private void setRace (String race) {

		this.Race = race; 
	}

	private void cchargeDegree(String cchargedegree) {

		this.cchargeDegree = cchargedegree; 

	}

	private void rchargeDesc (String rchargedesc) {

		this.rchargeDesc = rchargedesc; 

	}

	private void decileScore (int decilescore) {

		this.decileScore = decilescore; 
	}

	private void scoreTest (String scoretest) {

		this.scoreTest = scoretest; 
	}

	private void twoyearrecid (int twoyearRecid) {

		this.twoyearrecid = twoyearRecid; 
	}

	private void cchargeDesc (String cchargedesc) {

		this.cchargeDesc = cchargedesc; 
	}

	private void rchargeDegree (String rchargedegree) {

		this.rchargeDegree = rchargedegree; 
	}

	private void sexRace(String sexrace) {

		this.sexRace = sexrace; 
	}

	private boolean ScoreAnalysisBiasedToHigh () {

		if (this.scoreTest == "High" && this.twoyearrecid == 0) {
			return true;
		}

		else {
			return false;
		}
	}
	private boolean ScoreAnalysisBiasedToLow () {

		if (this.scoreTest == "Low" && this.twoyearrecid == 1) {
			return true;
		}

		else {
			return false;
		}
	}


	public DefendentsFactors (String Sex, String Race,String cchargeDegree, String rchargeDesc, String decileScore, String scoreTest, 
			String twoyearrecid, String cchargeDesc, String rchargeDegree, String sexRace) {


		this.decileScore = Integer.parseInt(decileScore);
		this.twoyearrecid = Integer.parseInt(twoyearrecid);
		this.Sex = Sex;
		this.Race = Race;
		this.cchargeDegree = cchargeDegree;
		this.rchargeDesc = rchargeDesc;
		this.scoreTest = scoreTest;
		this.cchargeDesc = cchargeDesc;
		this.rchargeDegree = rchargeDegree;
		this.sexRace = sexRace;
		
		
	}
	

}











