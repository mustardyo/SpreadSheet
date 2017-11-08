import java.util.Scanner;
public class classCalling
{
	spreadsheet Sheet;
	String letters[];
	//cells testCells;
	String equation;
	Formula formulaUsed;
	Formula strictlyName;
	String formulaName;
	String[] equationSplit;
	String formulaNoPar;
	String valueAtIndex;
	Formula formulaCellVal;
	String formulaWithVal; 
	String newFormulaWithVal;
	int random;
	int spaceInd;
	
	public classCalling(spreadsheet mySpreadSheet, cells myCells)
	{
		letters = new String[]{"A", "B", "C", "D", "E", "F", "G"};
		System.out.println("Hello welcome to Text Excel!");
		Sheet = mySpreadSheet;
		equation = "";
		formulaName = "";
		equationSplit = new String[] {};
		formulaNoPar = "";
		valueAtIndex = "";
		random = 0;
		newFormulaWithVal = "";
		spaceInd = 0;
	
	}
	public void enterCommand(String userinput) 
	{
		Scanner sc = new Scanner(System.in);
		int spaceIndex = userinput.indexOf(" ");
		if (userinput.equals("help"))
		{

			displayHelp();			
		}
		else if (userinput.equals("print"))
		{
			Sheet.showSpreadsheet();
		}
		else if (userinput.equals("exit"))
		{
			System.out.println("Goodbye!");
		}
		else if (userinput.length() == 2 || userinput.length() == 3)
		{
			cells returnedCell = Sheet.GetCells();
			int indexOfCells = returnedCell.getIndex(userinput);
			String name = getExcelFormulaPosition(indexOfCells);
			
			if (name.equals(" ") || name.equals(""))
			{
				System.out.println(userinput + " = <empty>");
			}
			else
			{
				System.out.println(userinput + " = " + name);
			}
			
		}
		else if (userinput.contains("(") && userinput.contains(")"))
		{
				int firstPar = userinput.indexOf("(");
				int lastPar = userinput.indexOf(")");
				
				equation = userinput.substring(firstPar, lastPar + 1);
				formulaNoPar = userinput.substring(firstPar + 1, lastPar);
				equationSplit = formulaNoPar.split("\\s");
				formulaWithVal = equation;
				
				
				//checking for sum or average
				if (formulaNoPar.contains("sum"))
				{
					double sum = calcSum(formulaNoPar);
					String eqValue = Double.toString(sum);
					if (spaceIndex == 2)
					{

						assignExcelPosition(userinput.substring(0, 2), eqValue);
						return;
					}
					else
					{
						assignExcelPosition(userinput.substring(0, spaceIndex), eqValue);
						return;
					}
					
				}
				
				else if (formulaNoPar.contains("avg"))
				{
					double avg = calcAvg(formulaNoPar);
					String eqValue = Double.toString(avg);
					if (spaceIndex == 2)
					{

						assignExcelPosition(userinput.substring(0, 2), eqValue);
						
						return;
					}
					else
					{
						assignExcelPosition(userinput.substring(0, spaceIndex), eqValue);
						
						return;
					}
				}
				else
				{
					if (equationSplit[1].substring(0,1).equals("-"))
					{
						formulaWithVal += "";
					}
				
					else if (isInteger(equationSplit[1]) == false)
					{
						formulaWithVal = equation.replace(equationSplit[1], valueAtIndex);
					}
					for (int i = 3; i < equationSplit.length; i +=2) 
					{
						if (equationSplit[i].substring(0,1).equals("-"))
						{
							formulaWithVal = formulaWithVal;
						}
						else if (isInteger(equationSplit[i]) == false)
						{
							formulaWithVal = formulaWithVal.replace(equationSplit[i], valueAtIndex);
						}
					}
					
				}
					strictlyName = new Formula(equation);
					formulaUsed = new Formula(formulaWithVal);
				
				
					//getting the formula value
					formulaUsed.EvaluateFormula();
				
					//getting the formula name
					formulaName = strictlyName.getFormula();
				
					double eqValu = formulaUsed.GetFormulaVal();
					String eqValue = Double.toString(eqValu);
					if (spaceIndex == 2)
					{

						assignExcelPosition(userinput.substring(0, 2), eqValue);
						assignExcelFormula(userinput.substring(0,2), formulaName);
					}
					else
					{
						assignExcelPosition(userinput.substring(0, spaceIndex), eqValue);
						assignExcelFormula(userinput.substring(0, spaceIndex), formulaName);
					}
				
				
			}
		else if (userinput.contains("="))
		{
			spaceInd = userinput.lastIndexOf(" ");
			if (userinput.contains("\""))
			{
				//int spaceIndex = userinput.indexOf(" ");
				int indexofFirstQuote = userinput.indexOf("\"");
				int indexofSecondQuote = userinput.lastIndexOf("\"");
				String excelValue = userinput.substring(indexofFirstQuote + 1, indexofSecondQuote);
				if (spaceIndex == 2)
				{

				
             		assignExcelPosition(userinput.substring(0, 2), excelValue);

				
				}
				else
				{
				
				    assignExcelPosition(userinput.substring(0, spaceIndex), excelValue);
				}
			}
			/*else if (isInteger(userinput.substring(spaceInd + 1)) == false)
			{
				System.out.print("Error Message: Input a string or integer");
				return;
			}
			*/
			else
			{
				
				int indexEqual = userinput.indexOf("=");
				String excelValue = userinput.substring(indexEqual + 2, userinput.length()) + ".0";
				//int spaceIndex = userinput.indexOf(" ");
					if (spaceIndex == 2)
					{
						assignExcelFormula(userinput.substring(0,2), "");
						
						assignExcelPosition(userinput.substring(0, 2), excelValue);
						updateFormulas(userinput.substring(0,2), excelValue);
					}
					else
					{
						assignExcelFormula(userinput.substring(0,spaceIndex), "");
						
						assignExcelPosition(userinput.substring(0, 2), excelValue);
						updateFormulas(userinput.substring(0, spaceIndex), excelValue);
					}
					
			}
		}

				/* */
		else if (userinput.equals("clear"))
		{
			Sheet.GetCells().clearWhole();
		}
		else if (userinput.substring(5,6).equals(" ") && userinput.substring(0,5).equals("clear"))
		{
			String coords = userinput.substring(6, userinput.length());
			Sheet.GetCells().clearSpecificCell(coords);
		}
		else 
		{
			System.out.println("Error Message: Try a new input please");
		}

	}
		
