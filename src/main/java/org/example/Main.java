package org.example;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame Frame1 = new JFrame("Menu");
        Frame1.setContentPane(new Menu().menu);
        Frame1.setSize(400,400);
        Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame1.setVisible(true);
        Frame1.setLocationRelativeTo(null);
    }
}