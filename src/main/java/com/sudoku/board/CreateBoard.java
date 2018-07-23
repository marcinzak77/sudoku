package com.sudoku.board;

import static com.sudoku.board.SudokuElement.EMPTY;

public class CreateBoard {

    public SudokuBoard createEmptyBoard() {
        SudokuBoard sudokuBoard = new SudokuBoard(new SudokuRow[9]);

      //  SudokuElement sudokuElement = new SudokuElement();

      //  sudokuElement.setValue(EMPTY);

        for (int j = 0; j < 9; j++) {
        SudokuRow sudokuRow = new SudokuRow();

            for (int i = 0; i < 9; i++) {
                SudokuElement sudokuElement = new SudokuElement();
                sudokuElement.setValue(EMPTY);
                sudokuRow.getSudokuElementsRow()[i] = sudokuElement;
            }

            sudokuBoard.getSudokuRows()[j] = sudokuRow;
        }

        return sudokuBoard;
    }
}
