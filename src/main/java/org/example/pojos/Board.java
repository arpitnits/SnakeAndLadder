package org.example.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Board {

    private String boardId;
    private int size;

    private List<Cell> cells;
}
