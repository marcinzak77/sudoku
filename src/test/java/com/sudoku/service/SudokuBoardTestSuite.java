package com.sudoku.service;

import com.sudoku.board.CreateBoard;
import com.sudoku.board.SudokuBoard;
import com.sudoku.board.SudokuElement;
import org.junit.Test;

public class SudokuBoardTestSuite {

    @Test
    public void testPrintMessagesBoard() {
        //Given
        CreateBoard createBoard = new CreateBoard();
        PrintMessages printMessages = new PrintMessages();

        //When
        SudokuBoard testBoard = createBoard.createEmptyBoard();

        //Then
        System.out.println("1 " + testBoard.getSudokuBoard());
        System.out.println("2 " + testBoard);
        printMessages.printBoard(testBoard);


    }

    @Test
    public void testBoardDeepCopy() {
        //Given
        CreateBoard createBoard = new CreateBoard();
        SudokuBoard sudokuBoard = createBoard.createEmptyBoard();
        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[3].setValue(6);
        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[4].setValue(7);
        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[5].setValue(8);
        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[6].setValue(9);
        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[7].setValue(1);
        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[8].setValue(2);
        sudokuBoard.getSudokuBoard()[1].getSudokuElementsRow()[8].setValue(3);
        sudokuBoard.getSudokuBoard()[2].getSudokuElementsRow()[0].setValue(5);

        //When
        SudokuBoard newBoard = null;
        try {
            newBoard = sudokuBoard.deepCopy();

        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //Then
        System.out.println(sudokuBoard);
        System.out.println(newBoard);
    }
}
