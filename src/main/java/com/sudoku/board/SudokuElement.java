package com.sudoku.board;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static Integer EMPTY = -1;
    private List<Integer> elementValue = new ArrayList<>();
    private Integer value;

    public List<Integer> getElementValue() {
         return elementValue;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value >= 1 && value <= 9) {
            this.value = value;
        }
    }

    public void setElementValue(List<Integer> elementValue) {
        this.elementValue = elementValue;
    }

    @Override
    public String toString() {
        if (value.equals(EMPTY)) {
            return " ";
        }
        return "" + value;
    }
}
