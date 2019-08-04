package com.elearndev.todo.security;

public class JwtProperties {
    public static final String SECRET = "salamlesamis";
    public static final int EXPIRATION_TIME = 3600000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
