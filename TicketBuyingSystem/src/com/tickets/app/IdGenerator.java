package com.tickets.app;

public final class IdGenerator {
private static int nextId = 1;
private IdGenerator() {}


public static int newId() {
return nextId++;
}
}
