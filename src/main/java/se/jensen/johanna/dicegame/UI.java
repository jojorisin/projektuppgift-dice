package se.jensen.johanna.dicegame;

import javax.swing.*;
import java.awt.*;

public class UI {
    private final ImageIcon icon;


    public UI(){
        this.icon=loadImageIcon();

    }

    public boolean setPlayerName(Player p){
        while (true) {
            String pName = (String) JOptionPane.showInputDialog(
                    null,
                    "Please Enter A Name",
                    null,
                    JOptionPane.QUESTION_MESSAGE,
                    icon,
                    null,
                    " ");
            if(pName==null){
                return false;
            }
            try{
                p.setName(pName);
                return true;
            }catch(IllegalArgumentException e){
                showMessageDialog(e.getMessage());
            }

    }}

    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                "",
                JOptionPane.INFORMATION_MESSAGE,
                icon);

    }

    public int showConfirmDialog(String question){
       return JOptionPane.showConfirmDialog(
               null,
               question,
               null,
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE,
               icon);

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



}
