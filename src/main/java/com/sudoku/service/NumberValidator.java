package com.sudoku.service;

import com.sudoku.board.SudokuBoard;
import com.sudoku.board.SudokuRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberValidator {
    private List<Integer> boxValues = new ArrayList<>();

    public boolean checkValuesInSudokuRow(SudokuRow sudokuRow, Integer newValue) {
        if (Arrays.asList(sudokuRow.getSudokuElementsRow()).contains(newValue)) {
            return true;
        }
        return false;
    }

    public boolean checkValuesInSudokuColumn(SudokuBoard sudokuBoard, int newValue) {

        for (int i = 0; i < 3; i++) {
     //       SudokuRow sudokuRow = sudokuBoard.getSudokuBoard().get(i);
            for (int j = 0; j < 3; j++) {
      //          boxValues.add(sudokuRow.getSudokuElementsRow().get(j).getElementValue().get(j));
            }
        }
        return false;
    }
}
