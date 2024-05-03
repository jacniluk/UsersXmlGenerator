package main;

public class Main
{
	public static void main(String[] args)
	{
		boolean argumentsValidation = validateArgument(args);
		if (argumentsValidation == false)
		{
			return;
		}
		
		Settings.setRecordsCount(Integer.parseInt(args[0]));
		Settings.setResourcesLimit(args.length > 1 ? Integer.parseInt(args[1]) : Settings.maxResources);
		
		XmlGenerator xmlGenerator = new XmlGenerator();
		xmlGenerator.generateXml();
		
		System.out.println("Finish.");
	}
	
	private static boolean validateArgument(String[] args)
	{
		if (args.length == 0 || args.length > 2 || areInt(args) == false)
		{
			System.out.println("Enter the given arguments:");
			System.out.println("1: Records Count (int) - the number of generated data in the XML file");
			System.out.println("2: [optional] Resources Limit (int) - maximum amount of resource draw pool (max " + Settings.maxResources + ")");
			
			return false;
		}
		
		return true;
	}
	
	private static boolean areInt(String[] args)
	{
		for (int i = 0; i < args.length; i++)
		{
			try
		    {
		        Integer.parseInt(args[i]);
		    }
		    catch (NumberFormatException e)
		    {
		        return false;
		    }
		}
		
		return true;
	}
}
