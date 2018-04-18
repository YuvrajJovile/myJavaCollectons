
public class SudokuValidatorPresenter extends BasePresenter implements ISudokuValidatorPresenter {

	@Override
	public boolean validateSudokuData(int[][] sudokuData) {
		return isValid(sudokuData) ? true : false;
	}

	private boolean isValid(int[][] sudokuData) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Integer tempCurrentData = sudokuData[i][j];
				int row = i, collumn = j;
				if (!(validateRowDataInSudoku(tempCurrentData, sudokuData, row)
						&& validateCollumnDataInSudoku(tempCurrentData, sudokuData, collumn)
						&& validateWithinMatrix(tempCurrentData, sudokuData, row, collumn)))
					return false;
			}
		}
		return true;
	}

	private boolean validateWithinMatrix(Integer tempCurrentData, int[][] pSudokuData, int pRow, int pCollumn) {

		int rowInrementFrom = pRow / 3, rowIncrementTo = rowInrementFrom + 3, collumnIncrementFrom = pCollumn / 3,
				collumnIncrementTo = collumnIncrementFrom + 3;

		while (rowInrementFrom <= rowIncrementTo) {
			while (collumnIncrementFrom <= collumnIncrementTo) {
				if (tempCurrentData == pSudokuData[rowInrementFrom][collumnIncrementFrom]) {
					return false;
				}
				collumnIncrementFrom++;
			}
			rowInrementFrom++;
		}

		return true;
	}

	private boolean validateCollumnDataInSudoku(int pTempCurrentData, int[][] pSudokuData, int pRowOrCollumn) {
		int count = 0;
		for (int j = 0; j < 9; j++) {
			if (pSudokuData[j][pRowOrCollumn] == pTempCurrentData) {
				count++;
			}
		}
		return (count <= 1) ? true : false;

	}

	private boolean validateRowDataInSudoku(Integer pTempCurrentData, int[][] pSudokuData, int pRow) {

		int count = 0;
		for (int j = 0; j < 9; j++) {
			if (pSudokuData[pRow][j] == pTempCurrentData) {
				count++;
			}
		}
		return (count <= 1) ? true : false;
	}

}
