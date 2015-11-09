package com.operatingsystem.datatype;

public class Disk implements Device<Disk> {
	private Disk[] listofDisk;
	
	@Override
	public void setTotalDevice(int amount) {
		// TODO Auto-generated method stub
		listofDisk=new Disk[amount];
		
	}

	@Override
	public Disk[] getDeviceArray() {
		// TODO Auto-generated method stub
		return listofDisk;
	}
	@Override
	public int getDeviceSize(){
		return listofDisk.length;
	}
	

}
