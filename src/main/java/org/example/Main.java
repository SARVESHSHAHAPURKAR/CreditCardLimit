package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //User user1 = new User();

        Card c1 = new Card(1,0,8000);
        Card c2 = new Card(2,0,8000);
        Card c3 = new Card(3,0,8000);
        Card c4 = new Card(4,0,8000);
        Card c5 = new Card(5,0,8000);

        List<Card> cardsForUser1 = new ArrayList<>();
        cardsForUser1.add(c1);cardsForUser1.add(c2);cardsForUser1.add(c3);

        List<Card> cardsForUser2 = new ArrayList<>();
        cardsForUser2.add(c4);cardsForUser2.add(c5);

        User u1 = new User(11,cardsForUser1,10000,0);
        User u2 = new User(12,cardsForUser2,10000,0);

        Thread t1 = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    u1.spend(5000,c1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    u1.spend(4000,c2);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}