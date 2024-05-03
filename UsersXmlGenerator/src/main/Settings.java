package main;

public class Settings
{
	public static final int maxResources = 2000;
	
	private static int recordsCount;
	private static int resourcesLimit;
	
	public static int getRecordsCount()
	{
		return recordsCount;
	}
	
	public static void setRecordsCount(int _recordsCount)
	{
		recordsCount = _recordsCount;
	}
	
	public static int getResourcesLimit()
	{
		return resourcesLimit;
	}
	
	public static void setResourcesLimit(int _resourcesLimit)
	{
		resourcesLimit = _resourcesLimit;
	}
}
