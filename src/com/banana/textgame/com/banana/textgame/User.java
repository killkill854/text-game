package com.banana.textgame;

import java.util.ArrayList;

public class User {
    public    boolean tired = false;
    public     int dollars = 0;
    public    boolean[] knowLanguage = {true, false, false, false, false};
    public   ArrayList companies = new ArrayList();

    void printLnInfo () {
        String dollarsString = "";
        for (int i = 0; i < dollars; i = i + 1) {
            dollarsString = dollarsString + "$";
        }

        напечатайИзвестныеЯзыки();


        System.out.println("Компании");
        for (int i = 0; i < companies.size(); ++i) {
            System.out.println("- " + companies.get(i));
        }
    }


    void напечатайИзвестныеЯзыки() {
        System.out.println("Вы знаете следующие языки: ");
        for (int i = 0; i < Main.languages.length; i++) {
            if (knowLanguage[i] == true) {
                System.out.println(Main.languages[i]);
            }
        }
    }


}