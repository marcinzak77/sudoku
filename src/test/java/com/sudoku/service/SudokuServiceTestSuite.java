package com.sudoku.service;

import com.sudoku.board.CreateBoard;
import com.sudoku.board.SudokuBoard;
import com.sudoku.board.SudokuElement;
import org.junit.Assert;
import org.junit.Test;

public class SudokuServiceTestSuite {



    @Test
    public void testNumberValidatorCheckValuesInSudokuRow() {
        //Given
        CreateBoard createBoard = new CreateBoard();
        SudokuBoard sudokuBoard = createBoard.createEmptyBoard();
        NumberValidator numberValidator = new NumberValidator();

        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[0].setValue(6);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[2].setValue(5);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[3].setValue(4);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[4].setValue(8);

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

        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[0].setValue(6);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[2].setValue(5);

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


        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[3].setValue(6);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[4].setValue(7);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[5].setValue(8);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[6].setValue(9);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[7].setValue(1);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[8].setValue(2);
        sudokuBoard.getSudokuRows()[1].getSudokuElementsRow()[8].setValue(3);
        sudokuBoard.getSudokuRows()[2].getSudokuElementsRow()[0].setValue(5);

        //When
        boolean results = numberValidator.checkValuesInSudokuBox(sudokuBoard, 1, 5, 5);
        boolean results2 = numberValidator.checkValuesInSudokuBox(sudokuBoard, 2, 5, 6);
        boolean results3 = numberValidator.checkValuesInSudokuBox(sudokuBoard, 2, 6, 1);

        //Then
        System.out.println(sudokuBoard);
        Assert.assertEquals(false, results);
        Assert.assertEquals(true, results2);
        Assert.assertEquals(true, results3);

    }

    @Test
    public void testCheckAllSudokuConditions() {
        //Given
        CreateBoard createBoard = new CreateBoard();
        SudokuBoard sudokuBoard = createBoard.createEmptyBoard();
        NumberValidator numberValidator = new NumberValidator();
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[3].setValue(6);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[4].setValue(7);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[5].setValue(8);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[6].setValue(9);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[7].setValue(1);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[8].setValue(2);
        sudokuBoard.getSudokuRows()[1].getSudokuElementsRow()[8].setValue(3);
        sudokuBoard.getSudokuRows()[2].getSudokuElementsRow()[0].setValue(5);

        //When
        boolean results = numberValidator.checkAllSudokuConditions(sudokuBoard, 7, 1, 5);
        boolean results2 = numberValidator.checkAllSudokuConditions(sudokuBoard, 5, 2, 6);
        boolean results3 = numberValidator.checkAllSudokuConditions(sudokuBoard, 5, 2, 5);

        //Then
        System.out.println(sudokuBoard);
        Assert.assertEquals(false, results);
        Assert.assertEquals(true, results2);
       // Assert.assertEquals(true, results3);


    }

    @Test
    public void testFindAllSudokuNumbersInBox() {
        //Given
        CreateBoard createBoard = new CreateBoard();
        SudokuBoard sudokuBoard = createBoard.createEmptyBoard();
        AutoSudokuResolver autoSudokuResolver = new AutoSudokuResolver();
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[0].setValue(6);

        //When
        autoSudokuResolver.findAllSudokuNumbersInBox(sudokuBoard, 0, 0);

        //Then
        System.out.println(sudokuBoard);
    }

    @Test
    public void testFindAllSudokuNumbers() {
        //Given
        CreateBoard createBoard = new CreateBoard();
        SudokuBoard sudokuBoard = createBoard.createEmptyBoard();
        AutoSudokuResolver autoSudokuResolver = new AutoSudokuResolver();
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[0].setValue(6);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[7].setValue(1);
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[8].setValue(2);
        sudokuBoard.getSudokuRows()[1].getSudokuElementsRow()[8].setValue(3);
        sudokuBoard.getSudokuRows()[2].getSudokuElementsRow()[0].setValue(5);
        sudokuBoard.getSudokuRows()[6].getSudokuElementsRow()[6].setValue(4);
        sudokuBoard.getSudokuRows()[4].getSudokuElementsRow()[4].setValue(7);
        sudokuBoard.getSudokuRows()[7].getSudokuElementsRow()[6].setValue(8);

        //When
        autoSudokuResolver.findAllSudokuNumbers(sudokuBoard);

        //Then
        System.out.println(sudokuBoard);

    }
}
