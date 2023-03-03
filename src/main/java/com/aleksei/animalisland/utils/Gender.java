package com.aleksei.animalisland.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Gender {
    public static final Gender MALE = new Gender("male");
    public static final Gender FEMALE = new Gender("female");
    private final String gender;

    public Gender(String gender) {
        this.gender = gender;
    }
    public static Gender random(){
        return ThreadLocalRandom.current().nextInt(2) == 0 ? MALE : FEMALE;
    }
    @Override
    public String toString(){
        return gender;
    }
}
