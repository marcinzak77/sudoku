package com.sudoku.service;

import com.sudoku.board.SudokuBoard;
import com.sudoku.board.SudokuElement;
import com.sudoku.board.SudokuRow;

import java.util.ArrayList;
import java.util.List;

import static com.sudoku.board.SudokuElement.EMPTY;

public class NumberValidator {

    int currentColumn;


    public boolean checkValuesInSudokuRow(SudokuBoard sudokuBoard, int rowNumber, Integer newValue) {

        for (SudokuElement sudokuElement: sudokuBoard.getSudokuBoard()[rowNumber].getSudokuElementsRow()) {
            if (sudokuElement.getValue().equals(newValue)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkValuesInSudokuColumn(SudokuBoard sudokuBoard, int columnNumber, Integer newValue) {

        for (SudokuRow sudokuRow: sudokuBoard.getSudokuBoard()) {
            if (sudokuRow.getSudokuElementsRow()[columnNumber].getValue().equals(newValue)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkValuesInSudokuBox(SudokuBoard sudokuBoard, int rowNumber, int columnNumber, Integer newValue) {

        int boxNumber = getSudokuBoxNumber(rowNumber, columnNumber);
        int startRow = 0;
        int startColumn = 0;
        int currentColumn = 0;
        List<Integer> allValuesInBox = new ArrayList<>();

        switch (boxNumber) {
            case 1:
                startRow = 0;
                startColumn = 0;
                break;
            case 2:
                startRow = 0;
                startColumn = 3;
                break;
            case 3:
                startRow = 0;
                startColumn = 6;
                break;
            case 4:
                startRow = 3;
                startColumn = 0;
                break;
            case 5:
                startRow = 3;
                startColumn = 3;
                break;
            case 6:
                startRow = 3;
                startColumn = 6;
                break;
            case 7:
                startRow = 6;
                startColumn = 0;
                break;
            case 8:
                startRow = 6;
                startColumn = 3;
                break;
            case 9:
                startRow = 6;
                startColumn = 6;
                break;
        }


        for (SudokuRow sudokuRow: sudokuBoard.getSudokuBoard()) {
            if (currentColumn >= startColumn) {
                for (int i = startRow; i<(startRow +3); i++) {
                    allValuesInBox.add(sudokuRow.getSudokuElementsRow()[i].getValue());
                }
            }

            if (currentColumn == startColumn + 2) {
                break;
            }
            currentColumn++;
        }

        if (allValuesInBox.contains(newValue)) {
            return true;
        }

        return false;
    }

    public int getSudokuBoxNumber(int rowNumber, int columnNumber) {
        if (rowNumber <= 3) {
            if (columnNumber <= 3) {
                return 1;
            } else if (columnNumber <= 6) {
                return 2;
            } else  {
                return 3;
            }
        } else if (rowNumber <= 6) {
            if (columnNumber <= 3) {
                return 4;
            } else if (columnNumber <= 6) {
                return 5;
            } else  {
                return 6;
            }
        } else {
            if (columnNumber <= 3) {
                return 7;
            } else if (columnNumber <= 6) {
                return 8;
            } else  {
                return 9;
            }
         }
    }

    public boolean checkAllSudokuConditions(SudokuBoard sudokuBoard, int column, int row, int value) {

        if (checkValuesInSudokuRow(sudokuBoard, row, value) || checkValuesInSudokuColumn(sudokuBoard,column, value)
                || checkValuesInSudokuBox(sudokuBoard, row, column, value)) {
            return true;
        }
        return false;
    }

    public boolean checkIsSudokuResolved(SudokuBoard sudokuBoard) {

        for (SudokuRow sudokuRow: sudokuBoard.getSudokuBoard()) {
            for (int i = 0; i < 9; i++) {
                return !sudokuRow.getSudokuElementsRow()[currentColumn].getElementValue().contains(EMPTY);
            }
            currentColumn++;
        }
        return true;
    }


}

