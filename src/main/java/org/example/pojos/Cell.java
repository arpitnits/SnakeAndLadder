package org.example.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cell {

    private int cellNo;
    private Hurdle hurdle;
}
