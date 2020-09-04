package pl.kashp;

import pl.kashp.bootstrap.LoadData;
import pl.kashp.domain.Box;
import pl.kashp.domain.Player;
import pl.kashp.logic.GameLogic;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoadData loadData = new LoadData();
        List<Box> list = loadData.drawPrizes();

        Player player = new Player();

        GameLogic logic = new GameLogic(scanner, list, player);
        logic.menu();
    }
}
