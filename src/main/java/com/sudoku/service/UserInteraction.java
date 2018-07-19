package com.sudoku.service;

import com.sudoku.board.SudokuBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sudoku.board.SudokuElement.EMPTY;


public class UserInteraction {

    public void enterNewSudokuNumber(SudokuBoard sudokuBoard) {
        NumberValidator numberValidator = new NumberValidator();
        PrintMessages printMessages = new PrintMessages();

        if (numberValidator.checkIsSudokuResolved(sudokuBoard)) {
            printMessages.printMovementInformation();
            String enteredValues = KeyboardReader.getReadString();

            try {
                List<String> enteredValuesArray = Arrays.asList(enteredValues.split(","));
                int column = Integer.parseInt(enteredValuesArray.get(0)) - 1;
                int row = Integer.parseInt(enteredValuesArray.get(1)) - 1;
                int value = Integer.parseInt(enteredValuesArray.get(2));

                if (!numberValidator.checkAllSudokuConditions(sudokuBoard, column, row, value)) {
                    sudokuBoard.getSudokuBoard()[row].getSudokuElementsRow()[column].setValue(value);
                    System.out.println(sudokuBoard.getSudokuBoard()[row].getSudokuElementsRow()[column].getValue());
                    printMessages.printBoard(sudokuBoard);
                }
            } catch (Exception e) {
                printMessages.printMovementInformation();
            }

        }

    }

    public List<Integer> findAllExistingNumbersInRow(SudokuBoard sudokuBoard, int row) {
        List<Integer> currentValues = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            int currentSudokuNumber = sudokuBoard.getSudokuBoard()[row].getSudokuElementsRow()[i].getValue();

            if (currentSudokuNumber!=EMPTY) {
                currentValues.add(currentSudokuNumber);
            }
        }

        return currentValues;

    }

    public void findAllSudokuNumbersInRow(SudokuBoard sudokuBoard, int row) {
        NumberValidator numberValidator = new NumberValidator();

        List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        System.out.println(findAllExistingNumbersInRow(sudokuBoard, row).size());
        while (!possibleValues.isEmpty()) {

            possibleValues.removeAll(findAllExistingNumbersInRow(sudokuBoard, row));

            for (int i = 0; i < 9; i++) {

                if (sudokuBoard.getSudokuBoard()[row].getSudokuElementsRow()[i].getValue().equals(EMPTY)) {
                    for (int j = 0; j < possibleValues.size(); j++) {
                        int value = possibleValues.get(j);

                        numberValidator.setValidSudokuNumber(sudokuBoard, i, row, value);
                        possibleValues.remove(j);
                        j = possibleValues.size();

                    }

                }

            }
        }

        System.out.println("possible " + possibleValues);

    }

    public void findAllSudokuNumbers(SudokuBoard sudokuBoard) {

        for (int i = 0; i < 9; i++) {
            findAllSudokuNumbersInRow(sudokuBoard, i);
        }


    }
}
