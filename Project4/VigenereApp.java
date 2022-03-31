package vgciph;
//Cooper Coleman
//Analysis of Algorithms
//5-1-20
//Project 4
import java.util.Scanner;
public class VigenereApp 
{
	public static void main(String args[]) throws Exception
	{
		System.out.print("Are you encrypting or decrypting? 1 for encrypting or 2 for decrypting ");
		Scanner keyboard = new Scanner(System.in);
		int action;
		
		action = keyboard.nextInt();
		
		String inputFile;
		String outputFile;
		String encryptionKey;
		
		System.out.print("Input file name: ");
		inputFile = keyboard.next();
		System.out.print("Output file name: ");
		outputFile = keyboard.next();
		System.out.print("Encryption Key: ");
		encryptionKey = keyboard.next();
		
		Vigenere cipher = new Vigenere();
		
		
		encryptionKey = cipher.keyLonger(encryptionKey, inputFile);
		
		if(action == 1)	//ENCRYPTING
		{
			cipher.vigenereEncrypt(inputFile, outputFile, encryptionKey);
		}
		else	//DECRYPTING
		{
			cipher.vigenereDecrypt(inputFile, outputFile, encryptionKey);
		}
		
		
	}
}
