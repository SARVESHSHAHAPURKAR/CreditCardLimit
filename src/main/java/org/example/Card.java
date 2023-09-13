package org.example;

public class Card {

    int id;

    int totalSpentAmount;
    int spendLimit;

    public Card(int id, int totalSpentAmount, int spendLimit) {
        this.id = id;
        this.totalSpentAmount = totalSpentAmount;
        this.spendLimit = spendLimit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalSpentAmount() {
        return totalSpentAmount;
    }

    public void setTotalSpentAmount(int totalSpentAmount) {
        this.totalSpentAmount = totalSpentAmount;
    }

    public int getSpendLimit() {
        return spendLimit;
    }

    public void setSpendLimit(int spendLimit) {
        this.spendLimit = spendLimit;
    }

    public void spend(int amount) throws CardLimitExceededException {

        if(this.getTotalSpentAmount()+amount>this.getSpendLimit()){
            throw new CardLimitExceededException("Limit exceeded for Card "+id);
        }

        this.setTotalSpentAmount(this.getTotalSpentAmount()+amount);
    }
}
