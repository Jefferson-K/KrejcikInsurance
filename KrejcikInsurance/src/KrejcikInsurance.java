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
		System.out.println("1. List members");
		System.out.println("2. Add a new member");
		System.out.println("3. Save members");
		System.out.println("4. Load members");
		System.out.println("5. Assess members");
		System.out.println("6. Save assessments as JSON");
		System.out.println("7. Exit");
		System.out.print("Please enter your choice: ");
	}
	
	
	// Welcome message displayed on app launch (bonus points for catching the reference)
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
		return members.size() + " member(s) were read.\n";
	}
	
	
	// Main procedure
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fname;
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
				} else if (choice == 3) {
					// Save Members
				} else if (choice == 4) {
					// Load Members
				} else if (choice == 5) {
					// Assess members
				} else if (choice == 6) {
					// Save assessments as JSON
				}
		} while (choice != 7);
		// Exit application
		System.out.println("******************************************************");
		System.out.println("|             KREJCIK INSURANCE SCORE CARD           |");
		System.out.println("|                       THANK YOU                    |");
		System.out.println("******************************************************");
		}
		
	}

}
