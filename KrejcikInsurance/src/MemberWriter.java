import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.beans.XMLEncoder;

/**
This class outputs member information to the screen and to multiple file formats.
@author Jeff Krejcik
*/
public class MemberWriter {
	/**
	 * Outputs member data to the screen
	 * @param members, an ArrayList of all members to be displayed
	 */
	public static void writeMembersToScreen(ArrayList<Member> members) {
		for (Member m : members) {
			System.out.println(m);
		}
	}
	
	
	/**
	 * Exports member data to a tab-delimited text file
	 * @param members, ArrayList of members to be exported
	 * @param fname, target file destination
	 * @return success message
	 */
	public static boolean writeMembersToTextFile(ArrayList<Member> members, String fname) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
			for (Member m : members) {
				pw.println(m.tabDelimOutput());
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	
	/**
	 * Exports member data to a binary file
	 * @param members, ArrayList of members to be exported
	 * @param fname, target file destination
	 * @return success message
	 */
	public static boolean writeMembersToBinary(ArrayList<Member> members, String fname) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
			oos.writeObject(members);
			oos.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	
	/**
	 * Exports member data to an XML file
	 * @param members, ArrayList of members to be exported
	 * @param fname, target file destination
	 * @return success message
	 */
	public static boolean writeMembersToXML(ArrayList<Member> members, String fname) {
		try {
			XMLEncoder xml = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fname)));
			xml.writeObject(members);
			xml.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
