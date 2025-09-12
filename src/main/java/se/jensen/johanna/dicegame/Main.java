package se.jensen.johanna.dicegame;


public class Main {
    public static void main(String[] args) {
        Game game=new Game();
        UI ui=new UI();
        game.setPlayers();
        game.startGame();
        ui.showMessageDialog("Thanks For Playing");




    }


}
