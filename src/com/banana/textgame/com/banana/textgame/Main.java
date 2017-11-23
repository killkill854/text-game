package com.banana.textgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner keyboard = new Scanner(System.in);
   static String[] languages = {"Java", "Kotlin", "Paskal", "BananaLanguage", "C++"};
//   boolean tired = false;
//    int dollars = 0;
//    boolean[] knowLanguage = {true, false, false, false, false};
//    ArrayList companies = new ArrayList();
User user = new User(); // Перенос из класса User

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
        System.out.println("привет" == "при"+"вет");

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




    int i = 0;

    /*
     * Метод вызывается каждый игровый день.
     * Единственный параметр: dayNumber - номер текущего игрового дня.
     */
    void onNewDay(int dayNumber) {
        System.out.println("День номер " + dayNumber + ".");






        System.out.println("Ваше действие ");
        String action = keyboard.nextLine();

        switch (action.toLowerCase()) {
            case "код":
                System.out.println("Enter cod on this day " + dayNumber + "." + "" +
                        "You monney =" + user.dollars + "$.");
                String cod = keyboard.nextLine();
                System.out.println("You are HALAVSHIK!: " + (cod.startsWith(" ") && cod.endsWith(" ")));

                user.dollars = user.dollars + cod.length();
                break;

            case "кофе":
                user.dollars -= 2;
                System.out.println("Кофе. Ура!");
                break;

            case "пицца":
                съестьПиццу();

            case "устал":
                user.tired = true;
                break;
            case "изучить":
                learnLanguage();
                System.out.println(languages[i]);


                break;
            case "работа":
                НайтиРаботу();

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
                user.knowLanguage[i] = true;
                user.dollars -= 100;
            }
        }
    }


    void съестьПиццу() {
        boolean корректныйВвод = false;
        while (корректныйВвод == false){
        System.out.println("Сколько кусков пиццы?");
        String строка = keyboard.nextLine();

        try {
            int количествоКусков = Integer.parseInt(строка);
            съестьПиццу(количествоКусков, 2);
            корректныйВвод = true;
        }catch (Exception e)
    {
        System.out.println("Ошибка!!!!");
    }}

}
    void съестьПиццу(int количествоКусков, int стоимостьПиццы) {

        Pizza вкуснаяПицца = new Pizza();
        user.dollars -= вкуснаяПицца.grtPrice(количествоКусков);
        System.out.println("Вы скушали " + количествоКусков + " кусочков пиццы  " + "You monney =" + user.dollars + "$.");

    }

    void НайтиРаботу () {

        System.out.println("В какую компанию поступим?");
        String compani = keyboard.nextLine();
        user.companies.add(compani);
    }

    int верниОчки() {
        int очки = user.dollars;
        for (int i=0; i< languages.length; ++i){
            if (user.knowLanguage[i] == true) {
                очки +=10;
            }
        }

        return очки;
    }
}


