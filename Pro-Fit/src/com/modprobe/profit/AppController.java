package com.modprobe.profit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

public class AppController extends Application {

	public SharedPreferences prefs;

	protected int checkcnt = 0;

	public static final String TAG = AppController.class.getSimpleName();

	private static AppController mInstance;
	public List<Policy> plist;
	public List<QueryMessage> g_database;
	public List<QueryMessage> next_msgs;
	public boolean filtered;

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
		this.filtered = false;
		g_database = new ArrayList<QueryMessage>();
		next_msgs = new ArrayList<QueryMessage>();
		fill_data();
		TypeFaceUtil.overrideFont(getApplicationContext(), "SERIF",
				"fonts/dinroundweb.ttf"); // font from assets:
											// "assets/fonts/Roboto-Regular.ttf
		prefs = this.getSharedPreferences("hdfc", Context.MODE_PRIVATE);
		File sd_card = Environment.getExternalStorageDirectory();
		File folder = new File(sd_card, Constants.CHAT_DATA_DIRECTORY);
		boolean success = false;
		if (!folder.exists()) {
		    success = folder.mkdir();
		}
		if (success) {
		    File folder1 = new File(folder, Constants.IMAGES_DIRECTORY);
		    if (!folder1.exists()) {
			    success = folder1.mkdir();
			}
		    File folder2 = new File(folder, Constants.AUDIO_DIRECTORY);
		    if (!folder2.exists()) {
			    success = folder2.mkdir();
			}
		} else {
		    //NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO 
		}
		folder = new File(sd_card, Constants.TIMAGES_DATA_DIRECTORY);
		if (!folder.exists()) {
		    success = folder.mkdir();
		}
		
		plist = new ArrayList<Policy>();
		plist.add(new Policy("Life Suraksha", 400000, 3875, 2, 3000, true,
				true, true, false, false, 3));
		plist.add(new Policy("Mediprime", 400000, 5103, 2, 2000, true,
				false, true, true, false, 4));
		plist.add(new Policy("PLUS SILVER", 400000, 4760, 2, 5000, true, true,
				false, false, true, 3));
		plist.add(new Policy("PLUS - GOLD", 400000, 5785, 3, 2500, true, false,
				false, true, true, 3));
	}

	public void fill_data(){
		g_database.add(new QueryMessage("What diseases does HDFC Life's gold \npremium plan cover?\nDoes it cover mental illnesses?", null, Constants.TEXT, 2));
		g_database.add(new QueryMessage("Yes it does. \nThe Anxiety Disorders,\nAdult Attention Deficit/\nHyperactivity Disorder (ADHD/ADD),\nBipolar Disorder: Overview, \nDepression,\nEating Disorders are covered", null, Constants.TEXT, 1));
//		g_database.add(new QueryMessage("What is the room rent limit?", null, Constants.TEXT, 2));
//		g_database.add(new QueryMessage("Fire!", null, Constants.TEXT, 1));
//		g_database.add(new QueryMessage("I do it for the hood", null, Constants.TEXT, 2));
//		g_database.add(new QueryMessage("I do it for fish", null, Constants.TEXT, 2));
//		g_database.add(new QueryMessage("White is right!", null, Constants.TEXT, 1));
		
		next_msgs.add(new QueryMessage("The room rent limit under this plan is Rs 3000/-", null, Constants.TEXT, 1));
		next_msgs.add(new QueryMessage("Happy to help you", null, Constants.TEXT, 1));
//		next_msgs.add(new QueryMessage("C", null, Constants.TEXT, 1));
//		next_msgs.add(new QueryMessage("D", null, Constants.TEXT, 1));
//		next_msgs.add(new QueryMessage("E", null, Constants.TEXT, 1));
//		next_msgs.add(new QueryMessage("F", null, Constants.TEXT, 1));
//		next_msgs.add(new QueryMessage("G", null, Constants.TEXT, 1));
	}
	
	public void fill_next(){
		if(!next_msgs.isEmpty()){
			g_database.add(next_msgs.get(0));
			next_msgs.remove(0);
		}
	}
	
	public static synchronized AppController getInstance() {
		return mInstance;
	}
	
	public void addToDataBase(String message, int type, int author){
		QueryMessage qm = new QueryMessage(message, null, type, author);
		g_database.add(qm);
	}
	
}