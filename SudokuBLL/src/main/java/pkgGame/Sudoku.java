package pkgGame;

//import java.util.Arrays;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare{
	
	private static int[][] latinsquare;
	private int iSize;
	private int iSqrtSize;
	
	public Sudoku(int iSize) {
		super();
		this.iSize = iSize;
	}
	
	
	public Sudoku(int[][] latinSquare) {
		super(latinSquare);
		//this.latinsquare = latinsquare;
	}
	
	public int[][] getPuzzle(){
		return super.getLatinSquare();
	}
	
	public int[] getRegion(int iRegionNbr) {
		int[] myRegion = new int[latinsquare.length];
		int iSize = latinsquare.length;
		int iSizeSqrt = (int)Math.sqrt(iSize);
		int regionRow = iRegionNbr / iSizeSqrt;
		int regionCol = iRegionNbr % iSizeSqrt;
		int minRow = 0;
		int maxRow = 0;
		int minCol = 0;
		int maxCol = 0;
		int index = 0;
		
		if(regionRow == 0) {
			minRow = 0;
			maxRow = 2;
		}
		else if(regionRow == 1) {
			minRow = 3;
			maxRow = 5;
		}
		else if(regionRow == 2) {
			minRow = 6;
			maxRow = 8;
		}
		
		if(regionCol == 0) {
			minCol = 0;
			maxCol = 2;
		}
		else if(regionCol == 1) {
			minCol = 3;
			maxCol = 5;
		}
		else if(regionCol == 2) {
			minCol = 6;
			maxCol = 8;
		}
		
		for(int row = minRow; row <= maxRow; row++) {
			for(int col = minCol; col <= maxCol; col++) {
				myRegion[index] = latinsquare[row][col];
				index++;
			}
		}
		
		
		return myRegion;
		
		
		
		
		
	}
	
	public int[] getRegion(int Col, int Row) {
		
		int iSize = latinsquare.length;
		int iSizeSqrt = (int)Math.sqrt(iSize);
		return getRegion(((Row / iSizeSqrt) * iSizeSqrt) + (Col / iSizeSqrt));
		
		
		
	}
	
	public boolean hasDuplicates() {
		boolean results = false;
		boolean returns1 = false;
		boolean returns2 = false;
		for(int index = 0; index < latinsquare.length; index++) {
			results = hasDuplicates(getRow(index));
			if (results == true) {
				returns1 = true;
			}
		}
		for(int index = 0; index < latinsquare.length; index++) {
			results = hasDuplicates(getColumn(index));
			if (results == true) {
				returns2 = true;
			}
		}
		return (returns1 | returns2);
	}
	
	public boolean isSudoku() {
		if ((hasDuplicates() == false) && (ContainsZero() == false)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isPartialSudoku() {
		if ((hasDuplicates() == false) && (ContainsZero() == true)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isValueValid(int iValue, int Col, int Row) {
		if (doesElementExist(getColumn(Col),iValue) == true) {
			return false;
		}
		else if (doesElementExist(getRow(Row),iValue) == true) {
			return false;
		}
		else if (doesElementExist(getRegion(Col, Row),iValue) == true) {
			return false;
		}
		else {
			return true;
		}
	}
}
