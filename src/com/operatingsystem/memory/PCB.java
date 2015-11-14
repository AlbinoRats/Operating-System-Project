package com.operatingsystem.memory;

import com.operatingsystem.device.Device;

public class PCB {
	private int size;
	private String processor_id;
	private boolean being_used;
	private int processor_size;
	public int begin;
	public int end;
	private String file_name;
	private double file_size;
	private boolean isRead;
	private Device device;
	public PCB(int id,int size){
		set_size(size);
		set_id(id);
	}
	public void set_size(int size){
		this.size=size;
	}
	public void set_id(int processor_id){
		this.processor_id="p"+processor_id;
	}
	public void switchUsed(){
		this.being_used=!being_used;
	}
	public boolean get_used(){
		return being_used;
	}
	public int get_size(){
		return size;
	}
	public String processor_id(){
		return processor_id;
	}
	public void setIOInfo(String name,double size, boolean isRead, Device device){
		this.file_name=name;
		this.file_size=size;
		this.isRead=isRead;
		this.device=device;
	}
	public Device getDevice(){
		return device;
	}

}
