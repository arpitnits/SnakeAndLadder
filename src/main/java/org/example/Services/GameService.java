package org.example.Services;

import com.google.inject.Singleton;
import org.example.Utils.CommonUtils;
import org.example.pojos.*;

import java.util.*;

@Singleton
public class GameService {

    static int playerCount;

    static int currPlayer=1;
    static int endValue;
    public static Map<Integer, Player> playerMap = new HashMap<>();
    Game game;
    public GameService(int m, int n) {
        initializeGame(m,n);
        endValue = m*m;
    }

    private void initializeGame(int boardSize, int playerCount) {
        GameService.playerCount = playerCount;
        List<Cell> boardCells = new ArrayList<>();

        int cellId = 1;
        for(int i=0;i<boardSize;i++) {
            for(int j=0;j<boardSize;j++) {
                boardCells.add(new Cell(cellId++, null));
            }
        }

        Board board = new Board(CommonUtils.getId(), boardSize, boardCells);
        game = new Game(CommonUtils.getId(), board, playerMap);
    }

    public void addPlayer(String name) {
        Integer playerId = currPlayer++;
        playerMap.put(playerId, Player.builder()
                .playerId(playerId)
                .playerName(name)
                .playerPosition(1)
                .initial(true)
                .playerHistory(new ArrayList<>())
                .build());

        System.out.println("New Player Created Player: "+ playerMap.get(playerId));
    }


    public void addHurdle(int cellId, Hurdle hurdle) {
        game.getBoard().getCells().get(cellId).setHurdle(hurdle);
    }

    public void startGame() {

        while (true) {
            for(int i=1;i<=playerCount;i++) {
                System.out.println();
                Player player = playerMap.get(i);
                System.out.println("Player" + player.getPlayerId());


                int dice = CommonUtils.getDiceValue();
                System.out.println("Tossing dice, value:" + dice);

                if(player.isInitial()){
                    if(dice==6) player.setInitial(false);
                    else {
                        System.out.println("Not sufficient, skipping");
                        continue;
                    }
                }


                int newPosition = player.getPlayerPosition() + dice;
                if(newPosition>endValue) {
                    System.out.println("New position is more than board!");
                    continue;
                }


                System.out.println("Player id: " + player.getPlayerId() + " name: " + player.getPlayerName() + " newPosition: "+ newPosition);

                if(newPosition == endValue) {
                    System.out.println("Player won: " + player.getPlayerId());
                    return;
                }



                Cell newCell = game.getBoard().getCells().get(newPosition);

                if(newCell.getHurdle()!=null) {
                    Hurdle hurdle = newCell.getHurdle();
                    if(hurdle instanceof Snake) {
                        Snake snake = (Snake) hurdle;
                        System.out.println("Snake found, moving from: " + newPosition + "-->" +snake.getEndCellId());
                        newPosition = snake.getEndCellId();
                    } else if(hurdle instanceof Ladder) {
                        Ladder ladder = (Ladder) hurdle;
                        System.out.println("Ladder found, moving from: " + newPosition + "-->" +ladder.getEndCellId());
                        newPosition = ladder.getEndCellId();
                        i--;
                    } else {
                        System.out.println("Invalid hurdle");
                    }
                }
                List<Integer> playerHistory = player.getPlayerHistory();
                playerHistory.add(newPosition);
                player.setPlayerHistory(playerHistory);
                player.setPlayerPosition(newPosition);
            }
        }
    }
}
