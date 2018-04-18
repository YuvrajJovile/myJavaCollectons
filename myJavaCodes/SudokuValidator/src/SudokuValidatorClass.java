
public class SudokuValidatorClass implements ISudokuValidator{

	private ISudokuValidatorPresenter iSudokuValidatorPresenter = new SudokuValidatorPresenter();

	
	public static void main(String args[]) {

	}

	@Override
	public boolean validateSudokuData(int[][] sudokuData) {
		return (new SudokuValidatorClass().iSudokuValidatorPresenter.validateSudokuData(sudokuData));
	}

}
