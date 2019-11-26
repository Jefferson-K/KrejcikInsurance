/*
 * Jeff Krejcik
 * 
 * InsuranceScoreWriter Class
 * This class writes insurance scores to either the screen or to a JSON file
 */
import java.util.ArrayList;
import org.json.*;
import java.io.*;

public class InsuranceScoreWriter {
	// Procedure to write to screen
	public static void writeScoresToScreen(ArrayList<InsuranceScore> scores) {
		for (InsuranceScore score : scores) {
			System.out.println(score);
		}
	}
	
	// Procedure to write to JSON
	public static boolean writeScoresToJSON(ArrayList<InsuranceScore> scores, String fname) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
			JSONArray array = new JSONArray();
			JSONObject obj;
			for (InsuranceScore score : scores) {
				obj = new JSONObject();
				obj.put("nameFirst", score.getNameFirst());
				obj.put("nameLast", score.getNameLast());
				obj.put("score", score.getScore());
				obj.put("risk", score.getRisk());
				array.put(obj);
			}
			JSONObject scoreList = new JSONObject();
			scoreList.put("scores", array);
			pw.println(scoreList.toString());
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
