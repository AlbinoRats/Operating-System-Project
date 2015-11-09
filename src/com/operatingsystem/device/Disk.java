package com.operatingsystem.device;

public class Disk implements Device<Disk> {
	//Disk list
	private String disk_name;
	private boolean device_type;

	@Override
	public void setPrinterName(String name) {
		this.disk_name=name;
		
	}

	@Override
	public String getPrinterName() {
		return disk_name;
	}

	@Override
	public void setType(boolean t) {
		
		
	}

	@Override
	public boolean getDeviceType() {
		// TODO Auto-generated method stub
		return false;
	}
	

	

}
