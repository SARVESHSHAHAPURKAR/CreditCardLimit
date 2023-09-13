package org.example;

import java.util.List;

public class User {

    int id;
    List<Card> cards;

    int superLimit;
    int spentAmount;

    public User(int id, List<Card> cards, int superLimit, int spentAmount) {
        this.id = id;
        this.cards = cards;
        this.superLimit = superLimit;
        this.spentAmount = spentAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getSuperLimit() {
        return superLimit;
    }

    public void setSuperLimit(int superLimit) {
        this.superLimit = superLimit;
    }

    public int getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(int spentAmount) {
        this.spentAmount = spentAmount;
    }

    synchronized void spend(int amount, Card card) throws Exception {

        if(!cards.contains(card)){
            throw new CardNotVailidException("User "+id+ "  does not own this card "+card.getId());
        }

        if(this.getSpentAmount()+amount> this.superLimit){
            throw new UserLimitExceeded("Limit exceeded for User "+id);
        }

        card.spend(amount);
        this.setSpentAmount(this.getSpentAmount()+amount);

    }
}
