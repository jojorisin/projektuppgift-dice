package se.jensen.johanna.dicegame;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Game game=new Game();
        game.setPlayers();
        game.startGame();
        JOptionPane.showMessageDialog(null,"Thanks for Playing!"," ",JOptionPane.INFORMATION_MESSAGE,game.getIcon());



    }


}
