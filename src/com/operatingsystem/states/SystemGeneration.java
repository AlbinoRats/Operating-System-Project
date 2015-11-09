package com.operatingsystem.states;

import java.util.Scanner;

import com.operatingsystem.device.Device;
import com.operatingsystem.device.Disk;
import com.operatingsystem.device.Printer;;

public class SystemGeneration {
	private int memory_size;
	private Device<Printer> printer;
	private Device<Disk> disk;
	public void set_memory(int size){
		this.memory_size=size;
	}
	public void set_printer(int amount){
		this.printer.setTotalDevice(amount);
	}
	public void set_disk(int amount){
		this.disk.setTotalDevice(amount);
	}
	public void generate_system(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please Enter the Memory Size");
		set_memory(scanner.nextInt());
		System.out.println("Please Enter the Amount of Printers");
		set_printer(scanner.nextInt());
		System.out.println("Please Enter the Amount of Disks" );
		set_disk(scanner.nextInt());
		scanner.close();
		System.out.println("Your system has been installed with: ");
		System.out.println(memory_size+" Memory Size");
		System.out.println(disk.getDeviceSize()+" Disk(s)");
		System.out.println(printer.getDeviceSize()+" Printer(s)");
		System.out.println("System is now running.");
		
		
	}
	public SystemGeneration(){
		disk=new Disk();
		printer=new Printer();
		
	}

}
