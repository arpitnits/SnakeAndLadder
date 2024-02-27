package org.example.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class Game {

    private String gameId;

    private Board board;
    Map<Integer, Player> players;
}
