package pl.kashp.logic;

import pl.kashp.domain.Box;
import pl.kashp.domain.Player;
import pl.kashp.domain.Reward;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    private final Scanner scanner;
    private final List<Box> prizes;
    private final Player player;

    private static final int MAX_BOXES = 12;
    private static final int value5 = 5;
    private static final int value20 = 20;
    private static final int value100 = 100;


    public GameLogic(Scanner scanner, List<Box> prizes, Player player) {
        this.scanner = scanner;
        this.prizes = prizes;
        this.player = player;
    }

    public void menu() {
        while (true) {
            printPrizes();
            int input = -1;
            try {
                input = Integer.parseInt(scanner.nextLine()) - 1;
            } catch (NumberFormatException ex) {
                System.err.println("Giver value is not an integer. Try again");
            }
            if (input >= 0 && input < MAX_BOXES) {
                openABox(input);
            } else {
                System.err.println("Given value is not an integer between 1-12. Try again");
                ;
            }
            if (!player.hasNormalLife()) {
                checkIfLost();
                if (!player.hasNormalLife()) {
                    gameOver();
                }
            }
        }
    }

    private void printPrizes() {
        for (int i = 0; i < MAX_BOXES; i++) {
            if (!prizes.get(i).isTaken()) {
                System.out.println(i + 1 + ". Box with reward");
            } else {
                System.out.println(i + 1 + ". Empty box");
            }
        }
        System.out.println("Choose a box from 1-12");
    }


    private void openABox(int input) {
        if (prizes.get(input).isTaken()) {
            System.out.println("Box already opened. Try again");
        } else {
            Reward chosenReward = prizes.get(input).getReward();
            System.out.println("You open the box and see " + chosenReward.getLabel());
            prizes.get(input).takeReward();
            checkPrize(chosenReward);
        }
    }

    private void checkPrize(Reward reward) {
        switch (reward) {
            case VALUE5 -> player.setCash(player.getCash() + value5);
            case VALUE20 -> player.setCash(player.getCash() + value20);
            case VALUE100 -> player.setCash(player.getCash() + value100);
            case EXTRA_LIFE -> player.setExtraLife(true);
            case GAME_OVER -> player.setNormalLife(false);
        }
    }

    private void checkIfLost() {
        checkIfHasExtraLife();
        if (!player.hasNormalLife()) {
            List<Reward> listOfSecondChance = createListOfSecondChance();
            Random random = new Random();
            int i = 0;
            if (player.hasChanceToPlayOn()) {
                i = random.nextInt(4);
                player.setchanceToPlayOn(false);
            } else {
                i = random.nextInt(3);
            }
            System.out.println("Your additional reward is available:");
            Reward rewardOfExtraChance = listOfSecondChance.get(i);
            System.out.println("Your additional reward is " + rewardOfExtraChance.getLabel());
            if (rewardOfExtraChance == Reward.SECOND_CHANCE) {
                player.setNormalLife(true);
                System.out.println("You have an extra life, don't fuck it up!");
            }
            additionalReward(rewardOfExtraChance);
        }
    }


    private void checkIfHasExtraLife() {
        if (player.hasExtraLife()) {
            player.setExtraLife(false);
            player.setNormalLife(true);
            System.out.println("Since you had an extra life, the game goes on!");
        }
    }

    private void additionalReward(Reward reward) {
        switch (reward) {
            case VALUE5 -> player.setCash(player.getCash() + value5);
            case VALUE20 -> player.setCash(player.getCash() + value20);
            case VALUE100 -> player.setCash(player.getCash() + value100);
            case EXTRA_LIFE -> player.setNormalLife(true);
        }
    }


    private List<Reward> createListOfSecondChance() {
        List<Reward> listOfSecondChance = new ArrayList<>();
        if (player.hasChanceToPlayOn()) {
            listOfSecondChance.add(Reward.SECOND_CHANCE);
        }
        listOfSecondChance.add(Reward.VALUE5);
        listOfSecondChance.add(Reward.VALUE20);
        listOfSecondChance.add(Reward.VALUE100);
        return listOfSecondChance;
    }

    private void gameOver() {
        System.out.println("\nThe game is over! Your final score is: " + finalScore() + " Euro");
        System.out.println("Congratulations!");
        System.exit(0);
    }


    private int finalScore() {
        return player.getCash();
    }
}