	public void displayHelp()
	{
		System.out.println();
		System.out.println("-----------------HELP-----------------");
		System.out.println("print - displays the entire spreadsheet with updated contents");
		System.out.println("exit - exits the program");
		System.out.println("to fill a cell - type in a specified one enter the value you want to put in it");
		System.out.println("to clear the spreadsheet - type in clear");
		System.out.println("to clear a specific cell - type in the name and clear");
		System.out.println("to do arithmetic operations - type in parentheses before and after the equation");
		System.out.println("to do arithmetic operations with cells - type in parentheses and the cell you want to do the operation with");
		System.out.println("to find the avg and sum of cells - type in the avg or sum first and a dash to separate the specific cells");
		System.out.println();
	}
	
	public void assignExcelFormula(String coords, String formula)
	{
		int index = Sheet.GetCells().getIndex(coords);
		Sheet.GetCells().setForm(index, formula);
	}
	public void assignExcelPosition(String coords, double excelValue)
	{	
		int index = Sheet.GetCells().getIndex(coords);
		Sheet.GetCells().setCellVal(index, excelValue);
	}
	public void assignExcelPosition(String coords, String excelValue)
	{	
		int index = Sheet.GetCells().getIndex(coords);
		Sheet.GetCells().setCellVal(index, excelValue);
		//Sheet.GetCells().setForm(index, formulaName);
		//if (isInteger(Sheet.GetCells().getCellVal(index)) == false)
		//{
		
		//}
		/*else
		{
			double dubexcelVal = Double.parseDouble(excelValue);
			Sheet.GetCells().setCellVal(index, dubexcelVal);
		
		}*/
		
	}
	public String getExcelPosition(int index)
	{
		String cellVal = Sheet.GetCells().getCellVal(index);
		return cellVal;
	}
	public String getExcelFormulaPosition(int index)
	{
		String cellFormula = Sheet.GetCells().getCellFormula(index);
		return cellFormula;
	}
	public boolean isInteger(String str) 
	{
	    int size = str.length();

	    for (int i = 0; i < size; i++) 
	    {
	        if (!Character.isDigit(str.charAt(i))) 
	        {
	        	//TEST THIS
	        	int index = Sheet.GetCells().getIndex(str);
	        	valueAtIndex = Sheet.GetCells().getCellVal(index);
	            return false;
	        }
	    }

	    return size > 0;
	}
	public void updateFormulas(String coords, String updateToThisValue)
	{
	
		for (int i = 0; i < Sheet.GetCells().groupCell.length; i++)
		{
			if (Sheet.GetCells().groupCell[i].formula.contains(coords))
			{

				String newformulaname = Sheet.GetCells().groupCell[i].GetFormula();
				newformulaname = newformulaname.substring(1,newformulaname.length()-1);
				String formulaWithValue = newformulaname;
				String[] splittednewformula = formulaWithValue.split("\\s");
				//String groupCellcoords = Sheet.GetCells().groupCell[i].getCoords(i);
				
				
				
				for (int j = 1; j < splittednewformula.length; j +=2) 
				{
					if (splittednewformula[j].substring(0,1).equals("-"))
					{
						;
					}
					else if (isInteger(splittednewformula[j]) == false)
					{
						int index = Sheet.GetCells().getIndex(splittednewformula[j]);
						String aval = Sheet.GetCells().getCellVal(index);
						formulaWithValue = formulaWithValue.replace(splittednewformula[j], aval);
					}
				}
				
				
				formulaUsed = new Formula(formulaWithValue);
				
				//getting the formula value
				formulaUsed.EvaluateFormula2();
				double val = formulaUsed.GetFormulaVal();
				Sheet.GetCells().groupCell[i].SetName(Double.toString(val));
				Sheet.GetCells().groupCell[i].setValue(val);
				
				//				return formulaUsed.GetFormulaVal();
			}
		}
//		return val;
	}
	public double calcSum(String equ)
	{
		int indexOfDash = equ.indexOf("-");
		int indexOfM = equ.indexOf("m");
		String firstCoord = equ.substring(indexOfM + 2,indexOfDash - 1);
		String secondCoord = equ.substring(indexOfDash + 2, equ.length()-1);
		int index = Sheet.GetCells().getIndex(firstCoord);
		int secondIndex = Sheet.GetCells().getIndex(secondCoord);
		String firstVal = Sheet.GetCells().getCellVal(index);
		String secondVal = Sheet.GetCells().getCellVal(secondIndex);
		
		double theSum = Double.parseDouble(firstVal) + Double.parseDouble(secondVal);
		
		return theSum;
	}
	public double calcAvg(String equ)
	{
		int indexOfDash = equ.indexOf("-");
		int indexOfG = equ.indexOf("g");
		String firstCoord = equ.substring(indexOfG + 2,indexOfDash - 1);
		String secondCoord = equ.substring(indexOfDash + 2, equ.length() - 1);
		int index = Sheet.GetCells().getIndex(firstCoord);
		int secondIndex = Sheet.GetCells().getIndex(secondCoord);
		String firstVal = Sheet.GetCells().getCellVal(index);
		String secondVal = Sheet.GetCells().getCellVal(secondIndex);
		
		double theAvg = (Double.parseDouble(firstVal) + Double.parseDouble(secondVal)) / 2;
		return theAvg;
	}

}

