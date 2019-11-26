/*
 * Jeff Krejcik
 * 
 * InsuranceScore Class
 * This is the blueprint for creating new insurance scores
 */

public class InsuranceScore {
	private String nameFirst, nameLast;
	private int score;
	private String risk;
	
	
	// Getters and Setters
	public String getNameFirst() {
		return nameFirst;
	}
	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}
	public String getNameLast() {
		return nameLast;
	}
	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getRisk() {
		return risk;
	}
	public void setRisk(String risk) {
		this.risk = risk;
	}
	
	
	// Constructors
	public InsuranceScore() {
		this.setNameFirst("");
		this.setNameLast("");
		this.setScore(0);
		this.setRisk("Unknown");
	}
	
	public InsuranceScore(Member member) {
		this.setNameFirst(member.getNameFirst());
		this.setNameLast(member.getNameLast());
		this.setScore(Assessor.calculateScore(member));
		this.setRisk(Assessor.calculateRisk(getScore()));
	}
}
