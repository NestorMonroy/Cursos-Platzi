package org.nestor.javatests.player;

public class Player {
    private Dice dice;

    public Player(Dice dice, int minNumberToWin) {
        this.dice = dice;
        this.minNumberToWin = minNumberToWin;
    }

    private int minNumberToWin;

    public boolean play(){
        int diceNumber = dice.roll();
        return diceNumber > minNumberToWin;
    }
}
