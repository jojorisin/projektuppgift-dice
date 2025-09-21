package se.jensen.johanna.dicegame;

public class Player{
    private String name;
    private int score;
    private int totalScore;


    public void setName(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("Name Cant Be Empty");
        }

        this.name=name;

    }


    public String getName(){
        return name;
    }


    public void addToScore(int score){
        this.score=score;
        this.totalScore+=score;
    }
    public int getScore(){
        return score;
    }
    public int getTotalScore(){
        return totalScore;
    }
    public void resetScore(){
        this.totalScore=0; this.score=0;
    }
}
