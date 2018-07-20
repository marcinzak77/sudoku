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




}
