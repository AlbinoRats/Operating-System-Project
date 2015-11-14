package com.operatingsystem.processor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CPU {
	private Queue<processor> ready_queue;

	public CPU() {
		ready_queue = new LinkedList<processor>();

	}

	private void start() {

	}

	public void add_processor(processor proc) {
		ready_queue.add(proc);
	}

	private void take_input_mode() {
		Scanner scanner = new Scanner(System.in);
		char input = scanner.next(".").charAt(0);
		switch (input) {
		case 'A':
			break;
		case 'S':
			
			break;
		case '

		}

	}
}
