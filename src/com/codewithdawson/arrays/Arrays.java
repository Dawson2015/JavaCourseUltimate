package com.codewithdawson.arrays;

public class Arrays {
    public static class Main {

        public static void main(String[] args) {
            int[] numbers = new int[5];
            numbers[0] = 1;
            numbers[1] = 2;
            java.util.Arrays.sort(numbers);
            System.out.println(java.util.Arrays.toString(numbers));
        }
    }
}
