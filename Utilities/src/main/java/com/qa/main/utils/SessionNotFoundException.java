package com.qa.main.utils;

public class SessionNotFoundException extends Exception {

    public SessionNotFoundException getSessionId() throws SessionNotFoundException {
        System.out.println("Session not found. Please try again.");
        System.exit(1);
        throw new SessionNotFoundException();
    }
}
