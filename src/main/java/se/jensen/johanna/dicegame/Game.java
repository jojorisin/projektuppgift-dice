package se.jensen.johanna.dicegame;
import javax.swing.*;
import java.awt.*;


public class Game {
   private final Player  p1=new Player();
   private final Player p2=new Player();
   private final Dice dice=new Dice();
   private boolean playersSet=false;
   private boolean play=false;
   private int rounds;
   private final ImageIcon icon;

   public Game(){
       icon=loadImageIcon();
   }


   public void setPlayers(){
       while(!playersSet){
           String p1Name= (String) JOptionPane.showInputDialog(null,"Player 1, please enter your first name: ","Enter name",JOptionPane.QUESTION_MESSAGE, icon,null," ");
           String p1LastName=(String)JOptionPane.showInputDialog(null,"Player 1, please enter your last name: ","Enter name",JOptionPane.QUESTION_MESSAGE, icon,null," ");
           String p2Name=(String)JOptionPane.showInputDialog(null,"Player 2, please enter your name: ","Enter name",JOptionPane.QUESTION_MESSAGE, icon,null," ");
           String p2LastName=(String)JOptionPane.showInputDialog(null,"Player 2, please enter your last name: ","Enter name",JOptionPane.QUESTION_MESSAGE, icon,null," ");
           try{
               //this is messy, finns nog bättre sätt att göra det på
               p1.setFirstName(p1Name);
               p1.setLastName(p1LastName);
               p2.setFirstName(p2Name);
               p2.setLastName(p2LastName);
               JOptionPane.showMessageDialog(null, "Player 1: "+p1.getFullName()+"\n "+"Player 2: "+p2.getFullName(),"Players",JOptionPane.INFORMATION_MESSAGE,icon);
              playersSet=true;
              play=true;
           }catch(IllegalArgumentException e){
               JOptionPane.showMessageDialog(null, e.getMessage());
           }
       }
   }

   public void startGame(){
       if(!playersSet){
           JOptionPane.showMessageDialog(null,"You have to set Players before you can start Game.","Invalid Players ",JOptionPane.INFORMATION_MESSAGE, icon);
           setPlayers();
       }
       rounds=2;
       while(play) {
           JOptionPane.showMessageDialog(null, "Lets roll! "," ",JOptionPane.INFORMATION_MESSAGE, icon);
           p1.addToScore(dice.rollDice());
           p2.addToScore(dice.rollDice());
           JOptionPane.showMessageDialog(null, p1.getFirstName() + " rolled: " + p1.getScore()  +
                   "\n" + p2.getFirstName() + " rolled: " + p2.getScore(),"Lets go!",JOptionPane.INFORMATION_MESSAGE,icon);
           rounds--;
           if(rounds==0){
               checkWinner();
               play=playAgain();
               resetGame();
           }

       }
   }

       private void checkWinner(){
       if(p1.getTotalScore()==p2.getTotalScore()){
           JOptionPane.showMessageDialog(null, "Its A Tie!","",JOptionPane.INFORMATION_MESSAGE,icon );
       }else if(p1.getTotalScore()>p2.getTotalScore()){
           JOptionPane.showMessageDialog(null, "The Winner Is: "+p1.getFullName()+"\nYou Won By: "+diffScore()+" Points.","Winner, winner, chicken dinner!",JOptionPane.INFORMATION_MESSAGE,icon);
       }else{
           JOptionPane.showMessageDialog(null, "The Winner Is: "+p2.getFullName()+"\nYou Won By: "+diffScore()+" Points.","Winner, winner, chicken dinner!",JOptionPane.INFORMATION_MESSAGE,icon);
       }
       }


       private int diffScore(){
       int winner=Math.max(p1.getTotalScore(), p2.getTotalScore());
       int loser=Math.min(p1.getTotalScore(), p2.getTotalScore());
       return winner-loser;

       }

       private boolean playAgain() {
           int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", " Restart", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon);
           if (choice == JOptionPane.YES_OPTION) {
               int newPlayers = JOptionPane.showConfirmDialog(null, "Do you want to change players?", " Change Players", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon);
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

       private ImageIcon loadImageIcon(){
           ImageIcon temp = new ImageIcon(getClass().getResource("/images/diceIcon.png"));
           Image scaled = temp.getImage().getScaledInstance(90, 64, Image.SCALE_SMOOTH);
           return new ImageIcon(scaled);



       }
       public ImageIcon getIcon(){
       return icon;
       }

       public void setRounds(int rounds){
       this.rounds=rounds;
       }



   }




