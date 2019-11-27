/**
 This class determines the risk for a member based on member attributes, allowing for the creation of an insurance score.
 @author Jeff Krejcik
 */
public class Assessor {	
	/**
	 * Calculates a Member's BMI
	 * @param height, expects inches, then converts to meters
	 * @param weight, expects pounds, then converts to kilograms
	 * @return a String representing the name of the Member's BMI range
	 */
	private static String calculateBMI(int height, int weight) {
		double kilograms = weight / 2.2046;
		double meters = height / 39.37;
		double bmi = kilograms / (meters * meters);
		
		if (bmi < 25.0) { return "normal"; }
		else if (bmi < 30.0) { return "overweight"; }
		else { return "obese"; }
	}
	
	
	/**
	 * Use two Member metrics to calculate a blood pressure category
	 * @param bpSyst, the Member's systolic blood pressure
	 * @param bpDias, the Member's diastolic blood pressure
	 * @return a String representing the Member's blood pressure classification
	 */
	private static String calculateBloodPressure(int bpSyst, int bpDias) {
		if (bpSyst < 120 && bpDias < 80) { return "normal"; }  // 1-normal
		else if (bpSyst < 130 && bpDias < 80) { return "elevated"; }  // 2-elevated
		else if (bpSyst > 180 || bpDias > 120) { return "crisis"; }  // 5-crisis
		else if ((bpSyst >= 130 && bpSyst < 140)
				|| (bpDias >= 80 && bpDias < 90)) { return "stage 1"; } // 3-stage 1
		else if (bpSyst >= 140 || bpDias >= 90) { return "stage 2"; } // 4-stage 2
		else { return null; }
	}
	
	
	/**
	 * Determines a Member's Insurance Score
	 * @param member, an existing Member to be scored
	 * @return an integer representation of the calculated score
	 */
	public static int calculateScore(Member member) {
		int score = 0;
		int age = member.getAge();
		String bmi = calculateBMI(member.getHeight(), member.getWeight());
		String bloodPressure = calculateBloodPressure(member.getBpSyst(), member.getBpDias());
		
		// Age scoring
		if (age < 30) { score += 0; }
		else if (age < 45) { score += 10; }
		else if (age < 60) { score += 20; }
		else { score += 30; }
		
		// BMI Scoring
		if (bmi.equals("normal")) { score += 0; }
		else if (bmi.equals("overweight")) { score += 30; }
		else { score += 75; }
		
		// Blood Pressure Scoring
		if (bloodPressure.equals("normal")) { score += 0; }
		else if (bloodPressure.equals("elevated")) { score += 15; }
		else if (bloodPressure.equals("stage 1")) { score += 30; }
		else if (bloodPressure.equals("stage 2")) { score += 75; }
		else if (bloodPressure.equals("crisis")) { score += 100; }
		
		// Family Disease Scoring
		if (member.getCancer().equals("y")) { score += 10; }
		if (member.getDiabetes().equals("y")) { score += 10; }
		if (member.getAlzheimers().equals("y")) { score += 10; }
		
		// Final score
		return score;
	}
	
	/**
	 * Determines a verbal risk level
	 * @param score, calculated risk score
	 * @return a String of the risk level classification
	 */
	public static String calculateRisk(int score) {
		if (score <= 20) { return "low risk"; }
		else if (score <= 50) { return "moderate risk"; }
		else if (score <= 75) { return "high risk"; }
		else {return "uninsurable";
		}
	}
}
