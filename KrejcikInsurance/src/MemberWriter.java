/*
 * Jeff Krejcik
 * 
 * MemberWriter Class
 * This class outputs member information to various formats
 */
import java.io.*;
import java.util.ArrayList;
import java.beans.XMLEncoder;

public class MemberWriter {
	// Write member info to screen
	public static void writeMembersToScreen(ArrayList<Member> members) {
		for (Member m : members) {
			System.out.println(m);
		}
	}
	
	
	// Write member info to tab-delimited file
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
	
	
	// Write member info to binary file
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
	
	
	// Write member info to xml file
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
