import java.util.Scanner;

public class textExcel
{
	classCalling projectOne;
	static int rows = 0;
	static int cols = 0;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int k = 0;
		while ( k < 1)
		{
			System.out.print("How many rows do you want your spreadsheet to be: ");
			String rowInput = sc.next();
			if (isInteger(rowInput) == false || rowInput.substring(0,1).equals("-"))
			{
				System.out.println("Error Message: Input an integer please");
				//forRows();
			}
			else
			{
				rows = Integer.parseInt(rowInput);
				k++;
			}
		}
		while ( k < 2 )
		{
			System.out.print("How many columns do you want your spreadsheet to be (1-26): ");
			cols = sc.nextInt();
			if (cols > 26)
			{
				System.out.println("Error Message: Choose a smaller number");
				//forCols();
			}
			else
			{
				k++;
			}
		}
		spreadsheet mySpreadsheet = new spreadsheet(rows, cols);
		cells myCells = new cells(rows, cols);
		classCalling projectOne = new classCalling(mySpreadsheet, myCells);
		String command;
		command = enterCommand();
		while(!command.equals("exit")) 
		{
			if (command.length() == 2 || command.length() == 3)
			{
				projectOne.enterCommand(command);
				command = enterCommand();
			}
			else if (command.equals("print"))
			{
				projectOne.enterCommand(command);
				command = enterCommand();
			}
			//else if (command[0].equals("") && command[command.length()].equals)
			//{
			//	projectOne.enterCommand(command);
				//command = enterCommand();
			//}
			else
			{
				projectOne.enterCommand(command);
				command = enterCommand();
			}
		}	
		System.out.println("goodbye!");
    }
	public static boolean isInteger(String str) 
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
	public static void forRows()
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.print("How many rows do you want your spreadsheet to be: ");
		rows = sc.nextInt();
		
	}
	public static void forCols()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("How many columns do you want your spreadsheet to be (1-26): ");
		cols = sc.nextInt();
	}
    public static String enterCommand()
    {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a command: ");
		String userinput = input.nextLine();
		userinput.toLowerCase();
		/*
		int Indexfirst = userinput.indexOf("\"");
		int IndexLast = userinput.lastIndexOf(("\""));
		if (userinput.substring(5,6).equals("\"") || userinput.substring(6,7).equals("\""))
		{
			String userinputnow = userinput.substring(Indexfirst, IndexLast + 1);
			return userinputnow;
		}
		else
		{
		*/
			return userinput;
		//}
    }

}

