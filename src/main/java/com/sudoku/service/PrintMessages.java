package com.sudoku.service;

import com.sudoku.board.SudokuBoard;
import com.sudoku.board.SudokuRow;

public class PrintMessages {

    public void printBoard(SudokuBoard sudokuBoard) {

        for (SudokuRow sudokuRow: sudokuBoard.getSudokuBoard()) {
            System.out.println(sudokuRow.getSudokuElementsRow());
        }
    }
}
