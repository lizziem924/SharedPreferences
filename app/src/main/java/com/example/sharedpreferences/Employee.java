package com.example.sharedpreferences;

import java.util.List;

public class Employee {
    private String firstName;
    private int age;
    private String mail;
    private Address address;
    private List<FamilyMember> family;

    public Employee(String f, int ag, String m, Address ad, List<FamilyMember> fam) {
        firstName = f;
        age = ag;
        mail = m;
        address = ad;
        family = fam;
    }


}
