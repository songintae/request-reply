package com.example.requestreply.common;


import lombok.Getter;

@Getter
public class CommandReply<T> {
    private String transactionId;
    private String command;
    private String replyStatus;
    private T data;

    protected CommandReply() {
        //for-serialize
    }
}
