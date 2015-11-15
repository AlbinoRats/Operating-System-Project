package operatingsystem;

public class Printer extends Device {

	public Printer(boolean type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public  void setDeviceName(int device_number){
		this.device_name="p"+device_number;
	} 
	@Override
	public void getCurrentTaskInfo(){
		System.out.println(device_name+": ");
		if(current==null){
			System.out.println("Currently no task being executed");
		}else{
			System.out.println(current.file_name+"  "+current.file_size);
			queue_status();
		}
	}
	

}
