package edu.ycp.cs320.myYorkSpace.shared;

public class Birthday {
	private int month;
	private int day;
	private int year;
	public Birthday(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String toString(){
		String stringMonth = this.month+"";
		String stringDay = this.day+"";
		String stringYear = this.year+"";
		if (this.month<10){
			stringMonth = "0"+this.month;
		}
		if (this.day<10){
			stringDay = "0"+this.day;
		}
		stringYear = this.year+"";
		return stringMonth + "/" + stringDay + "/" + stringYear;
	}
		
}
