/*
 * Jeff Krejcik
 * 
 * Member Class
 * This is the blueprint for creating new members
 */

import java.util.ArrayList;
import java.io.Serializable;

public class Member implements Serializable {
	private String nameFirst, nameLast;
	private int age, height, weight, bpSyst, bpDias;
	private InsuranceScore score;
	private String cancer, diabetes, alzheimers;
	
	
	// Getters and Setters
	public String getNameFirst() {
		return nameFirst;
	}
	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst.trim();
	}
	public String getNameLast() {
		return nameLast;
	}
	public void setNameLast(String nameLast) {
		this.nameLast = nameLast.trim();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if (age >= 0) { this.age = age; }
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		if (height >= 0) { this.height = height; }
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		if (weight >= 0) { this.weight = weight; }
	}
	public int getBpSyst() {
		return bpSyst;
	}
	public void setBpSyst(int bpSyst) {
		if (bpSyst >= 0) { this.bpSyst = bpSyst; }
	}
	public int getBpDias() {
		return bpDias;
	}
	public void setBpDias(int bpDias) {
		if (bpDias >= 0) { this.bpDias = bpDias; }
	}
	public String getCancer() {
		return cancer;
	}
	public void setCancer(String cancer) {
		this.cancer = cancer;
	}
	public String getDiabetes() {
		return diabetes;
	}
	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}
	public String getAlzheimers() {
		return alzheimers;
	}
	public void setAlzheimers(String alzheimers) {
		this.alzheimers = alzheimers;
	}
	public InsuranceScore getScore() {
		return score;
	}
	public void setScore(InsuranceScore score) {
		this.score = score;
	}
	
	
	// Constructors
	public Member() {
		this.setNameFirst("");
		this.setNameLast("");
		this.setAge(0);
		this.setHeight(0);
		this.setWeight(0);
		this.setBpSyst(0);
		this.setBpDias(0);
		this.setCancer("n");
		this.setDiabetes("n");
		this.setAlzheimers("n");
		this.setScore(null);
	}
	
	public Member(String nameFirst, String nameLast, int age, int height, int weight, int bpSyst, int bpDias, String cancer, String diabetes, String alzheimers) {
		this.setNameFirst(nameFirst);
		this.setNameLast(nameLast);
		this.setAge(age);
		this.setHeight(height);
		this.setWeight(weight);
		this.setBpSyst(bpSyst);
		this.setBpDias(bpDias);
		this.setCancer(cancer);
		this.setDiabetes(diabetes);
		this.setAlzheimers(alzheimers);
		this.setScore(new InsuranceScore(this));
	}
	
	
	// Member information output
	@Override
	public String toString() {
		return String.format(
				"%s, %s\n"  // LastName, FirstName
				+ "Age            %3d\n"
				+ "Height         %3d in\n"
				+ "Weight         %3d lbs\n"
				+ "BP Syst        %3d\n"
				+ "BP Dias        %3d\n"
				+ "Cancer           %s\n"
				+ "Diabetes         %s\n"
				+ "Alzheimers       %s\n"
				+ "-----------------------",
				getNameLast(), getNameFirst(),
				getAge(),
				getHeight(),
				getWeight(),
				getBpSyst(),
				getBpDias(),
				getCancer(),
				getDiabetes(),
				getAlzheimers()
				);
	}
}
