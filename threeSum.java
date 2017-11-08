
public class threeSum
{
	public static void main(String[] args)
	{
		int data[] = {1,2,3,4,5,6,7,8,9,-1,-2,-3,-4,-5,-6,-8,-10,1,2,3,4,5,6,7,4,3,4,3,2,2,};
		sumIt(data);
				
	}
	public static void sumIt(int[] data)
	{
		System.currentTimeMillis();
		int count = 0;
		for (int i = 0;  i < data.length; i++)
			for (int j = 0; j < i; j++)
				for (int k = 0; k < j; k++)
				{
					if (data[i] + data[j] + data[k] == 0)
					{
						count++;
					}
				}
		System.currentTimeMillis();
		System.out.print(count);
	}

}
