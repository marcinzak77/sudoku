package com.sudoku.board;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private SudokuElement[] sudokuElementsRow = new SudokuElement[9];

    public SudokuElement[] getSudokuElementsRow() {
        return sudokuElementsRow;
    }

    public void setSudokuElementsRow(SudokuElement[] sudokuElementsRow) {
        this.sudokuElementsRow = sudokuElementsRow;
    }

}
