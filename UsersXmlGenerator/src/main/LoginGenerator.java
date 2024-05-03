package main;

public class LoginGenerator
{
	public String getRandomLogin(String name, String surname)
	{
		String login = "";
		
		boolean bothNameAndSurname = Utilities.getRandomBoolean();
		if (bothNameAndSurname)
		{
			boolean nameFirst = Utilities.getRandomBoolean();
			login += nameFirst ? name : surname;
			
			boolean withUnderscore = Utilities.getRandomBoolean();
			if (withUnderscore)
			{
				login += "_";
			}
			
			login += nameFirst ? surname : name;
			
			boolean withNumbers = Utilities.getRandomBoolean();
			if (withNumbers)
			{
				if (withUnderscore)
				{
					login += "_";
				}
				
				int numbersAmount = Utilities.getRandomNumber(2, 4);
				for (int i = 0; i < numbersAmount; i++)
				{
					login += Utilities.getRandomNumber(0, 9);
				}
			}
		}
		else
		{
			boolean onlyName = Utilities.getRandomBoolean();
			login += onlyName ? name : surname;
			
			int numbersAmount = Utilities.getRandomNumber(2, 4);
			for (int i = 0; i < numbersAmount; i++)
			{
				login += Utilities.getRandomNumber(0, 9);
			}
		}
		
		login = login.toLowerCase();
		
		return login;
	}
}
