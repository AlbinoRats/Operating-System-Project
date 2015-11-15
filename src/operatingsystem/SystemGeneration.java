package operatingsystem;

import java.util.InputMismatchException;
import java.util.Scanner;


public class SystemGeneration {
	private int memory_size;
	private Device[] DeviceList;
	private int disk_size;
	private int printer_size;
	public void set_memory(int size){
		this.memory_size=size;
	}
	public void set_printer(int amount){
		printer_size+=amount;
	}
	public void set_disk(int amount){
		disk_size+=amount;
	}
	public void generate_system(){
		System.out.println("System is generating, please enter the required informations");
		try{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please Enter the Memory Size in Bytes");
		set_memory(scanner.nextInt());
		System.out.println("Please Enter the Amount of Printers");
		set_printer(scanner.nextInt());
		System.out.println("Please Enter the Amount of Disks" );
		set_disk(scanner.nextInt());
		device_list_set_up();
		System.out.println("Your system has been installed with: ");
		System.out.println(memory_size+" Bytes of memory");
		System.out.println(disk_size+" Disk(s)");
		System.out.println(printer_size+" Printer(s)");
		System.out.println("System is now running.");
		
		}catch(InputMismatchException e){
			System.out.println("System crashed!\nYou've entered the wrong data type during system initialization");
		}
		
		//Test();
		
	}
	private void device_list_set_up(){
		DeviceList=new Device[disk_size+printer_size];
		for(int i=0;i<disk_size;i++){
			Device device=new Disk(false);
			device.setDeviceName(i+1);
			DeviceList[i]=device;
		}
		for(int i=disk_size;i<disk_size+printer_size;i++){
			Device device=new Printer(true);
			device.setDeviceName(i-disk_size+1);
			DeviceList[i]=device;
		}
	}
	private void Test(){
		for(Device itt: DeviceList){
			System.out.println(itt.getDeviceName()+" ");
		}
	}
	public int getMemory(){
		return memory_size;
	}
	public Device[] getDeviceList(){
		return DeviceList;
	}
	public SystemGeneration(){
		
		
	}

}
