package org.example;

public class CardLimitExceededException extends Exception{

    CardLimitExceededException(String s){
        super(s);
    }
}
