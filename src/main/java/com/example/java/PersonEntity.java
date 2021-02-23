package com.example.java;


import java.io.Serializable;


public class PersonEntity  implements Serializable
{

    private static final long serialVersionUID=1L;

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFavourite_Color(String favourite_Color) {
        this.favourite_Color = favourite_Color;
    }

    private  String first_Name;
    private  String last_Name;
    private  int age;
    private  String favourite_Color;


}