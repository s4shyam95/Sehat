package com.modprobe.profit;

public class CompareItem
{
	String title1 = "";
	String title2 = "";
	String text1 = "";
	String text2 = "";
	boolean winner = false;
	boolean isHeader = true;
	public CompareItem(String title1) {
		this.title1 = title1;
		
	}
	
	public CompareItem(String title1, String text1, String text2, boolean winner) {
		this.title1 = title1;
		this.title2 = title1;
		this.text2 = text2;
		this.text1 = text1;
		this.isHeader = false;
		this.winner = winner;
	}
}