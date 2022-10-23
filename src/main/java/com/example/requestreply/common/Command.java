package com.example.requestreply.common;

public class Command<T> {
    private String transactionId;
    private String command;
    private T data;

    protected Command() {
        //for-serialize
    }

    public Command(String transactionId, String command, T data) {
        this.transactionId = transactionId;
        this.command = command;
        this.data = data;
    }
}
