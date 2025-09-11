package se.jensen.johanna.dicegame;

public class Player{
    private String firstName;
    private String lastName;
    private int score;
    private int totalScore;

    public void setFirstName(String firstName) throws IllegalArgumentException{
        if(!isValidName(firstName)){
            throw new IllegalArgumentException("Invalid input. Please fill in all required names");
        }else{
            this.firstName=firstName;
        }

    }
    public void setLastName(String lastName) throws IllegalArgumentException{
        if(!isValidName(lastName)){
            throw new IllegalArgumentException("Please enter a Name");
        }else{
            this.lastName=lastName;
        }

    }

    private boolean isValidName(String name){
        return name!=null && !name.trim().isEmpty(); //viktigt me null först

    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName; //används ej. Har med för det stod i projektet, hade hellre kört bara name.
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
