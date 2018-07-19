package com.sudoku.service;

import com.sudoku.board.CreateBoard;
import com.sudoku.board.SudokuBoard;
import com.sudoku.board.SudokuElement;
import org.junit.Assert;
import org.junit.Test;

public class SudokuServiceTestSuite {

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
    public void testNumberValidatorCheckValuesInSudokuRow() {
        //Given
        CreateBoard createBoard = new CreateBoard();
        SudokuBoard sudokuBoard = createBoard.createEmptyBoard();
        NumberValidator numberValidator = new NumberValidator();

        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[0].setValue(6);
        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[2].setValue(5);
        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[3].setValue(4);
        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[4].setValue(8);

        //When
        boolean results = (numberValidator.checkValuesInSudokuRow(sudokuBoard, 0, 5));
        boolean results2 = (numberValidator.checkValuesInSudokuRow(sudokuBoard, 0, 7));
        boolean results3 = (numberValidator.checkValuesInSudokuRow(sudokuBoard, 0, 4));

        //Then
        Assert.assertEquals(true, results);
        Assert.assertEquals(false, results2);
        Assert.assertEquals(true, results3);
        System.out.println(sudokuBoard);
    }

    @Test
    public void testNumberValidatorCheckValues() {
        //Given
        CreateBoard createBoard = new CreateBoard();
        SudokuBoard sudokuBoard = createBoard.createEmptyBoard();
        SudokuElement sudokuElement = new SudokuElement();
        SudokuElement sudokuElement2 = new SudokuElement();
        NumberValidator numberValidator = new NumberValidator();

        sudokuElement.setValue(2);
        sudokuElement2.setValue(1);

        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[0].setValue(6);
        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[2].setValue(5);

        //When
        boolean results = (numberValidator.checkValuesInSudokuColumn(sudokuBoard, 0, 6));
        boolean results2 = (numberValidator.checkValuesInSudokuColumn(sudokuBoard, 0, 7));

        //Then
        Assert.assertEquals(true, results);
        Assert.assertEquals(false, results2);

    }

    @Test
    public void testCheckValuesInSudokuBox() {
        //Given
        CreateBoard createBoard = new CreateBoard();
        SudokuBoard sudokuBoard = createBoard.createEmptyBoard();
        NumberValidator numberValidator = new NumberValidator();


        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[0].setValue(6);
        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[2].setValue(5);
        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[1].setValue(3);
        sudokuBoard.getSudokuBoard()[1].getSudokuElementsRow()[0].setValue(2);

        //When
        boolean results = numberValidator.checkValuesInSudokuBox(sudokuBoard, 0, 0, 5);
        boolean results2 = numberValidator.checkValuesInSudokuBox(sudokuBoard, 1, 1, 5);
        boolean results3 = numberValidator.checkValuesInSudokuBox(sudokuBoard, 2, 2, 5);

        //Then
        Assert.assertEquals(true, results);
        Assert.assertEquals(true, results2);
        Assert.assertEquals(true, results3);
    }

    @Test
    public void testCheckAllSudokuConditions() {
        //Given
        CreateBoard createBoard = new CreateBoard();
        SudokuBoard sudokuBoard = createBoard.createEmptyBoard();
        NumberValidator numberValidator = new NumberValidator();
        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[0].setValue(6);

        //When
        boolean results = numberValidator.checkAllSudokuConditions(sudokuBoard, 0, 2, 5);
        sudokuBoard.getSudokuBoard()[2].getSudokuElementsRow()[0].setValue(5);
        boolean results2 = numberValidator.checkAllSudokuConditions(sudokuBoard, 1, 2, 6);
        boolean results3 = numberValidator.checkAllSudokuConditions(sudokuBoard, 3, 2, 5);

        //Then
        System.out.println(sudokuBoard);
        Assert.assertEquals(false, results);
        Assert.assertEquals(true, results2);
        Assert.assertEquals(true, results3);


    }

    @Test
    public void testFindAllSudokuNUmbers() {
        //Given
        CreateBoard createBoard = new CreateBoard();
        SudokuBoard sudokuBoard = createBoard.createEmptyBoard();
        UserInteraction userInteraction = new UserInteraction();
        sudokuBoard.getSudokuBoard()[0].getSudokuElementsRow()[0].setValue(6);

        //When
        userInteraction.findAllSudokuNumbers(sudokuBoard);

        //Then
        System.out.println(sudokuBoard);

    }
}
