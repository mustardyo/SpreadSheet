public class cells 
{
	int colNum;
	int rowNum;
	Cell groupCell[];
	int numUndLine;
	String undLine;
	String plus;
	String wall;
	String letters[];
	String space;
	public cells(int row, int col)
	{
		letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		colNum = col;
		rowNum = row;

		
		//plus one for header row
		int anum = colNum * (rowNum + 1);
		
		groupCell = new Cell[anum];
		for (int i = 0; i < anum; i++)
		{
			groupCell[i] = new Cell();
		}

		//Initialize first row
		for (int i = 0; i < colNum; i++)
		{
			groupCell[i].SetName(letters[i]);
		}
		numUndLine = 12;
		undLine = new String("-");
		plus = new String("+");
		wall = new String("|");	
		space = new String(" ");

		
	}
	public void printWithValue(String value, int valLength)
	{
		if (value.length() < 13)
		{
			int numberOfSpaces = 12-value.length();
			for (int i = 0; i < (numberOfSpaces / 2); i++)
			{
				System.out.print(space);
			}
			System.out.print(value);
			for (int j = 0; j < ((numberOfSpaces+1)/2); j++)
			{
				System.out.print(space);
			}
		}
		else
		{
			System.out.print(value.substring(0, 11));
			System.out.print(">");
		}
		
	}
	
	public int getIndex(String coord)
	{
		int xcoord = 0;
		String y = coord.substring(1,coord.length());
		int ycoord = Integer.parseInt(y);
		for (int i = 0; i < letters.length; i++)
		{
			if (coord.substring(0,1).equals(letters[i]))
			{
				xcoord = i+1;
				break;
			}
		}
		return (ycoord * colNum) + (xcoord - 1);
	}
	public void setIndex(int r, int c)
	{
		int index = (r * colNum) + (c-1);
	}
	public int RowNum(int index)
	{
		return index/colNum;
	}
	
	public int ColNum(int index)
	{
		return index%colNum;
	}

	public int GetCol()
	{
		return colNum;
	}
	
	public int GetRow()
	{
		return rowNum;
	}
	
	public Cell[] GetCells()
	{
		return groupCell;
	}
	
	public void firstRow()
	{
		for (int i = 0; i < 6; i++)
		{
			System.out.print(space);
		}
		System.out.print(wall);
		for (int i = 0; i < 5; i++)
		{
			System.out.print(space);
		}
	}
	public void firstRowOver10()
	{
		for (int i = 0; i < 12; i++)
		{
			System.out.print(space);
		}
		System.out.print(wall);
	}
	public void secondRow()
	{
		for (int j = 0; j < colNum + 1; j++)
		{
			for (int i = 0; i < 12; i++)
			{
				System.out.print(undLine);
			}
			System.out.print(plus);
		}
	}
	public void columnNumbers(int x)
	{
		if (x < 10)
		{
		for(int i = 0; i < 6; i++)
		{
			System.out.print(space);
		}
		if (x != 0)
		{
			System.out.print(x);
		}
		else 
		{
			System.out.print(" ");
		}
		for(int i = 0; i < 6; i++)
		{
			System.out.print(space);
		}
		System.out.print(wall);
		}
		else
		{
			for(int i = 0; i < 6; i++)
			{
				System.out.print(space);
			}
			System.out.print(x);

			for(int i = 0; i < 5; i++)
			{
				System.out.print(space);
			}
			System.out.print(wall);
			}
		
	}

	public void printCells()
	{
		/*for (int i = 0; i < 7; i++)
		{
			System.out.print(space);
		}
		for (int i = 0; i < letters.length; i++)
		{
			firstRow();
			System.out.print(letters[i]);
		}
		for (int i = 0; i < 6; i++)
		{
			System.out.print(space);
		}
		 */
		//System.out.print(wall);
		//System.out.println();
		//System.out.print(space);
		
		
		//secondRow();
		
		//q
//		System.out.println();
		for (int i = 0; i < rowNum+1; i++)
		{
			columnNumbers(i);
			
			
			int firstColPerRow = i * colNum;
			for (int k = 0; k < colNum; k++)
			{
				if (i != 10)
				{
					String cellName = groupCell[firstColPerRow + k].GetName();
					printWithValue(cellName, 0);
					System.out.print(wall);
				}
				else if (i >= 10)
				{
					String cellName1 = groupCell[firstColPerRow + k].GetName();
					printWithValue(cellName1, 0);
					System.out.print(wall);
				}
				else 
				{
					//firstRow();
					//String cellName2 = groupCell[firstColPerRow + k].GetName();
					//printWithValue(cellName, firstColPerRow);
//					System.out.print(space);
				}
				//firstRow();
				//System.out.print(space);
			}
			System.out.println();
			System.out.print(undLine);
			secondRow();
			
			System.out.println();
		}
	}
	/*
	public void printCells()
	{
		for (int i = 0; i < 7; i++)
		{
			System.out.print(space);
		}
		for (int i = 0; i < letters.length; i++)
		{
			firstRow();
			System.out.print(letters[i]);
		}
		for (int i = 0; i < 6; i++)
		{
			System.out.print(space);
		}
		System.out.print(wall);
		System.out.println();
		System.out.print(space);
		
		secondRow();
	}
	*/
	
	public void setCellVal(int index, String val)
	{
		groupCell[index].SetName(val);
		//groupCell[index].setValue(val);
		//printWithValue(val, length);
	}
	public void setForm(int index, String form)
	{
		groupCell[index].SetFormula(form);
	}
	public void setCellVal(int index, double val)
	{
		groupCell[index].setValue(val);
		String namedub = Double.toString(val);
		groupCell[index].SetName(namedub);
		

	}
	public String getCellVal(int index)
	{
		return groupCell[index].GetName();
	}

	public String getCellFormula(int index)
	{
		return groupCell[index].GetFormula();
	}

	public void clearWhole()
	{
		for (int a = colNum; a < groupCell.length; a++)
		{
			groupCell[a].SetName(" ");
			//setCellVal(a, " ");
			groupCell[a].SetFormula("");
		}
	}
	public void clearSpecificCell(String coords)
	{
		int theIndex = getIndex(coords);
		setCellVal(theIndex, " ");
		groupCell[theIndex].SetName(" ");
		//groupCell[theIndex].SetName("");
	}

}
