package com.homework.store;

public class Buyer extends UserAbstract
{
    String fio;
    String phone;
    String login;
    String UUID;
    int id;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Buyer(String UUID, int id, String fio, String login, String password, String phone)
    {
        super(login,password);
        this.login = login; //TODO почему без присвоения login, его не видно в классе Buyer?
        this.fio = fio;
        this.phone = phone;
        this.id = id;
        this.UUID = UUID;
    }

    public String getFio()
    {
        return fio;
    }

    public void setFio(String fio)
    {
        this.fio = fio;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }


}
