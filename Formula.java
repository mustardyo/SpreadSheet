import java.util.HashMap;
import java.util.Map;

public class Formula 
{
	String realFormula;
	String formulaNoPar;
	double formulaVal;
	String[] result;
	
	public Formula(String formula)
	{
		realFormula = formula;
		formulaNoPar = formula.substring(1,formula.length()-1);
		formulaVal = 0.0;
		
		result = formulaNoPar.split("\\s");	
		
	}
	public String getFormula()
	{
		return realFormula;
	}
	public void EvaluateFormula()
	{
		double left = Double.parseDouble(result[1]);
		int i = 2;
			while (i < result.length)
			{
				if (result[i].equals("+"))
				{
					double right = Double.parseDouble(result[i + 1]);
					left = (left + right);
				}
				else if (result[i].equals("-"))
				{
					double right = Double.parseDouble(result[i + 1]);
					left = (left - right);
				}
				else if (result[i].equals("*"))
				{
					double right = Double.parseDouble(result[i + 1]);
					left = (left * right);
				}
				else if (result[i].equals("/"))
				{
					double right = Double.parseDouble(result[i + 1]);
					left = (left / right);
				}
				i+=2;
			}

			formulaVal = left;
		
	}
	public void EvaluateFormula2()
	{
		if (result.length == 1)
		{
			formulaVal = Double.parseDouble(result[0]);
			return;
		}
		double left = Double.parseDouble(result[0]);
		int i = 1;
			while (i < result.length)
			{
				if (result[i].equals("+"))
				{
					double right = Double.parseDouble(result[i + 1]);
					left = (left + right);
				}
				else if (result[i].equals("-"))
				{
					double right = Double.parseDouble(result[i + 1]);
					left = (left - right);
				}
				else if (result[i].equals("*"))
				{
					double right = Double.parseDouble(result[i + 1]);
					left = (left * right);
				}
				else if (result[i].equals("/"))
				{
					double right = Double.parseDouble(result[i + 1]);
					left = (left / right);
				}
				i+=2;
			}

			formulaVal = left;
		
	}
	public double GetFormulaVal()
	{
		return formulaVal;
	}
	
}
