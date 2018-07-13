package com.sudoku.board;

import static com.sudoku.board.SudokuElement.EMPTY;

public class CreateBoard {

    public SudokuBoard createEmptyBoard() {
        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuRow sudokuRow = new SudokuRow();
        SudokuElement sudokuElement = new SudokuElement();

        sudokuElement.setValue(EMPTY);

        for (int i = 1; i <= 9; i++) {
            sudokuRow.getSudokuElementsRow().add(sudokuElement);
        }

        for (int j = 1; j <= 9; j++) {
            sudokuBoard.getSudokuBoard().add(sudokuRow);
        }

        return sudokuBoard;
    }
}
