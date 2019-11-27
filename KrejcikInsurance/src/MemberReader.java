import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.beans.XMLDecoder;
 
/**
This class reads member information from vaious file formats.
@author Jeff Krejcik
*/
@SuppressWarnings("unchecked")  // Suggested in lecture/demo to suppress warnings
public class MemberReader {	
	/**
	 Reads member data from a tab-delimited file.
	 @param fname, target text file path	 
	 */
	public static ArrayList<Member> readMembersFromTextFile(String fname) {
		try {
			Scanner fsc = new Scanner(new File(fname));
			ArrayList<Member> result = new ArrayList<Member>();
			String line, nameFirst, nameLast;
			int age, height, weight, bpSyst, bpDias;
			String cancer, diabetes, alzheimers;
			Member tempMem;
			
			while (fsc.hasNextLine()) {
				try {
					nameFirst = fsc.next();
					nameLast = fsc.next();
					age = fsc.nextInt();
					height = fsc.nextInt();
					weight = fsc.nextInt();
					bpSyst = fsc.nextInt();
					bpDias = fsc.nextInt();
					cancer = fsc.next();
					diabetes = fsc.next();
					alzheimers = fsc.next();
					
					tempMem = new Member(nameFirst, nameLast, age, height, weight, bpSyst, bpDias, cancer, diabetes, alzheimers);
					result.add(tempMem);
				} catch (Exception ex) {}
			}
			fsc.close();
			return result;
		} catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 Reads member data from a binary file.
	 @param fname, target binary file path	 
	 */
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
	
	/**
	 Reads member data from an XML file.
	 @param fname, target XML file path	 
	 */
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
