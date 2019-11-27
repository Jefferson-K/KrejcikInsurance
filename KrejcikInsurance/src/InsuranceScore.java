import java.io.Serializable;

/**
This is the blueprint for creating new insurance scores.  Serializable is implemented to allow for cleaner exports.
@author Jeff Krejcik
*/
public class InsuranceScore implements Serializable {
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
	
	
	/**
	 Default constructor.
	 */
	public InsuranceScore() {
		this.setNameFirst("");
		this.setNameLast("");
		this.setScore(0);
		this.setRisk("Unknown");
	}
	
	/**
	 * Creates an InsuranceScore object during the overridden initialization of a Member, attaching it to that Member
	 * @param member, an existing member object
	 */
	public InsuranceScore(Member member) {
		this.setNameFirst(member.getNameFirst());
		this.setNameLast(member.getNameLast());
		this.setScore(Assessor.calculateScore(member));
		this.setRisk(Assessor.calculateRisk(getScore()));
	}
	
	
	/**
	 * Formatted risk assessment output
	 */
	@Override
	public String toString() {
		return String.format("Name:   %25s\nScore:  %25s\nVerdict:%25s",
				this.getNameLast() + ", " + this.getNameFirst(),
				this.getScore(),
				this.getRisk());
	}
}
