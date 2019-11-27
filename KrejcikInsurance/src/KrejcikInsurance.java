
/*
 * Jeff Krejcik
 * 
 * Insurance Application
 * 
 * This application calculates insurance scores, allowing the user to
 * load a file, add new users, and export to a file.
 * 
 */

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class KrejcikInsurance {
	// User interaction menu
	public static void showMenu() {
		System.out.println("\n------------------------------------------------------");
		System.out.println("Here are your options:");
		System.out.println("    1. List members");
		System.out.println("    2. Add a new member");
		System.out.println("    3. Save members");
		System.out.println("    4. Load members");
		System.out.println("    5. Assess members");
		System.out.println("    6. Save assessments as JSON");
		System.out.println("    7. Exit");
		System.out.print("Please enter your choice: ");
	}

	// Welcome message displayed on app launch (bonus points for catching the
	// reference)
	public static void printWelcome() {
		System.out.println("******************************************************");
		System.out.println("|            KREJCIK INSURANCE SCORE CARD            |");
		System.out.println("|----------------------------------------------------|");
		System.out.println("|        This app scores a potential customer        |");
		System.out.println("|        on various health attributes: blood         |");
		System.out.println("|        pressure, age, height, weight, and          |");
		System.out.println("|        family history of disease. It writes        |");
		System.out.println("|        each member's unsurance grade to a          |");
		System.out.println("|        JSON file so that they can be easily        |");
		System.out.println("|        shared on a web-based data exchange         |");
		System.out.println("*****************************************************\n");
	}

	// Determine number of members loaded from file
	private static String numberOfMembersLoaded(ArrayList<Member> members) {
		return "\n" + members.size() + " member(s) were read.\n";
	}

	// Main procedure
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fname, ftype;
		ArrayList<Member> members; // TODO
		int choice;
		
		printWelcome();  // TODO
		System.out.print("Enter the name of the Insurance file: ");
		// Display count of insurance members
		fname = sc.nextLine();
		members = MemberReader.readMembersFromTextFile(fname);  // TODO
		
		// Exit if file failed
		if (members == null) {
			System.out.println("Error loading file!");
			System.out.println("Please relaunch the application after verifying the contents of the member file.");
			System.out.println("Goodbye.");
		} else {
			System.out.println(numberOfMembersLoaded(members));
			do {
				showMenu();
				while (!sc.hasNextInt()) {
					sc.next();
				}
				choice = sc.nextInt();
				
				if (choice == 1) {
					// List Members
					MemberWriter.writeMembersToScreen(members);
				} else if (choice == 2) {
					// Add a new member
					String nameFirst, nameLast;
					int age, height, weight, bpSyst, bpDias;
					String cancer, diabetes, alzheimers;
					Member tempMem;
					
					System.out.print("Enter first and last name: ");
					nameFirst = sc.next();
					nameLast = sc.next();
					System.out.print("Enter age: ");
					age = sc.nextInt();
					System.out.print("Enter height in inches: ");
					height = sc.nextInt();
					System.out.print("Enter weight in pounds: ");
					weight = sc.nextInt();
					System.out.print("Enter blood pressure (sys and dia): ");
					bpSyst = sc.nextInt();
					bpDias = sc.nextInt();
					System.out.println("Has a family member had ... (y/n)");
					System.out.print("Cancer? ");
					cancer = sc.next().trim().substring(0, 1).toLowerCase();
					System.out.print("Diabetes? ");
					diabetes = sc.next().trim().substring(0, 1).toLowerCase();
					System.out.print("Alzheimers? ");
					alzheimers = sc.next().trim().substring(0, 1).toLowerCase();
					
					try {
						tempMem = new Member(nameFirst, nameLast, age, height, weight, bpSyst, bpDias, cancer, diabetes, alzheimers);
						members.add(tempMem);
						System.out.println("\nThe new member has been added.");
					} catch (Exception ex) {
						System.out.println("\nMember not saved! Please try again.");
					}
				} else if (choice == 3) {
					// Save Members
					System.out.print("(T)ext, (B)inary, or (X)ML? ");
					ftype = sc.next().substring(0, 1).toUpperCase();
					System.out.print("Enter the name of the output file: ");
					fname = sc.next();
					
					if (ftype.equals("T")) { // Attempt to write to a text file
						if (MemberWriter.writeMembersToTextFile(members, fname)) {
							System.out.println("\nMembers were written successfully."); // Success
						} else {
							System.out.println("\nError writing members. Please try again."); // Failure
						}
					}
					else if (ftype.equals("B")) { // Attempt to write to a binary file
						if (MemberWriter.writeMembersToBinary(members, fname)) {
							System.out.println("\nMembers were written successfully."); // Success
						} else {
							System.out.println("\nError writing members. Please try again."); // Failure
						}
					}
					else if (ftype.equals("X")) { // Attempt to write to an XML file
						if (MemberWriter.writeMembersToXML(members, fname)) {
							System.out.println("\nMembers were written successfully."); // Success
						} else {
							System.out.println("\nError writing members. Please try again."); // Failure
						}
					};
				} else if (choice == 4) {
					// Load Members
					System.out.print("(T)ext, (B)inary, or (X)ML? ");
					ftype = sc.next().substring(0, 1).toUpperCase();
					System.out.print("\nEnter the name of the input file: ");
					fname = sc.next();
					
					if (ftype.equals("T")) { // Attempt to write to a text file
						if (MemberReader.readMembersFromTextFile(fname) != null) {
							members = MemberReader.readMembersFromTextFile(fname);
							System.out.println(numberOfMembersLoaded(members));
						} else {
							System.out.println("\nError loading file! Please try again.");
						}
					}
					else if (ftype.equals("B")) { // Attempt to write to a binary file
						if (MemberReader.readMembersFromBinary(fname) != null) {
							members = MemberReader.readMembersFromBinary(fname);
							System.out.println(numberOfMembersLoaded(members));
						} else {
							System.out.println("\nError loading file! Please try again.");
						}
					}
					else if (ftype.equals("X")) { // Attempt to write to an XML file
						if (MemberReader.readMembersFromXML(fname) != null) {
							members = MemberReader.readMembersFromXML(fname);
							System.out.println(numberOfMembersLoaded(members));
						} else {
							System.out.println("\nError loading file! Please try again.");
						}
					}
				} else if (choice == 5) {
					// Assess members
					System.out.println("\nHere are the insurance assessments:\n");
					InsuranceScoreWriter.writeScoresToScreen(members);
				} else if (choice == 6) {
					// Save assessments as JSON
					System.out.print("Enter name of JSON file: ");
					fname = sc.next();
					if (InsuranceScoreWriter.writeScoresToJSON(members, fname)) {
						System.out.println("\nThe scores were written successfully.");
					} else {
						System.out.println("\nError creating file.  Please try again."); 
					}
				}
		} while (choice != 7);
		// Exit application
		System.out.println();
		System.out.println("******************************************************");
		System.out.println("|             KREJCIK INSURANCE SCORE CARD           |");
		System.out.println("|                       THANK YOU                    |");
		System.out.println("******************************************************");
		}
		
	}

}
