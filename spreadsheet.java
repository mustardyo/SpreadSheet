
public class spreadsheet 
{
	int numberOfSpreadsheets;
	cells NewCell;
	
	public spreadsheet(int row, int col)
	{
		NewCell = new cells(row, col);
	}
	
	public void showSpreadsheet()
	{
		NewCell.printCells();
	}
	
	public cells GetCells()
	{
		return NewCell;
	}
}
