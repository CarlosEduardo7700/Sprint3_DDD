package org.example;

import org.example.components.MenuComponents;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        MenuComponents menu = new MenuComponents();

        menu.exibirMenu();
    }
}