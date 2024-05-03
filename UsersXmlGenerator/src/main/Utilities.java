package main;

import java.util.List;
import java.util.Random;

public class Utilities
{
	public static boolean getRandomBoolean()
	{
		Random random = new Random();
		
		return random.nextBoolean();
	}
	
	public static <T> T getRandomListElement(List<T> list)
	{
		if (list == null || list.isEmpty())
		{
			System.err.println("Error: list is null or empty.");
			
            return null;
        }
		
		Random random = new Random();
        int index = random.nextInt(list.size());
        
        return list.get(index);
	}
	
	public static int getRandomNumber(int min, int max)
	{
		Random random = new Random();
		int range = max - min + 1;
		
        return random.nextInt(range) + min;
	}
}