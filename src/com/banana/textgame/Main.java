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
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Who are you?");
        String  answer = keyboard.nextLine();
        System.out.println("Hello," + answer);


    }
     int dollars = 0;

    /*
     * Метод вызывается каждый игровый день.
     * Единственный параметр: dayNumber - номер текущего игрового дня.
     */
    void onNewDay(int dayNumber) {
        System.out.println("День номер "+ dayNumber + ".");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter cod on this day "+ dayNumber + "." + "" +
                "You monney =" + dollars +"$.");
        String cod = keyboard.nextLine();
        dollars = dollars + cod.length();


    }

    /*
     * Метод вызывается по завершению игры.
     */
    void onFinish() {

    }

}
