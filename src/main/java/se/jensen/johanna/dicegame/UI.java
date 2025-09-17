package se.jensen.johanna.dicegame;

import javax.swing.*;
import java.awt.*;

public class UI {
    private final ImageIcon icon;
    private String input;

    public UI(){
        this.icon=loadImageIcon();

    }

    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE, icon);

    }

    public int showConfirmDialog(String question){
       return JOptionPane.showConfirmDialog(null, question, null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon);

    }

    public String askForString(String question) throws IllegalArgumentException{
        do {
           isCancel( input = (String) JOptionPane.showInputDialog(null, question, null, JOptionPane.QUESTION_MESSAGE, icon, null, " "));


            if (!isValidInput(input)) {
                throw new IllegalArgumentException("Input Can't Be Empty");
            }
        }while(!isValidInput(input));
return input;

    }


    private boolean isValidInput(String input){

        return input!=null && !input.trim().isEmpty();

    }

    public boolean playAgain() {
        return showConfirmDialog("Do You Want To Play Again?")==JOptionPane.YES_OPTION;
    }

        public boolean newPlayers(){
            return showConfirmDialog("Do You Want To Change Players?")==JOptionPane.YES_OPTION;
        }



    private ImageIcon loadImageIcon() {
        ImageIcon temp = new ImageIcon(getClass().getResource("/images/diceIcon.png"));
        Image scaled = temp.getImage().getScaledInstance(90, 64, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);

    }

    private boolean isCancel(String input){
        if(input==null){
            if(showConfirmDialog("Are You Sure You Want To Cancel?")==JOptionPane.YES_OPTION){
                System.exit(0);
        }else{
                return false;

            }
        }return true;

    }


}
