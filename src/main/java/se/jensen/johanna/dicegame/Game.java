package se.jensen.johanna.dicegame;


public class Game {
   private final Player  p1=new Player();
   private final Player p2=new Player();
   private final Dice dice=new Dice();
   private boolean play;
   private int rounds;
   private UI ui=new UI();



   private boolean setPlayers(){
       ui.showMessageDialog("Player 1");
      if(!ui.setPlayerName(p1)){
          return false;
      }
      ui.showMessageDialog("Player 2");
      if( !ui.setPlayerName(p2)){
          return false;
      }
      play=true;
      return true;
   }


   public void startGame(){
       ui.showMessageDialog("WELCOME TO DICE GAME 2.0. \n \n Please Enter Your Names To Start The Game");
       if(setPlayers()){
       rounds=2;
       while(play) {
           ui.showMessageDialog("Let's Roll!");
           p1.addToScore(dice.rollDice());
           p2.addToScore(dice.rollDice());
           ui.showMessageDialog(
                   p1.getName() + " rolled: "+ p1.getScore() +
                           "\n" + p2.getName() +" rolled: " + p2.getScore());
           rounds--;
           if(rounds==0){
               ui.showMessageDialog(checkWinner());
               play=ui.playAgain();
               if(play && ui.newPlayers()){
                   resetGameNewPlayers();
               }
               resetGame();
           }

       }
   }ui.showMessageDialog("Thanks for Playing.");
   }

       private String checkWinner(){
       if(p1.getTotalScore()==p2.getTotalScore()){
           return "It's A Tie!";
       }else if(p1.getTotalScore()>p2.getTotalScore()){
           return "The Winner Is: "+p1.getName()+"\n You Won By: "+diffScore()+" Points.";
       }else{
           return "The Winner Is: "+p2.getName()+"\nYou Won By: "+diffScore()+" Points.";
       }
       }


       private int diffScore(){
       int winner=Math.max(p1.getTotalScore(), p2.getTotalScore());
       int loser=Math.min(p1.getTotalScore(), p2.getTotalScore());
       return winner-loser;

       }


       private void resetGame(){
           rounds=2;
           p1.resetScore();
           p2.resetScore();

       }
       private void resetGameNewPlayers(){
       resetGame();
       setPlayers();

       }



       }












