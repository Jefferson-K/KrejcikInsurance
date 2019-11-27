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
	public static void writeScoresToScreen(ArrayList<Member> members) {
		for (Member member : members) {
			System.out.println(member.getScore());
			System.out.println();
		}
	}
	
	// Procedure to write to JSON
	public static boolean writeScoresToJSON(ArrayList<Member> members, String fname) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
			JSONArray array = new JSONArray();
			JSONObject obj;
			for (Member member : members) {
				obj = new JSONObject();
				obj.put("nameFirst", member.getScore().getNameFirst());
				obj.put("nameLast", member.getScore().getNameLast());
				obj.put("score", member.getScore().getScore());
				obj.put("risk", member.getScore().getRisk());
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
