package com.operatingsystem.device;

public class Disk extends Device {

	public Disk(boolean type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public  void setDeviceName(int device_number){
		this.device_name="Disk"+device_number;
	} 
	

}
