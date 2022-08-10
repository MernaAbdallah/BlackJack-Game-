/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

public class BlackJack {
    static Game game = new Game();
    public static void main(String[] args) {
        GUI gui = new GUI();
        game.generate();
        game.setinformation();
        
        gui.runGUI( game.carddec, game.players[0].getH(),game.players[1].getH() , game.players[2].getH(), game.players[3].getH() );
        playersturn(gui);
        game.updategamescore();
        delarturn(gui);
        game.updategamescore();
        check();
        
    }
        
    public static void playersturn(GUI gui){
            Scanner scanner = new Scanner(System.in);
            String in="";
            for(int i=0 ; i<3; i++){
                in="";
               while(!in.toLowerCase().equals("stand")) {
                    System.out.println("player" +(i+1) +" "+ game.players[i].name + " $score$ >>> " +game.players[i].score +" "+"choose ( hit/stand ) ");  
                    in = scanner.next();
                    if(in.toLowerCase().equals("hit")){
                        addcardtoplayer(i , gui);
                        if(game.players[i].score>=21 ){
                            break;
                        }
                    
                    }
                }
            }                    
        }
    public static void addcardtoplayer(int index , GUI gui){
                       Card card = game.draw();
                        game.players[index].addcard(card);
                        gui.updatePlayerHand(card, index);
        
    }
    
  public static void delarturn(GUI gui){
        boolean wins=true;
        int highscore=0;
        for(int i=0 ; i<game.players.length-1 ; i++){
            if(game.highscore[i] >= game.players[3].score){
                wins=false;
            }
            if(game.highscore[i] > highscore){
                highscore = game.highscore[i];
            }
        }
        if(!wins){
            addcardtodealr(gui , highscore);
        }
        else{
            return;
        }                
    }
    
    
    public static void addcardtodealr(GUI gui , int highscore){
        while(game.players[3].score<highscore){
                 Card card = game.draw();
                 game.players[3].addcard(card);
                 gui.updateDealerHand(card, game.carddec);
        
        }     
    }
    
    public static void check(){
       
            int max=0;
            int index=-1;
            for(int i=0;i<4;i++)
            {
                if(game.highscore[i]>max&&game.highscore[i]<=21)
                {
                     max=game.highscore[i];
                     index=i;
                }
            }
                            int x=0;

            for(int i=0;i<4;i++)
            {
                if(game.players[i].getScore()==max)
                    x++;
               
            }
             if(x==1)
                {
                    System.out.println("the winner is "+game.players[index].name);
                }
                else
                    System.out.println("PUSH");
        }
        

              
}


