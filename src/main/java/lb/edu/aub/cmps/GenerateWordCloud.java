package lb.edu.aub.cmps;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JFileChooser;

import edu.stanford.nlp.io.ExtensionFileFilter;

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
			JFileChooser fileChooser = new JFileChooser();
			String SAVE_AS = ".html";
			ExtensionFileFilter pFilter = new ExtensionFileFilter(SAVE_AS);
			fileChooser.setFileFilter(pFilter);
			int status = fileChooser.showSaveDialog(null);

			if (status == JFileChooser.APPROVE_OPTION) {
				File f = fileChooser.getSelectedFile();

				String fileName = f.getAbsolutePath();
				if (!fileName.endsWith(SAVE_AS)) {
					f = new File(fileName + SAVE_AS);
				}
			File htmlToOpen = new File(f.getAbsolutePath());
			
			PrintStream out= new PrintStream(htmlToOpen);
			out.print(all);
			out.close();
			try {
				Desktop.getDesktop().browse(htmlToOpen.toURI());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
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
