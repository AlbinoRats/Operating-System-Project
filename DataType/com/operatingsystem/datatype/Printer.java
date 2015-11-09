package com.operatingsystem.datatype;

public class Printer implements Device<Printer> {
	//Printer list
	private Printer[] listofPrinter;

	@Override
	public void setTotalDevice(int amount) {
		// TODO Auto-generated method stub
		listofPrinter=new Printer[amount];
		
	}

	@Override
	public Printer[] getDeviceArray() {
		// TODO Auto-generated method stub
		return listofPrinter;
	}
	@Override
	public int getDeviceSize(){
		return listofPrinter.length;
	}

}
