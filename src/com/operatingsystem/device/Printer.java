package com.operatingsystem.device;

public class Printer extends Device {

	public Printer(boolean type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public  void setDeviceName(int device_number){
		this.device_name="p"+device_number;
	} 
	

}
