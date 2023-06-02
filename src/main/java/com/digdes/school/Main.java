package com.digdes.school;


public class Main {
    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.execute("Вставте значкеие ‘lastName’ = ‘Федоров’ , ‘id’=3, ‘age’=40, ‘active’=true");
        starter.execute("Вставте значение ‘lastName’ = ‘Федоров’ , ‘id’=5, ‘age’=40, ‘active’=false");
    }
}