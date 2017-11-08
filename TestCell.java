import static org.junit.Assert.*;

import org.junit.Test;


public class TestCell 
{
	spreadsheet testSheet;
	String letters[];
	cells testCells;
	String equation;
	
	@Test
	public void CellUnitTest6()
	{
		spreadsheet testSheet = new spreadsheet(10,10);
		cells testingCells = new cells(10, 10);
		classCalling callTest = new classCalling(testSheet, testingCells);
		assertTrue(callTest.isInteger("10"));
	}
	
	@Test
	public void CellUnitTest9()
	{
		spreadsheet testSheet = new spreadsheet(10,10);
		cells testingCells = new cells(10, 10);
		classCalling callTest = new classCalling(testSheet, testingCells);
		callTest.enterCommand("A1 = -1");
		callTest.enterCommand("A2 = 1");
		callTest.enterCommand("A3 = ( sum A1 - A2 )");
		int ind = testSheet.GetCells().getIndex("A3");
		String val = testSheet.GetCells().getCellVal(ind);
		Double value = Double.parseDouble(val);
		testSheet.GetCells().groupCell[ind].setValue(value);
		//System.out.println(testingCells.groupCell[ind].GetValue());
		assertEquals(0.0, testingCells.groupCell[ind].GetValue(), 0.01);
	}
	
	@Test
	public void CellUnitTest8()
	{
		spreadsheet testSheet = new spreadsheet(10,10);
		cells testingCells = new cells(10, 10);
		classCalling callTest = new classCalling(testSheet, testingCells);
		callTest.enterCommand("A1 = -1");
		callTest.enterCommand("A2 = 1");
		callTest.enterCommand("A3 = ( avg A1 - A2 )");
		int ind = testSheet.GetCells().getIndex("A3");
		String val = testSheet.GetCells().getCellVal(ind);
		Double value = Double.parseDouble(val);
		testSheet.GetCells().groupCell[ind].setValue(value);
		//System.out.println(testingCells.groupCell[ind].GetValue());
		assertEquals(0.0, testingCells.groupCell[ind].GetValue(), 0.01);
	}
	
	@Test
	public void CellUnitTest7()
	{
		spreadsheet testSheet = new spreadsheet(10,10);
		cells testingCells = new cells(10, 10);
		classCalling callTest = new classCalling(testSheet, testingCells);
		boolean testbool = callTest.isInteger("10000");
		assertTrue(testbool);
	}
	
	@Test
	public void CellUnitTest3()
	{
		Formula formulaTest = new Formula("( 1 * 5 + 3 * 4 )");
		formulaTest.EvaluateFormula();
		assertEquals(32.0, formulaTest.GetFormulaVal(), 0.01);
	}
	
	@Test
	public void CellUnitTest4()
	{
		Formula formulaTest = new Formula("( 5 + 3 / 4 )");
		formulaTest.EvaluateFormula();
		assertEquals(2.0, formulaTest.GetFormulaVal(), 0.01);
	}
	

	@Test
	public void CellUnitTest1()
	{
		Cell cellTest = new Cell();
        assertEquals("", cellTest.GetName());
	}
	
	@Test
	public void CellUnitTest2() 
	{
         Cell cellTest = new Cell();
         cellTest.SetName("3.0");
         assertEquals("3.0", cellTest.GetName());
	}

}
