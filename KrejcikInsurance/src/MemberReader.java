/*
 * Jeff Krejcik
 * 
 * MemberReader Class
 * This class reads member information from various formats
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.beans.XMLDecoder;
 
@SuppressWarnings("unchecked")  // Suggested in lecture/demo to suppress warnings
public class MemberReader {	
	// Read member info from tab-delimited file
	public static ArrayList<Member> readMembersFromTextFile(String fname) {
		try {
			Scanner fsc = new Scanner(new File(fname));
			ArrayList<Member> result = new ArrayList<Member>();
			String nameFirst, nameLast;
			int age, height, weight, bpSyst, bpDias;
			boolean cancer = false, diabetes = false, alzheimers = false;
			Member tempMem;
			
			while (fsc.hasNextLine()) {
				nameFirst = fsc.next();
				nameLast = fsc.next();
				age = fsc.nextInt();
				height = fsc.nextInt();
				weight = fsc.nextInt();
				bpSyst = fsc.nextInt();
				bpDias = fsc.nextInt();
				
				if (fsc.next() == "y") { cancer = true; }
				if (fsc.next() == "y") { diabetes = true; }
				if (fsc.next() == "y") { alzheimers = true; }
				
				tempMem = new Member(nameFirst, nameLast, age, height, weight, bpSyst, bpDias, cancer, diabetes, alzheimers);
				result.add(tempMem);
			}
			fsc.close();
			return result;
		} catch (Exception ex) {
			return null;
		}
	}
	
	// Read member info from binary file
	public static ArrayList<Member> readMembersFromBinary(String fname) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
			ArrayList<Member> result = (ArrayList<Member>)ois.readObject();
			ois.close();
			return result;
		} catch (Exception ex) {
			return null;
		}
	}
	
	// Read member info from xml file
	public static ArrayList<Member> readMembersFromXML(String fname) {
		try {
			XMLDecoder xml = new XMLDecoder(new BufferedInputStream(new FileInputStream(fname)));
			ArrayList<Member> result = (ArrayList<Member>)xml.readObject();
			xml.close();
			return result;
		} catch (Exception ex) {
			return null;
		}
	}
}
