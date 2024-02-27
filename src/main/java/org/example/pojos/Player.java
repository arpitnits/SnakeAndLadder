package org.example.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@Builder
public class Player {

    private Integer playerId;
    private String playerName;
    private int playerPosition;

    private boolean initial;
    List<Integer> playerHistory;
}
