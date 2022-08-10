/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

public class Player {
    public String name;
    public int score =0;
     private int arrCard[]=new int[11];   
     private Card[] h = new Card[11];
     private int counter =0;
     
    public int getScore() {
        return score;
    }
 
    public void addcard(Card card){
        if(counter < 11){
            h[counter]=card;
            counter++;
            score+=card.getValue();
        }
    }

    public Card[] getH() {
        return h;
    }
    
}
