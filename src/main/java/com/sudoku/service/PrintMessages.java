package com.sudoku.service;

import com.sudoku.board.SudokuBoard;


public class PrintMessages {

    public void printBoard(SudokuBoard sudokuBoard) {
        System.out.println(sudokuBoard);
    }

    public void printMovementInformation() {
        System.out.println("Enter column, row and value separated by \",\" (semicolon)");
    }

    public void printMenu() {
        System.out.println("Please select option:");
        System.out.println("[N]ew game.");
        System.out.println("E[x]it Game.");
    }
}
