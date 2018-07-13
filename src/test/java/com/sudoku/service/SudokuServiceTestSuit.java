package com.sudoku.service;

import com.sudoku.board.CreateBoard;
import com.sudoku.board.SudokuBoard;
import org.junit.Test;

public class SudokuServiceTestSuit {

    @Test
    public void testPrintMessagesBoard() {
        //Given
        CreateBoard createBoard = new CreateBoard();
        PrintMessages printMessages = new PrintMessages();
        SudokuBoard testBoard = new SudokuBoard();

        //When
        testBoard = createBoard.createEmptyBoard();

        //Then
        System.out.println("1 " + testBoard.getSudokuBoard());
        System.out.println("2 " + testBoard);
        printMessages.printBoard(testBoard);


    }
}
