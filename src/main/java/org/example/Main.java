package org.example;

import org.example.Services.GameService;
import org.example.pojos.Ladder;
import org.example.pojos.Snake;

/**
 * Snake & Ladder
 * Requirements
 *
 * 1. 100 cell board
 * 2. n Players
 * 3. Starts only when 6 comes on dice
 * 4. No two cells should have more than one end point of Snakes & Ladders
 * 5. wins only when player comes to 100th cell
 * 6. when climbing ladder player gets extra chance
 *
 * Extra Requirements - Extendible
 * - Board can be m X m size
 * - Dice can have k faces or there can be multiple dices
 * - Game history can be retrieved (not required, but good to have)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        GameService gameService = new GameService(5, 3);

        gameService.addHurdle(6, new Snake(6, 3));
        gameService.addHurdle(10, new Ladder(10, 21));
        gameService.addHurdle(18, new Ladder(18, 23));
//        gameService.addHurdle(40, new Ladder(40, 60));
        gameService.addHurdle(24, new Snake(24, 2));

        gameService.addPlayer("Arpit");
        gameService.addPlayer("Pankaj");
        gameService.addPlayer("X");

        gameService.startGame();
    }
}