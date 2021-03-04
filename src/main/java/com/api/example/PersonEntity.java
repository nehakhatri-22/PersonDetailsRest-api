package com.api.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "TBL_PERSON")
public class PersonEntity {


        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;

        @Column(name="first_name")
        private String first_name;

        @Column(name="last_name")
        private String last_name;

        @Column(name="age")
        private int age;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavourite_color() {
        return favourite_color;
    }

    public void setFavourite_color(String favourite_color) {
        this.favourite_color = favourite_color;
    }

    @Column(name="favourite_color")
    private String favourite_color;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

    }