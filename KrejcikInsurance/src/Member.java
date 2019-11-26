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
	private int age, height, weight, bpSyst, bpDias, score;
	

	private boolean cancer, diabetes, alzheimers;
	
	
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
		if (age > 0) { this.age = age; }
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		if (height > 0) { this.height = height; }
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		if (weight > 0) { this.weight = weight; }
	}
	public int getBpSyst() {
		return bpSyst;
	}
	public void setBpSyst(int bpSyst) {
		if (bpSyst > 0) { this.bpSyst = bpSyst; }
	}
	public int getBpDias() {
		return bpDias;
	}
	public void setBpDias(int bpDias) {
		if (bpDias > 0) { this.bpDias = bpDias; }
	}
	public boolean isCancer() {
		return cancer;
	}
	public void setCancer(boolean cancer) {
		this.cancer = cancer;
	}
	public boolean isDiabetes() {
		return diabetes;
	}
	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}
	public boolean isAlzheimers() {
		return alzheimers;
	}
	public void setAlzheimers(boolean alzheimers) {
		this.alzheimers = alzheimers;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		// TODO
		if (score > 0) { this.score = score; }
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
		this.setCancer(false);
		this.setDiabetes(false);
		this.setAlzheimers(false);
		this.setScore(0);
	}
	
	public Member(String nameFirst, String nameLast, int age, int height, int weight, int bpSyst, int bpDias, boolean cancer, boolean diabetes, boolean alzheimers) {
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
		this.setScore(calculateScore(this)); // TODO
	}
	
	
	// Risk assessment output
	@Override
	public String toString() {
		return String.format("Name:   %30s\nScore:  %30s\nVerdict:%30s",
				this.getNameLast() + ", " + this.getNameFirst(),
				this.getScore(),
				assessRisk(this)); // TODO
	}
}
