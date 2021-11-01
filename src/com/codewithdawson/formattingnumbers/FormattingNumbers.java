package com.codewithdawson.formattingnumbers;

import java.text.NumberFormat;

public class FormattingNumbers {
    public static void main(String[] args) {
        String result = NumberFormat.getPercentInstance().format(.1);
        System.out.println(result);
    }
}
