package com.sudoku.service;

import com.sudoku.board.BoardCreator;
import com.sudoku.board.SudokuBoard;

public class SudokuGame {

    public boolean resolveSudoku() {
        PrintMessages printMessages = new PrintMessages();
        BoardCreator boardCreator = new BoardCreator();
        SudokuBoard sudokuBoard = boardCreator.createEmptyBoard();
        UserInteraction userInteraction = new UserInteraction();

        boolean done = true;

        printMessages.printBoard(sudokuBoard);

        while (done) {
            done = !userInteraction.enterNewSudokuNumber(sudokuBoard);
            printMessages.printBoard(sudokuBoard);

            if (!done) {
                printMessages.printMenu();
                String enteredValues = KeyboardReader.getReadString().toLowerCase();

                switch (enteredValues) {
                    case "x":
                        done = false;
                        break;

                    case "n":
                        sudokuBoard = boardCreator.createEmptyBoard();
                        printMessages.printBoard(sudokuBoard);
                        done = true;
                        break;

                    default:
                        break;
                }

            }
        }

        return true;
    }
}
