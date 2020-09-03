package pl.kashp.domain;

public class Box {
    private final Reward reward;
    private boolean isTaken;

    public Box(Reward reward){
        this.reward = reward;
        this.isTaken = false;

    }
    public String printReward() {
        return reward.getLabel();
    }

    public Reward getReward() {
        return reward;
    }

    public void takeReward(){
        isTaken = true;
    }

    public boolean isTaken(){
        return isTaken;
    }

    @Override
    public String toString() {
        return reward.getLabel();
    }
}
