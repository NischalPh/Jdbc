package com.nischal.jdbc.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryStorage {

	private List<Object> listStorage = new ArrayList<>();
	private Map<Object, Object> mapStorage = new HashMap<>();

	private MemoryStorage() {
	};

	// search why cannot we synchronize non final field. And implement using memory storage hashgmap
	private MemoryStorage memoryStorage;

	public MemoryStorage getInstance() {

		if (memoryStorage == null) {

			synchronized (memoryStorage) {

				if (memoryStorage == null) {

					memoryStorage = new MemoryStorage();

				}
			}
		}
		return memoryStorage;
	}
}
