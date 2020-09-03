package pl.kashp.domain;

public enum Reward {
    VALUE100("100€"),
    VALUE20("20€"),
    VALUE5("5€"),
    EXTRA_LIFE("Extra Life"),
    GAME_OVER( "Game Over"),
    SECOND_CHANCE("Second Chance");

    private final String label;

    public String getLabel(){
        return label;
    }

    Reward(String label){
        this.label = label;
    }
}
