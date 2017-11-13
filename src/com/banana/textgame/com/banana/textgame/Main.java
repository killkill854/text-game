package com.banana.textgame;

import java.util.Scanner;

public class Main {

    int Banan = 85;

    /*
     * Главный метод.
     */
    public static void main(String[] args) {
        // вызывает метод start()
        new Main().start();
    }

    /*
     * Метод с логикой игры.
     */
    private void start() {
        onStart();
        for (int i = 1; i <= 5; ++i) {
            onNewDay(i);
        }
        onFinish();
    }

    /*
     * Метод вызывается один раз при старте игры.
     */

    void onStart() {
        for (int i=0 ; i<10 ;++i){
            System.out.println("Загрузка: "+ (i * 10) + "%");
        }

        Scanner keyboard = new Scanner(System.in);
        String[] variants = {"Кто вы такой?", "Как вас называть?", "Мргллрг"};
        String v = variants[(int) (Math.random() * variants.length)];
        System.out.println(v);
        String answer = keyboard.nextLine();
        System.out.println("Hello," + answer);


    }

    boolean tired = false;
    int dollars = 0;
    String[] languages = {"Java", "Kotlin", "Paskal", "BananaLanguage", "C++"};
    boolean[] knowLanguage = {true, false, false, false, false};
    Scanner keyboard = new Scanner(System.in);
    int i = 0;

    /*
     * Метод вызывается каждый игровый день.
     * Единственный параметр: dayNumber - номер текущего игрового дня.
     */
    void onNewDay(int dayNumber) {
        System.out.println("День номер " + dayNumber + ".");
        String dollarsString = "";
        for (int i = 0; i < dollars; i = i + 1) {
            dollarsString = dollarsString + "$";
        }
        напечатайИзвестныеЯзыки();
//        int i = 0;

//        while (i < dollars){
//
//            dollarsString = dollarsString + "$";
//
//            i= i + 1;
//
//        }
//        System.out.println("Ваш счёт: "+ dollarsString + ".");


        System.out.println("Ваше действие ");
        String action = keyboard.nextLine();

        switch (action.toLowerCase()) {
            case "код":
                System.out.println("Enter cod on this day " + dayNumber + "." + "" +
                        "You monney =" + dollars + "$.");
                String cod = keyboard.nextLine();
                System.out.println("You are HALAVSHIK!: " + (cod.startsWith(" ") && cod.endsWith(" ")));

                dollars = dollars + cod.length();
                break;

            case "кофе":
                dollars -= 2;
                System.out.println("Кофе. Ура!");
                break;

            case "пицца":
                съестьПиццу();

            case "устал":
                tired = true;
                break;
            case "изучить":
                learnLanguage();
                System.out.println(languages[i]);


                break;

            default:
                System.out.println("Операция не подерживается");

        }


//        if (action.equals("кофе")) {
//            dollars -= 2;
//            System.out.println("Кофе. Ура!");
//        }else if (action.equals("код")) {
//            System.out.println("Enter cod on this day "+ dayNumber + "." + "" +
//                    "You monney =" + dollars +"$.");
//            String cod = keyboard.nextLine();
//            System.out.println("You are HALAVSHIK!: " + (cod.startsWith(" ") && cod.endsWith(" ")));
//
//            dollars = dollars + cod.length();
//        }else if (action.equals("Поесть")){
//            dollars -= 10;
//            System.out.println("Наконецто, еда!!!!");
//
//        }else {
//            System.out.println("Операция не подерживается");
    }

//        System.out.println("Enter cod on this day "+ dayNumber + "." + "" +
//                "You monney =" + dollars +"$.");
//        String cod = keyboard.nextLine();
//        System.out.println("You are HALAVSHIK!: " + (cod.startsWith(" ") && cod.endsWith(" "));
//
//        dollars = dollars + cod.length();


    //}

    /*
     * Метод вызывается по завершению игры.
     */
    void onFinish() {

        System.out.println("Вы нрабрали очков: " + верниОчки());
    }

    void learnLanguage() {
        System.out.println("Какой язык будем учить?");
        String language = keyboard.nextLine();

        for (int i = 0; i < languages.length; i++) {
            if (languages[i].equals(language)) {
                knowLanguage[i] = true;
                dollars -= 100;
            }
        }
    }

    void напечатайИзвестныеЯзыки() {
        System.out.println("Вы знаете следующие языки: ");
        for (int i = 0; i < languages.length; i++) {
            if (knowLanguage[i] == true) {
                System.out.println(languages[i]);
            }
        }
    }

    void съестьПиццу() {
        System.out.println("Сколько кусков пиццы?");
        int количествоКусков = keyboard.nextInt();
        keyboard.nextLine();
        съестьПиццу(количествоКусков, 2);

    }

    void съестьПиццу(int количествоКусков, int стоимостьПиццы) {

        dollars -= стоимостьПиццы * количествоКусков;
        System.out.println("Вы скушали " + количествоКусков + " кусочков пиццы  " + "You monney =" + dollars + "$.");

    }

    int верниОчки() {
        int очки = dollars;
        for (int i=0; i< languages.length; ++i){
            if (knowLanguage[i] == true) {
                очки +=10;
            }
        }

        return очки;
    }
}


