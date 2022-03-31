//Cooper Coleman
//Analysis of Algorithms
//5-1-20
//Project 4

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
public class Vigenere 
{
	public String readFile(String inputFile) throws Exception
	{
		String text = "";
		File input = new File(inputFile);
		Scanner infile = new Scanner(input);
		
		text = infile.nextLine();
		
		while(infile.hasNextLine())
		{
			text = text + "\n" + infile.nextLine();
		}
		infile.close();
		
		return text;
	}
	
	public void vigenereEncrypt(String inputFile, String outputFile, String key) throws Exception
	{
		String text = readFile(inputFile);
		String cipherText = "";
		
		text = text.toUpperCase();
		String Key = key.toUpperCase();
		
		int temp;
		for(int i = 0; i < Key.length(); i++)
		{
			if(Character.isLetter(text.charAt(i)))
			{
				temp = ((text.charAt(i) + Key.charAt(i)) % 26) + 'A';
				
				cipherText = cipherText + (char) temp;
			}
			else
			{
				cipherText = cipherText + text.charAt(i);
			}
			
		}
		
		FileWriter output = new FileWriter(outputFile);
		output.write(cipherText);
		output.close();
		
		System.out.println("Encryption Complete");
	}
	
	public void vigenereDecrypt(String inputFile, String outputFile, String key) throws Exception
	{
		String text = readFile(inputFile);
		String plainText = "";
		
		String Key = key.toUpperCase();
		
		int temp;
		for(int i = 0; i < text.length(); i++)
		{
			if(Character.isLetter(text.charAt(i)))
			{
				temp = (((text.charAt(i) - Key.charAt(i)) + 26) % 26) + 'A';
				
				plainText = plainText + (char) temp;
			}
			else
			{
				plainText = plainText + text.charAt(i);
			}

		}
		
		
		FileWriter output = new FileWriter(outputFile);
		output.write(plainText);
		output.close();
		
		System.out.println("Decryption Complete");
	}
	
	public String keyLonger(String key, String inputFile) throws Exception
	{
		String text = readFile(inputFile);
		
		int n = text.length();
		
		for(int i = 0; ; i++)
		{
			if(n == i)
			{
				i = 0;
			}
			if(key.length() == text.length()) 
			{
				break;
			}
			key = key+ (key.charAt(i));
		}
		
		return key;
	}
	
}
