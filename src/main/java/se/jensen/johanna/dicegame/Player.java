package se.jensen.johanna.dicegame;

public class Player{
    private String firstName;
    private String lastName;
    private int score;
    private int totalScore;


    public void setFirstName(String firstName) {

        this.firstName=firstName;

    }
    public void setLastName(String lastName){
        this.lastName=lastName;

    }


    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getFullName(){
        return firstName+" "+lastName;
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
    public void resetTotalScore(){
        this.totalScore=0;
    }
}
