package pkgHelper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import pkgGame.Sudoku;

public class SudokuTest {

	public SudokuTest() {
	}
	
	int[][] sudokuPuzzle = {
			{1,5,2,4,8,9,3,7,6},
			{7,3,9,2,5,6,8,4,1},
			{4,6,8,3,7,1,2,9,5},
			{3,8,7,1,2,4,6,5,9},
			{5,9,1,7,6,3,4,2,8},
			{2,4,6,8,9,5,7,1,3},
			{9,1,4,6,3,7,5,8,2},
			{6,2,5,9,4,8,1,3,7},
			{8,7,3,5,1,2,9,6,4}};
	int[] myArray = {1,5,2,7,3,9,4,6,8};
	
	@Test
	public void getRegionNbr_test() {
		Sudoku S = new Sudoku(sudokuPuzzle);
		assertTrue (Arrays.equals(myArray,S.getRegion(0)));
	}
	
	@Test
	public void getRegionCor_test() {
		Sudoku S = new Sudoku(sudokuPuzzle);
		assertTrue(Arrays.equals(myArray,S.getRegion(1,1)));
	}
	
	@Test
	public void hasDuplicate_test() {
		Sudoku S = new Sudoku(sudokuPuzzle);
		assertEquals(false,S.hasDuplicates());
	}
	
	@Test
	public void isSudoku_test() {
		Sudoku S = new Sudoku(sudokuPuzzle);
		assertEquals(true,S.isSudoku());
	}
	
	@Test
	public void isPartialSudoku_test() {
		Sudoku S = new Sudoku(sudokuPuzzle);
		assertEquals(false,S.isPartialSudoku());
	}
	
	@Test
	public void isValueValid_test() {
		Sudoku S = new Sudoku(sudokuPuzzle);
		assertEquals(true,S.isValueValid(6, 4, 4));
	}
}
