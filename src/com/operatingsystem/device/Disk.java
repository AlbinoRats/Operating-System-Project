package com.operatingsystem.device;

public class Disk extends Device {

	public Disk(boolean type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public  void setDeviceName(int device_number){
		this.device_name="d"+device_number;
	} 
	@Override
	public void getCurrentTaskInfo(){
		System.out.println(device_name+": ");
		if(current==null){
			System.out.println("Currently no task being executed");
		}else{
			if(current.isRead){
				System.out.println(current.file_name+"  "+"  "+"Operating reading" );
			}else{
				System.out.println(current.file_name+"  "+"Operating Writing"+"  "+current.file_size );
			}
			queue_status();
		}
	}
	

}
