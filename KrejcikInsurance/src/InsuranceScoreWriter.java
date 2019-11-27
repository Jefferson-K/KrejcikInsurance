import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
This class writes surance scores to either the screen or to a JSON file.
@author Jeff Krejcik
*/
public class InsuranceScoreWriter {
	/**
	 * Outputs the Insurance Scores of each member to the screen
	 * @param members, an ArrayList of all current Members
	 */
	public static void writeScoresToScreen(ArrayList<Member> members) {
		for (Member member : members) {
			System.out.println(member.getScore());
			System.out.println();
		}
	}
	
	/**
	 * Outputs the Insurance Scores of each member to a JSON file
	 * @param members, an ArrayList of all current Members
	 * @param fname, the target destination path for the exported file
	 * @return a success message
	 */
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
