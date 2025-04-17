package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private int coursefee;
    private int semester;

    Student(){}

    Student(String name, int coursefee, int semester){
        super();
        this.name = name;
        this.coursefee = coursefee;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCoursefee() {
        return coursefee;
    }

    public int getSemester() {
        return semester;
    }

   public void setName(String name) {
       this.name = name;
   }

   public void setCoursefee(int coursefee) {
       this.coursefee = coursefee;
   }

   public void setSemester(int semester) {
       this.semester = semester;
   }
}
