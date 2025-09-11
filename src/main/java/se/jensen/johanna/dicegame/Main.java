package se.jensen.johanna.dicegame;


public class Main {
    public static void main(String[] args) {
        Game game=new Game();
        game.setPlayers(); //kanske sätta in nån error så man inte kan starta game utan att man setplayers först
        game.startGame();
    }
}
