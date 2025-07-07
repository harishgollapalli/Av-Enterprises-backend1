package com.aventerprises.backend;

import lombok.Data;

@Data
public class TestLombok {
    private String name;

    public static void main(String[] args) {
        TestLombok obj = new TestLombok();
        obj.setName("Harish");
        System.out.println("Name: " + obj.getName());
        
    }
}
