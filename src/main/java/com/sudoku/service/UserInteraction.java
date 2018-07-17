package com.sudoku.service;

import com.sudoku.board.SudokuBoard;

import java.util.Arrays;
import java.util.List;

public class UserInteraction {

    public void enterNewSudokuNumber(SudokuBoard sudokuBoard) {
        NumberValidator numberValidator = new NumberValidator();
        PrintMessages printMessages = new PrintMessages();

        if (!numberValidator.checkIsSudokuResolved(sudokuBoard)) {
            String enteredValues = KeyboardReader.getReadString();
            List<String> enteredValuesArray = Arrays.asList(enteredValues.split(","));
            int column = Integer.parseInt(enteredValuesArray.get(0));
            int row = Integer.parseInt(enteredValuesArray.get(1));
            int value = Integer.parseInt(enteredValuesArray.get(2));

            if (numberValidator.checkAllSudokuConditions(sudokuBoard, column, row, value)) {
                sudokuBoard.getSudokuBoard()[row].getSudokuElementsRow()[column].setValue(value);
                System.out.println(sudokuBoard.getSudokuBoard()[row].getSudokuElementsRow()[column].getValue());
                printMessages.printBoard(sudokuBoard);
            }
        }

    }
}
