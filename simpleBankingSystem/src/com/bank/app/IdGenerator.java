package com.bank.app;

public final class IdGenerator {
	private static int lastId = 1;
	private IdGenerator() {}
	
	public static int newId() {
		return ++lastId;
	}
}
