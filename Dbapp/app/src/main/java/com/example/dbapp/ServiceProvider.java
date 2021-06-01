package com.example.dbapp;

public class ServiceProvider {

    String name,phone,email,occupation;

    public void setName(String name)
    {
        this.name=name;
    }

    public void setPhone(String phone)
    {
        this.phone=phone;
    }

    public void setEmail(String email)
    {
        this.email=email;
    }

    public void setOccupation(String occupation )
    {
        this.occupation=occupation;
    }

    public String getName()
    {
        return name;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }

    public String getOccupation()
    {
        return occupation;
    }
}

