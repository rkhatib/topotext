package lb.edu.aub.cmps;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class GenerateWordCloud implements GenerateWordCloudInteface 
{

	public GenerateWordCloud(String toCloud) 
	{
		String head= "<!DOCTYPE html> <html> <head><title>Word CLoud</title> <meta " +
				"name=\"viewport\" content=\"initial-scale=1.0, " +
				"user-scalable=no\" /> <form action=\"http://www." +
				"wordle.net/advanced\" method=\"POST\"> <textarea" +
				" name=\"text\" style=\"display:none\">";
		
		String tail= "</textarea> <input type=\"submit\" value=\"Press To See Your Amazing Word Cloud\" > </form> " +
				"</head> <body> <div id=\"map-canvas\"/> </body> </html>";
		
		String all= head+ toCloud + tail;
		
		try 
		{
			File htmlToOpen = new File("Files/cloud.html");
			PrintStream out= new PrintStream(htmlToOpen);
			out.print(all);
			out.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

	public void generateWordCloud(File f) 
	{		
		//opening the browser
		try 
		{
			Desktop.getDesktop().browse(f.toURI());
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
