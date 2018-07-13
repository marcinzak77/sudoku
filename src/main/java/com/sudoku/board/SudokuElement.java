package com.sudoku.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuElement {
    public static int EMPTY = -1;
    private Integer value;
    private List<Integer> possibleValues = new ArrayList<>();

//    public SudokuElement(int newValue) {
////        if (possibleValues.contains(newValue)) {
////            value = newValue;
////            possibleValues.remove(newValue);
////        }
//        // temporary 1
//        value = 1;
//    }

    public void setValue(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }
}
