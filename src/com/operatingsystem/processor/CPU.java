package com.operatingsystem.processor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.operatingsystem.device.Device;
import com.operatingsystem.memory.Memory;
import com.operatingsystem.memory.PCB;

public class CPU {
	private Queue<PCB> ready_queue;
	int processID;
	boolean occupied;
	PCB current;
	Memory memory;
	Device[] list;

	public CPU(int size, Device[] list) {
		ready_queue = new LinkedList<PCB>();
		processID = 1;
		occupied = false;
		current = null;
		memory = new Memory(size);
		this.list = list;
	}

	public void start() {
		take_input_mode();
	}

	public void add_process(PCB proc) {
		ready_queue.add(proc);
	}

	private void take_input_mode() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String input;
			System.out
					.println("Enter command (A= new process, t= terminate current process,S=snapshot");
			input = scanner.nextLine();
			System.out.println(input);
			switch (input) {
			case "A":
				System.out
						.println("Enter the memory requirement of this process");
				int size = scanner.nextInt();
				PCB buffer = new PCB(processID, size);
				if (memory.allocate(buffer)) {
					add_process(buffer);
					System.out.println("Process added to memory at range "
							+ buffer.begin + "-" + buffer.end);
					processID++;
				} else {
					System.out.println("Memory full, cannot add new process");
				}
				if (!occupied) {
					if (!ready_queue.isEmpty()) {

						current = ready_queue.remove();
						occupied = true;
					}
				}
				break;
			case "S":
				System.out.println("Entering SnapShot mode");
				System.out
						.println("r: process id in ready queue, p: all printer information,"
								+ " d: all disk information, m: memory information");
				String s = scanner.nextLine();
				switch (s) {
				case "r":
					if (ready_queue.isEmpty()) {
						System.out.println("Nothing in ready queue");
					} else {
						System.out
								.println("The following are currenly in the ready queue");
						for (PCB itt : ready_queue) {
							System.out.print(itt.processor_id() + " ");
						}
						System.out.println();
					}
					break;
				case "p":
					for (Device itt : list) {
						if (itt.getDeviceType()) {
							itt.getCurrentTaskInfo();
						}
					}
					break;
				case "d":
					for (Device itt : list) {
						if (!itt.getDeviceType()) {
							itt.getCurrentTaskInfo();
						}
					}
					break;
				case "m":
					if (current == null) {
						System.out
								.println("Nothing is being executed right now in the CPU");
					} else {
						System.out.println("In CPU:");
						System.out.println(current.processor_id() + "  "
								+ "in memory " + current.begin + "-"
								+ current.end);
						System.out.println("In Ready Queue:");
						if (!ready_queue.isEmpty()) {
							for (PCB itt : ready_queue) {
								System.out.println(itt.processor_id() + "  "
										+ "in memory " + itt.begin + "-"
										+ itt.end);
							}
						}else{
							System.out.println("Read Queue is empty");
						}

					}
					break;
				default:
					System.out.println("Invalid Command");
					break;

				}

				break;
			case "t":
				if (!occupied) {
					System.out.println("CPU is empty, nothing to terminate");
				} else {
					if (memory.deallocateMeory(current)) {
						System.out.println("Terminated process "
								+ current.processor_id() + " at locaton "
								+ current.begin + "-" + current.end);
						if (!ready_queue.isEmpty()) {

							current = ready_queue.remove();
							occupied = true;

						} else {
							current = null;
							occupied = false;
						}

					}

				}
				break;
			default:
				boolean check = false;
				for (Device itt : list) {
					if (input.equals(itt.getDeviceName()) && current != null) {
						check = true;
						System.out.println("Enter the file name");
						String file_name = scanner.nextLine();

						if (!itt.getDeviceType()) {
							System.out
									.println("Do you want to write or read to this disk (1 for read, 0 for write)");
							int isRead = scanner.nextInt();
							if (isRead == 0) {
								System.out.println("Enter the file size");
								double file_size = scanner.nextDouble();
								current.setIOInfo(file_name, file_size, isRead,
										itt);
							} else {
								current.setIOInfo(file_name, 0, isRead, itt);
							}

						} else {
							System.out.println("Enter the file size");
							double file_size = scanner.nextDouble();
							current.setIOInfo(file_name, file_size, 0, itt);
						}

						itt.enqueue(current);
						occupied = false;
						if (!ready_queue.isEmpty()) {
							current = ready_queue.remove();
							occupied = true;

						} else {
							current = null;
							occupied = false;
						}
					} else if (input.equals(itt.getDeviceName().toUpperCase())) {
						check = true;
						PCB hold = itt.complete();
						if (hold != null) {
							ready_queue.add(hold);
							System.out.println("Completed task in "
									+ itt.getDeviceName());
						} else {
							System.out.println("Nothing in "
									+ itt.getDeviceName() + "'s queue");
						}

					} else {

					}

				}
				if (!check) {
					System.out
							.println("Invalid Command or no process currently running");
				}
				break;
			}

		}
	}
}
