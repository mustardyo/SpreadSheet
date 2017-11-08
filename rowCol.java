public class rowCol 
{
	//un-static this later
	static String letters[];
public static void main(String[] args) {
    String s = "X";
    int totalColumns = 8;
    int totalRow = 10;
    letters = new String[]{"A", "B", "C", "D", "E", "F", "G"};
    //first space
    for (int i = 0; i < 12; i++)
    {
    	System.out.print(" ");
    }
    System.out.print("|");
    
    //7 times i want to run the first row
    for (int i = 0; i < letters.length; i++)
    {
    	//two for loops for each of the printing spaces
    	for (int j = 0; i < 5; j++)
    	{
    		System.out.print(" ");
    	}
    	//print the letter
    	System.out.print(letters[i]);
    	
    	//second for loop for the printing of the second set of spaces
    	for (int k = 0; k < 6; k++)
    	{
    		System.out.print(" ");
    	}
    	System.out.print("|");
    }


    /*colums(s, totalColumns);
    rows(s, totalColumns, totalRow);
    colums(s, totalColumns);
	*/

}

private static void colums(String cs, int cc) {
    for (int i = 0; i < cc; i++) {
        System.out.print(cs);
    }

}

private static String whitespace(int tc) {
    String ws = " ";
    for (int i = 1; i < tc - 2; i++) {
        ws += " ";
    }
    return ws;
}

private static void rows(String rs, int tc, int tr) {
    System.out.println();
    for (int i = 0; i < tr - 2  ; i++) {
        System.out.println(rs + whitespace(tc) + rs);
    }
}
}

