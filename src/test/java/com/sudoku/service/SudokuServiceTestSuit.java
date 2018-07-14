package com.sudoku.service;

import com.sudoku.board.CreateBoard;
import com.sudoku.board.SudokuBoard;
import com.sudoku.board.SudokuElement;
import org.junit.Test;

import java.util.Arrays;

public class SudokuServiceTestSuit {

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
       // printMessages.printBoard(testBoard);


    }

    @Test
    public void testNumberValidatorCheckValuesInSudokuRow() {
        //Given
        CreateBoard createBoard = new CreateBoard();
        SudokuBoard sudokuBoard = createBoard.createEmptyBoard();
        SudokuElement sudokuElement = new SudokuElement();
        SudokuElement sudokuElement2 = new SudokuElement();

//        for (int i = 1; i < 10; i++) {
//            sudokuElement.setValue(i);
//            Arrays.stream(sudokuBoard.getSudokuBoard()).forEach(sudokuRow -> sudokuRow.getSudokuElementsRow().);
//        }
        sudokuElement.setValue(2);
        sudokuElement2.setValue(1);

        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[0].setValue(6);

        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[2].setValue(5);


      //  sudokuBoard.getSudokuBoard().get(1).getSudokuElementsRow()[0] = sudokuElement;
      //  sudokuBoard.getSudokuBoard().get(0).getSudokuElementsRow()[1] = sudokuElement2;
//        sudokuBoard.getSudokuBoard().stream().forEach(s -> {
//                sudokuElement = new SudokuElement();
//                sudokuElement.setValue(0);
//                s.getSudokuElementsRow()[0] = sudokuElement;
//
//        });


        //When
        PrintMessages printMessages = new PrintMessages();
        System.out.println(sudokuBoard);

        //Then
    }

    @Test
    public void testNumberValidatorCheckValues() {
        //Give

        //When

        //Then

    }
}
