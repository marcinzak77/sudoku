package com.sudoku.service;

import com.sudoku.board.CreateBoard;
import com.sudoku.board.SudokuBoard;

public class SudokuGame {

    public boolean resolveSudoku() {
        PrintMessages printMessages = new PrintMessages();
        CreateBoard createBoard = new CreateBoard();
        NumberValidator numberValidator = new NumberValidator();
        SudokuBoard sudokuBoard = createBoard.createEmptyBoard();

        while (numberValidator.checkIsSudokuResolved(sudokuBoard)) {
            printMessages.printBoard(sudokuBoard);
            UserInteraction userInteraction = new UserInteraction();
            userInteraction.enterNewSudokuNumber(sudokuBoard);
        }

        return true;
    }
}
