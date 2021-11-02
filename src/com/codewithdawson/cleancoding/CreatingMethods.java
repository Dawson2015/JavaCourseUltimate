package com.codewithdawson.cleancoding;

public class CreatingMethods {
    public static void main(String[] args) {
        String message = greetUser("Mosh", "Hamedani");
        greetUser("Dawson", "Men");
    }
    public static String greetUser(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName;
    }
}
