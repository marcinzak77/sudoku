package com.sudoku.service;

import com.sudoku.board.BoardCreator;
import com.sudoku.board.SudokuBoard;
import com.sudoku.board.SudokuElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SudokuServiceTestSuite {

    @Before
    public void createSudokuBoard() {
        BoardCreator boardCreator = new BoardCreator();


    }

    @Test
    public void testNumberValidatorCheckValuesInSudokuRow() {
        //Given
        BoardCreator boardCreator = new BoardCreator();
        SudokuBoard sudokuBoard = boardCreator.createEmptyBoard();
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
        BoardCreator boardCreator = new BoardCreator();
        SudokuBoard sudokuBoard = boardCreator.createEmptyBoard();
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
        BoardCreator boardCreator = new BoardCreator();
        SudokuBoard sudokuBoard = boardCreator.createEmptyBoard();
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
        BoardCreator boardCreator = new BoardCreator();
        SudokuBoard sudokuBoard = boardCreator.createEmptyBoard();
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


        //Then
        System.out.println(sudokuBoard);
        Assert.assertEquals(false, results);
        Assert.assertEquals(true, results2);


    }

    @Test
    public void testFindAllSudokuNumbersInBox() {
        //Given
        BoardCreator boardCreator = new BoardCreator();
        SudokuBoard sudokuBoard = boardCreator.createEmptyBoard();
        SudokuResolver sudokuResolver = new SudokuResolver();
        sudokuBoard.getSudokuRows()[0].getSudokuElementsRow()[0].setValue(6);

        //When
        //  sudokuResolver.findAllSudokuNumbersInBox(sudokuBoard, 0, 0);

        //Then
        System.out.println(sudokuBoard);
    }

    @Test
    public void testFindAllSudokuNumbers() {
        //Given
        BoardCreator boardCreator = new BoardCreator();
        SudokuBoard sudokuBoardOne = boardCreator.createEmptyBoard();

        String sudokuOne = "..............3.85..1.2.......5.7.....4...1...9.......5......73..2.1........4...9";

        char[] charArray = sudokuOne.toCharArray();

        int counter = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(charArray[counter])) {
                    int value = Character.getNumericValue(charArray[counter]);
                    sudokuBoardOne.getSudokuRows()[i].getSudokuElementsRow()[j].setValue(value);
                }
                counter++;
            }
        }

        System.out.println(sudokuBoardOne);

        SudokuBoard sudokuBoard = sudokuBoardOne;
        SudokuResolver sudokuResolver = new SudokuResolver();

        //When
        sudokuResolver.findAllSudokuNumbers(sudokuBoard);

        //Then
        System.out.println(sudokuBoard);

    }
}
