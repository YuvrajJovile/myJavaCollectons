
public interface IMainClassPresenter {

	boolean validateSudokuData(int[][] sudokuData);

	int[][] enterMyRandomSudoku(int[][] sudokuData);

	void generateValidSudoku(int[][] sudokuData);

}
