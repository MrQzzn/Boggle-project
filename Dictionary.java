import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary 
{
	/*public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<String>rawData = loadStrings("Boggle.txt");
		String filename = "Boggle.txt";
		Scanner scan = new Scanner (new File (filename)).useDelimiter("\\\\");
		String word;
		Scanner inputs = new Scanner(System.in);

		ArrayList<String> wordList = new ArrayList<String>();
		
		while (scan.hasNext()) 
		{
            word = scan.next();
            wordList.add(word);
            
        }
		
		for(int i = 0; i<rawData.size(); i++)
		{
			System.out.println(wordList.get(i));
		}
		for(int i = 0; i < rawData.size(); i++)
		{
			System.out.print("Enter a word ");
			String a = inputs.nextLine();
			a+="\\";
			if(rawData.contains(a))
				System.out.println("Found");
			else
				System.out.println("Does not exist");
		}
		
	}
	*/
	private ArrayList<String>rawData = new ArrayList<String>();
	
	public Dictionary(String filename)
	{
		rawData = loadStrings(filename);
	}
	public boolean isWord(String s)
	{
		for(int i = 0; i < rawData.size(); i++)
		{
			s+="\\";
			if(rawData.contains(s))
				return true;
		}
		return false;
		
	}
	private static ArrayList<String> loadStrings(String fileName) 
	{
		String line = "";
		ArrayList<String> toReturn = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) 
		{

			while ((line = br.readLine()) != null) 
			{
				toReturn.add(line);
			}

		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return toReturn;
	}
	
	    
	 
}
