package main;

import main.DataManager.DataType;

public class XmlGenerator
{
	public void generateXml()
	{
		DataManager dataHolder = new DataManager();
		dataHolder.initialize();
		LoginGenerator loginGenerator = new LoginGenerator();
		XmlExporter xmlExporter = new XmlExporter();
		xmlExporter.startFile();
		
		for (int i = 0; i < Settings.getRecordsCount(); i++)
		{
			boolean isMale = Utilities.getRandomBoolean();
			String name = dataHolder.getRandomData(isMale ? DataType.NameMale : DataType.NameFemale);
			String surname = dataHolder.getRandomData(DataType.Surname);
			String login = loginGenerator.getRandomLogin(name, surname);
			
			xmlExporter.addUser(name, surname, login);
			
			System.out.println(i + 1 + "/" + Settings.getRecordsCount());
		}
		
		xmlExporter.finishAndExportFile();
	}
}
