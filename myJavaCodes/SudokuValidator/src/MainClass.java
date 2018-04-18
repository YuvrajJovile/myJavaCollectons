import java.util.Scanner;

public class MainClass extends BaseClass implements IMainClass {

	private IMainClassPresenter iMainClassPresenter = new MainClassPresenter();

	public static void main(String[] args) {

		MainClass mainClassObj = new MainClass();

		int sudokuData[][] = new int[9][9];

		mainClassObj.print("Enter the 9*9 Sudoku to be validated:\n");
		
		//mainClassObj.iMainClassPresenter.enterMyRandomSudoku(sudokuData);
		
		mainClassObj.printMySudokuData(mainClassObj.getSudokuData(sudokuData));
		if (mainClassObj.iMainClassPresenter.validateSudokuData(sudokuData)) {
			mainClassObj.print("\nThe Sudoku is valid!");
		} else {
			mainClassObj.print("\nThe Sudoku is invalid!");
		}
		
		mainClassObj.iMainClassPresenter.generateValidSudoku(sudokuData);
		//mainClassObj.printMySudokuData(mainClassObj.iMainClassPresenter.generateValidSudoku(sudokuData));
		
		
		
	}

	
	private void printMySudokuData(int[][] sudokuData) {
		print("\nSudoku data=\n");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(" "+sudokuData[i][j]+" ");
			}
			System.out.print("\n");
		}
	}

	private int[][] getSudokuData(int sudokuData[][]) {
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				sudokuData[i][j] = getItemData(i, j);
//			}
//		}
		return sudokuData;
	}

	private int getItemData(int i, int j) {
		print("\nEnter Sudoku " + i + " " + j + " data\n");
		return scanInt();
	}

}
