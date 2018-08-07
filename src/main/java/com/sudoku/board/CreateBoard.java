package com.sudoku.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sudoku.board.SudokuElement.EMPTY;

public class CreateBoard {

    public SudokuBoard createEmptyBoard() {
        SudokuBoard sudokuBoard = new SudokuBoard(new SudokuRow[9]);
        ;

     for (int j = 0; j < 9; j++) {
        SudokuRow sudokuRow = new SudokuRow();

            for (int i = 0; i < 9; i++) {
                SudokuElement sudokuElement = new SudokuElement();
                sudokuElement.setValue(EMPTY);
                List<Integer> possibleValuesList = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9));
                sudokuElement.setPossibleValue(possibleValuesList);
                sudokuRow.getSudokuElementsRow()[i] = sudokuElement;
            }

            sudokuBoard.getSudokuRows()[j] = sudokuRow;
        }

        return sudokuBoard;
    }
}
