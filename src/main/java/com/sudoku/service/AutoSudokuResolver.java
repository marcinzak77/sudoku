package com.sudoku.service;

import com.sudoku.board.SudokuBoard;

import java.util.*;
import java.util.stream.Collectors;

import static com.sudoku.board.SudokuElement.EMPTY;

public class AutoSudokuResolver{
    private NumberValidator numberValidator = new NumberValidator();

    public List<Integer> findAllExistingNumbersInRow(SudokuBoard sudokuBoard, int row) {
        List<Integer> currentValues = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            int currentSudokuNumber = sudokuBoard.getSudokuRows()[row].getSudokuElementsRow()[i].getValue();

            if (currentSudokuNumber != EMPTY) {
                currentValues.add(currentSudokuNumber);
            }
        }

        return currentValues;

    }

    public List<Integer> findAllExistingNumbersInColumn(SudokuBoard sudokuBoard, int column) {
        List<Integer> currentValues = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            int currentSudokuNumber = sudokuBoard.getSudokuRows()[i].getSudokuElementsRow()[column].getValue();

            if (currentSudokuNumber != EMPTY) {
                currentValues.add(currentSudokuNumber);
            }
        }

        return currentValues;

    }

    public HashMap<Integer, List<Integer>> findAllPlacementInRow(SudokuBoard sudokuBoard, int row) {
        Map<Integer, List<Integer>> allPlacementInRow = new HashMap<>();
        List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> existingValues = findAllExistingNumbersInRow(sudokuBoard,row);
        possibleValues.removeAll(existingValues);
        List<Integer> emptyPositionList = new ArrayList<>();

        for (int j = 0; j < 9; j++) {
            if (sudokuBoard.getSudokuRows()[row].getSudokuElementsRow()[j].getValue().equals(EMPTY)) {
                emptyPositionList.add((Integer)j);
            }
        }

        for (int value: possibleValues) {
            List<Integer> positionList = new ArrayList<>();

            for (int empty: emptyPositionList) {
                if (!numberValidator.checkAllSudokuConditions(sudokuBoard, empty, row, value)) {
                    positionList.add(empty);
                    allPlacementInRow.put(value, positionList);
                }
            }
        }

        return (HashMap<Integer, List<Integer>>)allPlacementInRow;

    }

    public HashMap<Integer, List<Integer>> findAllPlacementInColumn(SudokuBoard sudokuBoard, int column) {
        Map<Integer, List<Integer>> allPlacementInColumn = new HashMap<>();
        List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> existingValues = findAllExistingNumbersInColumn(sudokuBoard,column);
        possibleValues.removeAll(existingValues);
        List<Integer> emptyPositionList = new ArrayList<>();

        for (int j = 0; j < 9; j++) {
            if (sudokuBoard.getSudokuRows()[j].getSudokuElementsRow()[column].getValue().equals(EMPTY)) {
                emptyPositionList.add((Integer)j);
            }
        }

        for (int value: possibleValues) {
            List<Integer> positionList = new ArrayList<>();

            for (int empty: emptyPositionList) {
                if (!numberValidator.checkAllSudokuConditions(sudokuBoard, column, empty, value)) {
                    positionList.add(empty);
                    allPlacementInColumn.put(value, positionList);
                }
            }
        }

        return (HashMap<Integer, List<Integer>>)allPlacementInColumn;

    }

    public List<Integer> findSinglePlacement(HashMap<Integer, List<Integer>> allPlacements) {
        return allPlacements.entrySet().stream()
                                       .filter(s -> s.getValue().size()<2)
                                       .map(Map.Entry::getKey)
                                       .collect(Collectors.toList());

    }

    public boolean sudokuRowCantBeResolved(HashMap<Integer, List<Integer>> allPlacements) {
        List<Integer> keyListWithSinglePlacement = findSinglePlacement(allPlacements);
        HashSet<Integer> uniquePlacementList = new HashSet<>();

        for (Integer value: keyListWithSinglePlacement) {
            uniquePlacementList.add(allPlacements.get(value).get(0));
        }

        if (keyListWithSinglePlacement.size()>uniquePlacementList.size()) {
            return true;
        }
        return false;
    }

    public boolean isSolutionForSudoku(SudokuBoard sudokuBoard) {
        for (int i = 0; i < 9; i++) {
            HashMap<Integer, List<Integer>> allPlacementsRow = findAllPlacementInRow(sudokuBoard, i);
            HashMap<Integer, List<Integer>> allPlacementsColumn = findAllPlacementInColumn(sudokuBoard, i);


            if (findSinglePlacement(allPlacementsRow).size()>1 && sudokuRowCantBeResolved(allPlacementsRow)) {
                return false;
            }

            if (findSinglePlacement(allPlacementsColumn).size()>1 && sudokuRowCantBeResolved(allPlacementsColumn)) {
                return false;
            }

            if (allPlacementsRow.isEmpty() && findAllExistingNumbersInRow(sudokuBoard, i).size() < 9 ) {
                return false;
            }

            if (allPlacementsColumn.isEmpty() && findAllExistingNumbersInColumn(sudokuBoard, i).size() < 9 ) {
                return false;
            }
        }
        return true;
    }

    public boolean findAllSudokuNumbers(SudokuBoard sudokuBoard) {

        for (int currentRow = 0; currentRow < 9; currentRow++) {
            for (int currentColumn = 0; currentColumn < 9; currentColumn++) {
                if (sudokuBoard.getSudokuRows()[currentRow].getSudokuElementsRow()[currentColumn].getValue() == EMPTY) {
                    for (int value = 1; value <= 9; value ++) {

                        if (numberValidator.setValidSudokuNumber(sudokuBoard, currentColumn, currentRow, value)
                                && findAllSudokuNumbers(sudokuBoard)) {

                            return true;
                        }
                        sudokuBoard.getSudokuRows()[currentRow].getSudokuElementsRow()[currentColumn].setValue(EMPTY);
                    }
                    return false;
                }
            }

        }
        return true;
    }
}

