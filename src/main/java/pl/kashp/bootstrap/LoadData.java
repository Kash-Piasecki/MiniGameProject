package pl.kashp.bootstrap;

import pl.kashp.domain.Box;
import pl.kashp.domain.Reward;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoadData {
    List<Box> list;

    public List<Box> drawPrizes(){
        create();
        shuffle();
        return list;
    }

    private void create() {
        list = new ArrayList<Box>();
        list.add(new Box(Reward.EXTRA_LIFE));
        list.add(new Box(Reward.GAME_OVER));
        list.add(new Box(Reward.GAME_OVER));
        list.add(new Box(Reward.GAME_OVER));
        list.add(new Box(Reward.VALUE100));
        list.add(new Box(Reward.VALUE20));
        list.add(new Box(Reward.VALUE20));
        list.add(new Box(Reward.VALUE5));
        list.add(new Box(Reward.VALUE5));
        list.add(new Box(Reward.VALUE5));
        list.add(new Box(Reward.VALUE5));
        list.add(new Box(Reward.VALUE5));
    }

    private void shuffle(){
        Collections.shuffle(list);
    }

}
