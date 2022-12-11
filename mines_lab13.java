import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class mines_lab13 
{
	private ArrayList<Integer> values;
	
	public void readData(String filename)
	{
		values = new ArrayList<Integer>();
		
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(filename));
			String inn;
			
			while ((inn = input.readLine()) != null)
			{
				values.add(Integer.parseInt(inn));
			}
			input.close();
		}
		catch (Exception e)
		{
			
		}
	}
	
	public long getTotalCount()
	{
		return values.stream().count();
	}
	
	public long getOddCount()
	{
		return values.stream().filter(value -> value % 2 != 0).count();
	}
	
	public long getEvenCount()
	{
		return values.stream().filter(value -> value % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount()
	{
		return values.stream().filter(value -> value > 5).count();
	}
	
	public Integer[] getResult1()
	{
		return values.stream().filter(value -> value % 2 == 0 && value > 5 && value < 50).sorted().toArray(Integer[]::new);
	}
	
	public Integer[] getResult2()
	{
		return values.stream().map(value -> value * value * 3).limit(50).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3()
	{
		return values.stream().filter(value -> value % 2 != 0).map(value -> value * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
}
