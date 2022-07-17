package com.google.sps.data;

public final class Communication {
    private final long id;
    private final String name;
    private final String email;
    private final String reason;
    private final String message;

    public Communication(long id, String name, String email, String reason, String message) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.reason = reason;
        this.message = message;
    }
}
