import java.util.ArrayList;

public class Cell 
{
	String name = "";
	Double value = 0.0;
	String formula = "";
	ArrayList<String> FormulaLinks = new ArrayList<String>();
	String[] formulaSplit;
	
	public Cell()
	{
//		name = new String(" ");
//		value = new Double(0.0);
	}
	public void addFormulaLinks()
	{
		
		
	}
	public void checkFormulaLinks()
	{
		if (FormulaLinks.size() == 0)
		{
			;
		}
		else
		{
			
		}
	}
	public void SetFormula (String userinput)
	{
		formula = userinput;
	}
	public void SetName(String userInput)
	{
		name = userInput;
	}
	public void setValue(Double userInput)
	{
		value = userInput;
	}
	
	public void clearValue()
	{
		value = 0.0;
		name = "";
		
	}
	public String GetName()
	{

		return name;
	}
	
	public void ClearFormula()
	{
		formula = "";
	}
	
	public String GetFormula()
	{
		if (formula.equals((" ")) || formula.equals(""))
		{
			return name;
		}
		else
		{
			return formula;
		}
	}

	public Double GetValue()
	{
		return value;
	}
	public boolean isInteger(String str) 
	{
	    int size = str.length();

	    for (int i = 0; i < size; i++) 
	    {
	        if (!Character.isDigit(str.charAt(i))) 
	        {
	            return false;
	        }
	    }

	    return size > 0;
	}
}
