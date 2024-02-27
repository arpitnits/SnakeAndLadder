package org.example.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Snake extends Hurdle {


    public Snake(int i, int i1) {
        super(i, i1);
    }
}
