package operatingsystem;

import java.util.LinkedList;
import java.util.Queue;


public class Device {
	protected String device_name;
	// 0 for disk, 1 for printer
	private boolean device_type;
	// sets the device name
	private Queue<PCB> device_queue;
	protected PCB current;
	public void setDeviceName(int device_number) {
		// override in child class
	}

	// gets the device name
	public String getDeviceName() {
		return device_name;
	}

	// returns the device type
	public boolean getDeviceType() {
		return device_type;
	}

	public Device(boolean type) {
		this.device_type = type;
		createDeviceQueue();
	}

	public void createDeviceQueue() {
		device_queue = new LinkedList<PCB>();
	}

	public boolean enqueue(PCB buffer) {
		if (buffer == null || device_queue == null) {
			return false;
		}
		device_queue.add(buffer);
		if(current==null){
			current=dequeue();
		}
		return true;
	}
	public PCB complete(){
		if(current==null){
			return null;
		}
		PCB tobeReturned=current;
		if(!device_queue.isEmpty()){
			current=dequeue();
		}
		else{
			current=null;
		}
		return tobeReturned;
	}
	private PCB dequeue() {
		return device_queue.remove();
	}
	public void queue_status() {
		
		if (device_queue.isEmpty()) {
			System.out.println( " No Process in " + device_name + "'s queue");
		} else {
			System.out.println("Process that are in " + device_name + " queue are ");
			for (PCB itt : device_queue) {
				if(itt.isRead){
					System.out.println(itt.processor_id()+"  "+itt.file_name+"  "+"Read Operation"+"  ");
				}
				else{
					System.out.println(itt.processor_id()+"  "+itt.file_name+"  "+"Write Operation"+"  "
				+Double.toString(itt.file_size));
				}
			}
		}
		
	}
	
	public void getCurrentTaskInfo(){
		//to be overriden
		
	}
}
