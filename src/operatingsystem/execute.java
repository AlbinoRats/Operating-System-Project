package operatingsystem;


public class execute {
	public static void main(String args[]){
		SystemGeneration generation_phase=new SystemGeneration();
		generation_phase.generate_system();
		
		SystemRunning running_phase=new SystemRunning(generation_phase.getMemory(),generation_phase.getDeviceList());
		running_phase.run();
	}
}
