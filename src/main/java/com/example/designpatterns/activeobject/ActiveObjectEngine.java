package com.example.designpatterns.activeobject;

import java.util.LinkedList;

public class ActiveObjectEngine {
    private LinkedList<Runnable> commands;

    public ActiveObjectEngine() {
        commands = new LinkedList<>();
    }

    public void addCommand(final Runnable command) {
        commands.add(command);
    }

    public void run() {
        while(!commands.isEmpty()) {
            Runnable command = commands.getFirst();
            commands.removeFirst();
            command.run();
        }
    }
}
