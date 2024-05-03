package main;

import java.io.FileWriter;
import java.io.IOException;

public class XmlExporter
{
	private FileWriter fileWriter;
	
	public void startFile()
	{
		try
		{
            fileWriter = new FileWriter("Users.xml");
            
            fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n");
            fileWriter.write("<users>\n");
        }
		catch (IOException e)
		{
            e.printStackTrace();
        }
	}
	
	public void addUser(String name, String surname, String login)
	{
		try
		{
            fileWriter.write("<user>\n");
            fileWriter.write("    <name>" + name + "</name>\n");
            fileWriter.write("    <surname>" + surname + "</surname>\n");
            fileWriter.write("    <login>" + login + "</login>\n");
            fileWriter.write("</user>\n");
        }
		catch (IOException e)
		{
            e.printStackTrace();
        }
	}
	
	public void finishAndExportFile()
	{
		try
		{
			fileWriter.write("</users>\n");

			fileWriter.close();
        }
		catch (IOException e)
		{
            e.printStackTrace();
        }
	}
}
