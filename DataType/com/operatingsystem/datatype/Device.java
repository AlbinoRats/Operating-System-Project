package com.operatingsystem.datatype;

public interface Device<Type> {
	
	public abstract void setTotalDevice(int amount); 
	public abstract Type [] getDeviceArray();
	public abstract int getDeviceSize();
}
