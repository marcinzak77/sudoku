package com.sudoku.board;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> sudokuElementsRow = new ArrayList<>();

    public List<SudokuElement> getSudokuElementsRow() {
        return sudokuElementsRow;
    }

    public void setSudokuElementsRow(List<SudokuElement> sudokuElementsRow) {
        this.sudokuElementsRow = sudokuElementsRow;
    }
}
