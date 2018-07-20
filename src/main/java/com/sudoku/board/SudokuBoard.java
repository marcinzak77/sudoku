package com.sudoku.board;

import java.util.HashSet;

public class SudokuBoard extends Prototype {
    private SudokuRow[] sudokuBoard = new SudokuRow[9];

    public SudokuRow[] getSudokuBoard() {
        return sudokuBoard;
    }

    @Override
    public String toString() {
        String lineWithEnter = " -------------------------" + "\n";
        String results = lineWithEnter;
        String value;
        int rowNumber = 1;

            for (SudokuRow sudokuRow : sudokuBoard) {
                int columnNumber = 0;
                for (SudokuElement sudokuElement : sudokuRow.getSudokuElementsRow()) {
                    value = sudokuElement.toString();
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

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard)super.clone();
        clonedBoard.sudokuBoard = new SudokuRow[9];


        for (int i = 0; i < 9; i++) {
            SudokuElement[] clonedRow = new SudokuElement[9];
      //      clonedBoard.getSudokuBoard()[i].setSudokuElementsRow(clonedRow); //new

            for (int j = 0; j < 9; j++) {
                clonedRow[j].setValue(getSudokuBoard()[i].getSudokuElementsRow()[i].getValue());
                //clonedBoard.getSudokuBoard()[i].getSudokuElementsRow()[j].setValue();

            }
            clonedBoard.getSudokuBoard()[i].setSudokuElementsRow(clonedRow);

        }

        return clonedBoard;
    }
}
