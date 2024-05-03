package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataManager
{
	private List<String> namesMale;
	private List<String> namesFemale;
	private List<String> surnames;
	
	public enum DataType
	{
		NameMale,
		NameFemale,
		Surname
	}
	
	public void initialize()
	{
		namesMale = new ArrayList<>();
		namesFemale = new ArrayList<>();
		surnames = new ArrayList<>();
		
		loadData(namesMale, "names_male.txt");
		loadData(namesFemale, "names_female.txt");
		loadData(surnames, "surnames.txt");
	}
	
	private void loadData(List<String> list, String filename)
	{
		ClassLoader classLoader = DataManager.class.getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(filename);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        int count = 0;
        try
        {
            String line;
            while (count < Settings.getResourcesLimit() && (line = bufferedReader.readLine()) != null)
            {
            	list.add(line);
            	
            	count++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (bufferedReader != null)
                {
                    bufferedReader.close();
                }
                if (inputStream != null)
                {
                    inputStream.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
	}
	
	public String getRandomData(DataType dataType)
	{
		List<String> dataList = null;
		switch (dataType)
		{
			case NameMale:
				dataList = namesMale;
				break;
			case NameFemale:
				dataList = namesFemale;
				break;
			case Surname:
				dataList = surnames;
				break;
		}
		
        return Utilities.getRandomListElement(dataList);
	}
}
