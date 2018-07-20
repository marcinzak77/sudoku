package com.sudoku.service;

import com.sudoku.board.SudokuBoard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sudoku.board.SudokuElement.EMPTY;

public class AutoSudokuResolver {
    private NumberValidator numberValidator = new NumberValidator();

    public List<Integer> findAllExistingNumbersInRow(SudokuBoard sudokuBoard, int row) {
        List<Integer> currentValues = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            int currentSudokuNumber = sudokuBoard.getSudokuBoard()[row].getSudokuElementsRow()[i].getValue();

            if (currentSudokuNumber != EMPTY) {
                currentValues.add(currentSudokuNumber);
            }
        }

        return currentValues;

    }

    public void findAllSudokuNumbersInRow(SudokuBoard sudokuBoard, int row) {


        List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        possibleValues.removeAll(findAllExistingNumbersInRow(sudokuBoard, row));

        while (possibleValues.iterator().hasNext()) {

            for (int i = 0; i < 9; i++) {
                if (sudokuBoard.getSudokuBoard()[row].getSudokuElementsRow()[i].getValue().equals(EMPTY)) {


                    int value = possibleValues.iterator().next();
                    //possibleValues.iterator().next().remove();
                    int numberInRow = findAllExistingNumbersInRow(sudokuBoard, row).size();
                    numberValidator.setValidSudokuNumber(sudokuBoard, i, row, value);

                    if (numberInRow < findAllExistingNumbersInRow(sudokuBoard, row).size()) {
                        System.out.println("hit");

                        possibleValues.remove((Integer) value);
                        break;
                    }
                }
            }

        }
    }

    public void findAllSudokuNumbersInBox(SudokuBoard sudokuBoard, int row, int column) {
        List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> existingValues = numberValidator.getValuesFromSudokuBox(sudokuBoard, row, column);
        possibleValues.removeAll(existingValues);

        int startRow = numberValidator.getStartRowAndColumn(row, column)[0];
        int startColumn = numberValidator.getStartRowAndColumn(row, column)[1];

        while (!possibleValues.isEmpty()) {

            for (int i = startRow; i < (startRow + 3); i++) {
                for (int j = startColumn; j < (startColumn + 3); j++) {
                    System.out.println(sudokuBoard);
                    if (sudokuBoard.getSudokuBoard()[i].getSudokuElementsRow()[j].getValue().equals(EMPTY)) {

                        for (int value : possibleValues) {
                            numberValidator.setValidSudokuNumber(sudokuBoard, j, i, value);

                            if (!sudokuBoard.getSudokuBoard()[i].getSudokuElementsRow()[j].getValue().equals(EMPTY)) {
                                existingValues = numberValidator.getValuesFromSudokuBox(sudokuBoard, row, column);
                                break;
                            }
                        }

                        possibleValues.removeAll(existingValues);




                    }
                }
            }
        }
    }




    public boolean isSudokuInsertedCorecctly(List<Integer> previousValues, List<Integer> currentValues) {

        if (previousValues.size()>currentValues.size()) {
            return true;
        }
        return false;

        }


    public void findAllSudokuNumbers(SudokuBoard sudokuBoard) {


        findAllSudokuNumbersInBox(sudokuBoard, 0,0);
        findAllSudokuNumbersInBox(sudokuBoard, 3, 3);
        findAllSudokuNumbersInBox(sudokuBoard, 0,3);
        findAllSudokuNumbersInBox(sudokuBoard,3,6);
        findAllSudokuNumbersInBox(sudokuBoard, 6,3);
        findAllSudokuNumbersInBox(sudokuBoard,3,0);
        System.out.println(sudokuBoard);

        System.out.println(sudokuBoard);
        findAllSudokuNumbersInBox(sudokuBoard,0,6);
        System.out.println(sudokuBoard);
        findAllSudokuNumbersInBox(sudokuBoard,6,6);
        System.out.println(sudokuBoard);
        findAllSudokuNumbersInBox(sudokuBoard,6,0);

    }
}
