package com.sudoku.board;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private SudokuRow[] sudokuBoard = new SudokuRow[9];

    public SudokuRow[] getSudokuBoard() {
        return sudokuBoard;
    }

    @Override
    public String toString() {
        String lineWithEnter = " ----------------------------------" + "\n";
        String results = lineWithEnter;
        Integer value;
        int rowNumber = 1;

            for (SudokuRow sudokuRow : sudokuBoard) {
                int columnNumber = 0;
                for (SudokuElement sudokuElement : sudokuRow.getSudokuElementsRow()) {
                    value = sudokuElement.getValue();
                        if (columnNumber % 3 == 0) {
                            results += (" | " + value);
                        } else results += (" " + value);
                        columnNumber++;
                }

                if (rowNumber % 3 == 0) {
                    results += " |" + "\n" + lineWithEnter;
                } else results += " |" + "\n";
                rowNumber++;

            }
            return results;
    }
}
