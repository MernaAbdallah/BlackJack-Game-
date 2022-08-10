/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Random;
import java.util.Scanner;



public class Game {
    
  public  Player players[]=new Player[4];
  public Card carddec[]=new Card[52];
  public int highscore[] = new int [4];
  
  
  
  
  

    public void generate(){
         int counter =0;
        for(int i=0 ; i<4 ; i++){
            for(int j=0 ; j<13 ; j++){
                int value;
                if(j>=10){
                   value = 10;
                }
                else{
                   value = j+1;
                }
                Card c = new Card(i ,j ,value);
                carddec[counter] = c;
                counter++;
            }
        }
    }    
    
    public Card draw(){
        Random rand = new Random();
        Card card = null;
        while(card==null)
        {
             int randnum=rand.nextInt(51);
            card = carddec[randnum]; 
            carddec[randnum]=null;
            
        }
        return card;

    }
    
    public void setinformation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter players names:");
             players[0]=new Player();
             players[0].name=scanner.next();
             players[1]=new Player();
             players[1].name=scanner.next();
             players[2]=new Player();
             players[2].name=scanner.next();
        for(int i=0;i<players.length-1;i++){
            /* players[i]=new Player();*/
             players[i].addcard(this.draw());
             players[i].addcard(this.draw());  
        }
             players[3]=new Player();
             players[3].name="Dealer";
             players[3].addcard(this.draw());
             players[3].addcard(this.draw());
        
    }
    
    public void updategamescore(){
        for(int i=0 ; i<highscore.length;i++){
            if(players[i].score<=21){
             highscore[i] = players[i].score;
        }
            else{
                 highscore[i] = players[i].score=0;
            }
        }
    }
    
} 