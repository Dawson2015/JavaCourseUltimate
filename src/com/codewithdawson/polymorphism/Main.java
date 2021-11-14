package com.codewithdawson.polymorphism;

import com.codewithdawson.inheritance.TextBox;
import com.codewithdawson.inheritance.UIControl;

public class Main {
    public static void main(String[] args) {
        UIControl[] controls={new TextBox()};
        for (var control: controls)
            control.render();//polymorphism in action
    }
}
