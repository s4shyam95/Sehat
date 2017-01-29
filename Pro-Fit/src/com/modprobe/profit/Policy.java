package com.modprobe.profit;

public class Policy {
	
	String name;
	int insuranceCoverage; //(in lacs)
	int premiumAmount;
	int preExistingcondition;// (in years)
	int hospitalRoomEligibility;// (in Rs)

	boolean maternityCover; 
	boolean hospitalRoom;
	boolean ambulanceCover;
	boolean dayCareCover;
	boolean bonusOnNoClaim;

	int rating;
	
	
	
	Policy(String name,int insuranceCoverage,int premiumAmount,int preExistingcondition,int hospitalRoomEligibility,boolean maternityCover,boolean hospitalRoom,boolean ambulanceCover,boolean dayCareCover,boolean bonusOnNoClaim, int rating)
    {
this.name = name;
this.insuranceCoverage = insuranceCoverage;
this.premiumAmount = premiumAmount;
this.preExistingcondition = preExistingcondition;
this.hospitalRoomEligibility = hospitalRoomEligibility;
this.maternityCover = maternityCover;
this.hospitalRoom = hospitalRoom;
this.ambulanceCover = ambulanceCover;
this.dayCareCover = dayCareCover;
this.bonusOnNoClaim = bonusOnNoClaim;
    }

}