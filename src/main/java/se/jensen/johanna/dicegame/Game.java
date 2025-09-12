package se.jensen.johanna.dicegame;
import javax.swing.*;


public class Game {
   private final Player  p1=new Player();
   private final Player p2=new Player();
   private final Dice dice=new Dice();
   private boolean playersSet=false;
   private boolean play=false;
   private int rounds;
  // private final ImageIcon icon;
   private UI ui=new UI();

   public Game(){
      // icon=loadImageIcon();
   }

   public void setPlayers(){
       while(!playersSet){
       try {
           p1.setFirstName(ui.askForString("Player 1, Enter Your First Name"));
           p1.setLastName(ui.askForString("Player 1, Enter Your Last Name"));
           p2.setFirstName(ui.askForString("Player 2, Enter Your First Name"));
           p2.setLastName(ui.askForString("Player 2, Enter Your Last Name"));
           playersSet=true;
           play=true;
       }catch(IllegalArgumentException e){
           ui.showMessageDialog(e.getMessage());

       }
       }
   }


   public void startGame(){
      if(!playersSet){
          ui.showMessageDialog("You Have To Set Players Before You Can Start The Game");
           setPlayers();
       }
       rounds=2;
       while(play) {
           ui.showMessageDialog("Let's Roll!");
           p1.addToScore(dice.rollDice());
           p2.addToScore(dice.rollDice());
           ui.showMessageDialog(p1.getFirstName() + " rolled: " + p1.getScore()  +"\n" + p2.getFirstName() +" rolled:" + p2.getScore());
           rounds--;
           if(rounds==0){
               ui.showMessageDialog(checkWinner());
               play=playAgain();
               resetGame();
           }

       }
   }

       public String checkWinner(){
       if(p1.getTotalScore()==p2.getTotalScore()){
           return "It's A Tie!";
       }else if(p1.getTotalScore()>p2.getTotalScore()){
           return "The Winner Is: "+p1.getFullName()+"\n You Won By: "+diffScore()+" Points.";
       }else{
           return "The Winner Is: "+p2.getFullName()+"\nYou Won By: "+diffScore()+" Points.";
       }
       }


       private int diffScore(){
       int winner=Math.max(p1.getTotalScore(), p2.getTotalScore());
       int loser=Math.min(p1.getTotalScore(), p2.getTotalScore());
       return winner-loser;

       }

       private boolean playAgain() {
           int choice = ui.showConfirmDialog("Do You Want To Play Again?");
           if (choice == JOptionPane.YES_OPTION) {
               int newPlayers = ui.showConfirmDialog("Do You Want To Change Players?");
               if (newPlayers == JOptionPane.YES_OPTION) {
                   resetGameNewPlayers();
                   return true;
               } else if (newPlayers == JOptionPane.NO_OPTION) {
                   resetGame();
                   return true;
               } else {
                   return false;
               }
           }return false;
       }

       private void resetGame(){
           rounds=2;
           p1.resetTotalScore();
           p2.resetTotalScore();

       }
       private void resetGameNewPlayers(){
       resetGame();
       playersSet=false;
       setPlayers();

       }



       }












