import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainClassPresenter extends BasePresenter implements IMainClassPresenter {

	private ISudokuValidator iSudokuValidator = new SudokuValidatorClass();

	@Override
	public boolean validateSudokuData(int[][] sudokuData) {
		return (new MainClassPresenter().iSudokuValidator.validateSudokuData(sudokuData));
	}

	@Override
	public int[][] enterMyRandomSudoku(int[][] sudokuData) {

		print("\nProcessing Random Sudoku data...\n");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudokuData[i][j] = new SecureRandom().nextInt(8) + 1;
			}
		}

		return sudokuData;
	}

	private int pSudokuData[][];

	@Override
	public void generateValidSudoku(int[][] pSudokuData) {

		print("\nGenerating valid Sudoku data...\n");

		this.pSudokuData = pSudokuData;
		Thread mySudokuThread = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int rowCount = 0; rowCount < 9; rowCount++) {
					for (int collumnCount = 0; collumnCount < 9; collumnCount++) {
						boolean flag = true;
						while (flag) {
							int randomNumber = getRandomNumber();
							// print("Checking number = "+randomNumber);
							if ((validateRowDataInSudoku(randomNumber, pSudokuData, rowCount, collumnCount))) {
								if (validateCollumnDataInSudoku(randomNumber, pSudokuData, rowCount, collumnCount)) {

									pSudokuData[rowCount][collumnCount] = randomNumber;
									// print("Value of " + rowCount + " " + collumnCount + " = "
									// + pSudokuData[rowCount][collumnCount]);
									// printMySudokuData(pSudokuData);
									flag = false;

								}
							}
						}

					}
				}
				printMySudokuData(pSudokuData);
				solveSudokuFuc(pSudokuData);
			}

		});

		mySudokuThread.start();

	}

	private void solveSudokuFuc(int[][] pSudokuData) {

		print("\nSolving Sudoku..\n");
		Thread solverThread = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int row = 0; row < 9; row++) {
					for (int collumn = 0; collumn < 9; collumn++) {
						boolean flag = true;
						int currentData = pSudokuData[row][collumn];
						while (flag) {
							if (validateRowData(pSudokuData, currentData, row, collumn)
									&& validateCollumnData(pSudokuData, currentData, row, collumn)) {
								pSudokuData[row][collumn] = currentData;
								flag = false;
							} else {
								currentData = getRandomNumber();
							}
						}

					}
				}
				printMySudokuData(pSudokuData);

			}

			private boolean validateCollumnData(int[][] pSudokuData, int pCurrentData, int pRow, int pCollumn) {

				int count = 0;
				for (int j = 0; j < 9; j++) {
					// print(pSudokuData[j][pCollumn] + " =Collumn= " + pTempCurrentData);
					if (pSudokuData[j][pCollumn] == pCurrentData) {

						count++;

					}
				}
				return (count < 1) ? true : false;

			}

			private boolean validateRowData(int[][] pSudokuData, int pCurrentData, int pRow, int pCollumn) {
				int count = 0;
				for (int j = 0; j < 9; j++) {
					// print(pSudokuData[pRow][j] + " =Row= " + pTempCurrentData);

					if (pSudokuData[pRow][j] == pCurrentData) {

						count++;

					}
				}
				return (count < 1) ? true : false;
			}

		});
		solverThread.start();

	}

	private int insertRandomUnRepeatedIntInthisPosition(int[][] pSudokuData, int pRow, int pCollumn) {

		while (true) {
			int randomNumber = getRandomNumber();
			if ((validateRowDataInSudoku(randomNumber, pSudokuData, pRow, pCollumn)
					&& validateCollumnDataInSudoku(randomNumber, pSudokuData, pRow, pCollumn))) {
				return randomNumber;
			}
		}

	}

	private int getRandomNumber() {
		return (int) new Random().nextInt(9) + 1;
	}

	private boolean validateCollumnDataInSudoku(int pTempCurrentData, int[][] pSudokuData, int pRow, int pCollumn) {

		int count = 0;
		for (int j = 0; j < 9; j++) {
			// print(pSudokuData[j][pCollumn] + " =Collumn= " + pTempCurrentData);
			if (pSudokuData[j][pCollumn] == pTempCurrentData) {
				if (pTempCurrentData == pSudokuData[pRow][pCollumn]) {

				} else {
					count++;
				}
			}
		}
		return (count <= 1) ? true : false;
	}

	private boolean validateWithinMatrix(Integer tempCurrentData, int[][] pSudokuData, int pRow, int pCollumn) {

		int rowInrementFrom = pRow / 3, rowIncrementTo = rowInrementFrom + 3, collumnIncrementFrom = pCollumn / 3,
				collumnIncrementTo = collumnIncrementFrom + 3;

		while (rowInrementFrom < rowIncrementTo) {
			while (collumnIncrementFrom < collumnIncrementTo) {
				if (tempCurrentData == pSudokuData[rowInrementFrom][collumnIncrementFrom]) {
					return false;
				}
				collumnIncrementFrom++;
			}
			rowInrementFrom++;
		}

		return true;
	}

	private boolean validateRowDataInSudoku(Integer pTempCurrentData, int[][] pSudokuData, int pRow, int pCollumn) {

		int count = 0;
		for (int j = 0; j < 9; j++) {
			// print(pSudokuData[pRow][j] + " =Row= " + pTempCurrentData);
			if (pSudokuData[pRow][j] == pTempCurrentData) {
				if (pTempCurrentData == pSudokuData[pRow][pCollumn]) {

				} else {
					count++;
				}
			}
		}
		return (count <= 1) ? true : false;
	}

	private void printMySudokuData(int[][] sudokuData) {
		print("\nSudoku data=\n");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(" " + sudokuData[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

}
