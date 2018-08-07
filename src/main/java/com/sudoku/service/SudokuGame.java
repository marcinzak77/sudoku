package com.sudoku.service;

import com.sudoku.board.CreateBoard;
import com.sudoku.board.SudokuBoard;

public class SudokuGame {

    public boolean resolveSudoku() {
        PrintMessages printMessages = new PrintMessages();
        CreateBoard createBoard = new CreateBoard();
        SudokuBoard sudokuBoard = createBoard.createEmptyBoard();
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
                   case "x":    done = false;
                                break;

                   case "n":    sudokuBoard = createBoard.createEmptyBoard();
                                printMessages.printBoard(sudokuBoard);
                                done = true;
                                break;

                   default:     break;
               }

           }
       }

       return true;
    }
}
