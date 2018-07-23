package com.sudoku.service;

import com.sudoku.board.SudokuBoard;

import java.util.*;

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

    public void findAllSudokuNumbersInRow(SudokuBoard sudokuBoard, int row) {


        List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        possibleValues.removeAll(findAllExistingNumbersInRow(sudokuBoard, row));

        while (possibleValues.iterator().hasNext()) {

            for (int i = 0; i < 9; i++) {
                if (sudokuBoard.getSudokuRows()[row].getSudokuElementsRow()[i].getValue().equals(EMPTY)) {


                    int value = possibleValues.iterator().next();

                    int numberInRow = findAllExistingNumbersInRow(sudokuBoard, row).size();
                    numberValidator.setValidSudokuNumber(sudokuBoard, i, row, value);

                    if (numberInRow < findAllExistingNumbersInRow(sudokuBoard, row).size()) {


                        possibleValues.remove((Integer) value);
                        break;
                    }
                }
            }

        }
    }

    public HashMap<Integer, Integer> findAmountOfPossiblities(SudokuBoard sudokuBoard, int row, int column, List<Integer> possibleValues) {
        return null;
    }

    public void findAllSudokuNumbersInBox(SudokuBoard sudokuBoard, int row, int column) {
        List<Integer> possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> existingValues = numberValidator.getValuesFromSudokuBox(sudokuBoard, row, column);
        HashMap<Integer, Integer> amountOfPossiblePlacements = new HashMap<>();
        possibleValues.removeAll(existingValues);
        SudokuBoard backUpBoard = sudokuBoard.deepCopy(sudokuBoard);


        int startRow = numberValidator.getStartRowAndColumn(row, column)[0];
        int startColumn = numberValidator.getStartRowAndColumn(row, column)[1];

        while (!possibleValues.isEmpty()) {

            for (Integer value: possibleValues) {
                amountOfPossiblePlacements.put(value, 1);
            }

            int counter = 0;

            for (int value : possibleValues) {
                for (int i = startRow; i < (startRow + 3); i++) {
                    for (int j = startColumn; j < (startColumn + 3); j++) {
                        if (sudokuBoard.getSudokuRows()[i].getSudokuElementsRow()[j].getValue().equals(EMPTY)) {

                                if (!numberValidator.checkAllSudokuConditions(sudokuBoard, j, i, value)) {
                                    counter = amountOfPossiblePlacements.get(value);
                                    counter++;
                                    amountOfPossiblePlacements.put(value, counter);

                            }
                        }
                    }
                }
            }




        if (counter == 0) {

            sudokuBoard = backUpBoard;
        }


            int currentNumber = possibleValues.get(0);
            int currentAmount = amountOfPossiblePlacements.get(currentNumber);
            for (Map.Entry<Integer, Integer> entry: amountOfPossiblePlacements.entrySet()) {
                if (entry.getValue()<currentAmount) {
                    currentAmount = entry.getValue();
                    currentNumber = entry.getKey();
                }
            }



            for (int i = startRow; i < (startRow + 3); i++) {
                for (int j = startColumn; j < (startColumn + 3); j++) {

                    if (sudokuBoard.getSudokuRows()[i].getSudokuElementsRow()[j].getValue().equals(EMPTY)) {

                        numberValidator.setValidSudokuNumber(sudokuBoard, j, i, currentNumber);
                        System.out.println(currentNumber + " " + currentAmount + " " + counter + " " + possibleValues);
                        System.out.println(sudokuBoard);
                        if (!sudokuBoard.getSudokuRows()[i].getSudokuElementsRow()[j].getValue().equals(EMPTY)) {
                            existingValues = numberValidator.getValuesFromSudokuBox(sudokuBoard, row, column);
                            amountOfPossiblePlacements.clear();
                            possibleValues.removeAll(existingValues);
                        }
                    }
                }
            }
        }

     //   return sudokuBoard;
    }

    public boolean isSudokuBoxResolved(List<Integer> possibleValues, List<Integer> existingValues) {
        if (possibleValues.isEmpty()) {
            return true;
        }
        return false;
    }


    public void findAllSudokuNumbers(SudokuBoard sudokuBoard) {


             findAllSudokuNumbersInRow(sudokuBoard, 0);
             findAllSudokuNumbersInBox(sudokuBoard, 3, 3);
             findAllSudokuNumbersInRow(sudokuBoard, 3);
             findAllSudokuNumbersInBox(sudokuBoard, 0,3);
             findAllSudokuNumbersInRow(sudokuBoard, 1);
             findAllSudokuNumbersInBox(sudokuBoard,6,3);
             findAllSudokuNumbersInRow(sudokuBoard, 2);
             findAllSudokuNumbersInBox(sudokuBoard,6,0);
             findAllSudokuNumbersInRow(sudokuBoard, 6);





//           sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard, 3, 3);
//        sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard, 0,0);
//           System.out.println(sudokuBoard);
//        sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard, 0,3);
//           System.out.println(sudokuBoard);
//        sudokuBoard =
//           System.out.println(sudokuBoard);
//        sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard, 6,3);
//           System.out.println(sudokuBoard);
//        sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard,3,0);
//           System.out.println(sudokuBoard);
//        sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard,0,6);
//           System.out.println(sudokuBoard);
//        sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard,6,6);
//           System.out.println(sudokuBoard);
//        sudokuBoard = findAllSudokuNumbersInBox(sudokuBoard,6,0);




    }
}
