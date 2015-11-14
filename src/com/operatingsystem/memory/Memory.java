package com.operatingsystem.memory;

import java.util.ArrayList;

public class Memory {
	// false means memory space is empty, true means it's being used
	private ArrayList<Boolean> memory = new ArrayList<Boolean>();

	public Memory(int memory_size) {
		for (int i = 0; i < memory_size; i++) {
			memory.add(false);
		}
	}

	public boolean allocate(PCB buffer) {
		int size = buffer.get_size();
		boolean found = false;
		try {
			for (int i = 0; i < memory.size(); i++) {
				if (!found) {
					int j = i;
					boolean flag = false;
					while (j < i + size - 1 && !flag) {
						if (memory.get(j)) {
							flag = true;
							i = j + 1;
						} else {
							j++;
						}

					}
					if (!flag) {
						found = true;
						buffer.begin = i;
						buffer.end = j;
						for (int x = buffer.begin; x < buffer.end; x++) {
							memory.set(x, true);
						}

					}
				} else {
					break;
				}
			}
			if (!found) {
				return false;
			} else {
				return true;
			}
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean deallocateMeory(PCB buffer) {
		try {
			for (int i = buffer.begin; i < buffer.end; i++) {
				memory.set(i, false);
			}
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

}
