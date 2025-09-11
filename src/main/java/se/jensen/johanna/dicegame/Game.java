package se.jensen.johanna.dicegame;
import javax.swing.JOptionPane;

public class Game {
   private final Player  p1=new Player();
   private final Player p2=new Player();
   private final Dice dice=new Dice();
   private int round;

   public void setPlayers(){
       boolean go=true;
       while(go){
           String p1Name= JOptionPane.showInputDialog("Player 1, please enter your first name: ");
           String p1LastName=JOptionPane.showInputDialog("Player 1, please enter your last name: ");
           String p2Name=JOptionPane.showInputDialog("Player 2, please enter your name: ");
           String p2LastName=JOptionPane.showInputDialog("Player 2, please enter your last name: ");
           try{
               p1.setFirstName(p1Name);
               p1.setLastName(p1LastName);
               p2.setFirstName(p2Name);
               p2.setLastName(p2LastName);
               JOptionPane.showMessageDialog(null, "Player 1: "+p1.getFullName()+"\n "+"Player 2: "+p2.getFullName());
               go=false;
           }catch(IllegalArgumentException e){
               JOptionPane.showMessageDialog(null, e.getMessage());
           }
       }
   }

   public void startGame(){
       boolean play=true;
       this.round=2;
       while(play) {
           JOptionPane.showMessageDialog(null, "Lets roll! ");
           p1.addToScore(dice.rollDice());
           p2.addToScore(dice.rollDice());
           JOptionPane.showMessageDialog(null, p1.getFirstName() + " rolled: " + p1.getScore() + " " +
                   "\n" + p2.getFirstName() + " rolled: " + p2.getScore());
           this.round--;
           if(this.round==0){
               checkWinner();
               play=playAgain();
               resetGame();
           }

       }
   }

       private void checkWinner(){
       if(p1.getTotalScore()==p2.getTotalScore()){
           JOptionPane.showMessageDialog(null, "Its A Tie!" );
       }else if(p1.getTotalScore()>p2.getTotalScore()){
           JOptionPane.showMessageDialog(null, "The Winner Is: "+p1.getFullName()+"\nYou Won By: "+diffScore()+" Points.");
       }else{
           JOptionPane.showMessageDialog(null, "The Winner Is: "+p2.getFullName()+"\nYou Won By: "+diffScore()+" Points.");
       }
       }
       private int diffScore(){
       int winner=Math.max(p1.getTotalScore(), p2.getTotalScore());
       int loser=Math.min(p1.getTotalScore(), p2.getTotalScore());
       //int diff=winner-loser;
       return winner-loser;

       }

       private boolean playAgain(){
           int choice=JOptionPane.showConfirmDialog(null, "Do you want to play again?","play again",JOptionPane.YES_NO_OPTION );
           if(choice==JOptionPane.YES_OPTION){ //kan förenkla denna, bara return resultat av conditionet
               return true;
           }else{
               return false;
           }

       }
       private void resetGame(){
           this.round=2;
           p1.resetTotalScore();
           p2.resetTotalScore();

       }
       //reset game med ny player?


   }




