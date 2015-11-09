package com.operatingsystem.device;

public class Printer implements Device<Printer> {
	//Printer info

	private String printer_name;
	//0 for printer, 1 for disk
	private boolean device_type;

	@Override
	public void setPrinterName(String name) {
		this.printer_name=name;
		
	}

	@Override
	public String getPrinterName() {
		
		return printer_name;
	}

	@Override
	public void setType(boolean t) {
		this.device_type=t;
		
	}

	@Override
	public boolean getDeviceType() {
		return device_type;
	}
	

	

}
