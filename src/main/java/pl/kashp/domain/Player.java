package pl.kashp.domain;

public class Player {
    private int cash;
    private boolean normalLife;
    private boolean extraLife;
    private boolean secondChance;

    public Player() {
        this.normalLife = true;
        this.extraLife = false;
        this.secondChance = true;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public boolean hasNormalLife() {
        return normalLife;
    }

    public void setNormalLife(boolean normalLife) {
        this.normalLife = normalLife;
    }

    public boolean hasExtraLife() {
        return extraLife;
    }

    public void setExtraLife(boolean extraLife) {
        this.extraLife = extraLife;
    }

    public boolean hasSecondChance() {
        return secondChance;
    }

    public void setSecondChance(boolean secondChance) {
        this.secondChance = secondChance;
    }
}
