package com.sudoku.service;

import com.sudoku.board.CreateBoard;
import com.sudoku.board.SudokuBoard;
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
        System.out.println("1 " + testBoard.getSudokuRows());
        System.out.println("2 " + testBoard);
        printMessages.printBoard(testBoard);


    }

    @Test
    public void testBoardDeepCopy() {
        //Given
        CreateBoard createBoard = new CreateBoard();
        SudokuBoard sudokuBoard = createBoard.createEmptyBoard();
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[3].setValue(6);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[4].setValue(7);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[5].setValue(8);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[6].setValue(9);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[7].setValue(1);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[8].setValue(2);
        sudokuBoard.getSudokuRows()[1].getSudokuElementsRow()[8].setValue(3);
        sudokuBoard.getSudokuRows()[2].getSudokuElementsRow()[0].setValue(5);

        //When
        SudokuBoard newBoard = sudokuBoard.deepCopy(sudokuBoard);
        newBoard.getSudokuRows()[0].getSudokuElementsRow()[0].setValue(3);



        //Then
        System.out.println(sudokuBoard);
        System.out.println(newBoard);
    }


}
