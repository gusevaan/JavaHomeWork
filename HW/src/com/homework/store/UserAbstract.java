package com.homework.store;

public abstract class UserAbstract
{
    protected static String login;
    private String password;

    public UserAbstract(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
