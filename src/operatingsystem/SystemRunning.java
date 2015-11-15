package operatingsystem;


public class SystemRunning {
	//0 for not running, 1 for running
	private boolean isRunning;
	private int size;
	private Device[]list;
	public SystemRunning(int size, Device[]list){
		this.isRunning=true;
		this.size=size;
		this.list=list;
	}
	public void state_switch(){
		this.isRunning=!isRunning;
	}
	public boolean get_state(){
		return isRunning;
	}
	public void run(){
		CPU cpu=new CPU(size,list);
		
			cpu.start();
		
	}

}
