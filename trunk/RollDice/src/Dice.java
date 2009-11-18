/**
 * @author J.A. Simmons V
 * @version 1.0 17Nov2009
 * 
 * This is a class to build a single die and all the methods needed for it.
 */

import java.util.Random;
import javax.swing.*;
import sun.audio.*;
import java.io.*;

public class Dice
{	
	//Constructor
	public Dice()
	{
		
	}//end constructor */
	
	//method that will return a random number between 1 and 6
	public int rollDice()
	{
		int face;
		Random randomNumber = new Random();
		face = 1+ randomNumber.nextInt(6);
		return face;		
	}//end method rollDice */
	
	//method that will accept an integer and return an image icon coorsponding to 
	//that integer
	public ImageIcon getFace(int diceNum)
	{
		ImageIcon diceFace;
		ImageIcon[] arryDiceFace = new ImageIcon[ 6 ];
		arryDiceFace[0]= new ImageIcon ( getClass().getResource("./dice1.jpg"));
		arryDiceFace[1]= new ImageIcon ( getClass().getResource("./dice2.jpg"));
		arryDiceFace[2]= new ImageIcon ( getClass().getResource("./dice3.jpg"));
		arryDiceFace[3]= new ImageIcon ( getClass().getResource("./dice4.jpg"));
		arryDiceFace[4]= new ImageIcon ( getClass().getResource("./dice5.jpg"));
		arryDiceFace[5]= new ImageIcon ( getClass().getResource("./dice6.jpg"));
		diceFace = arryDiceFace[diceNum-1];
		return diceFace;
	}//end method diceFace */
	
	//method that will play the sound of dice rolling and a dissapointed sound
	//for when a 7 is rolled
	public AudioStream getSound(int clipNum) throws IOException
	{
		
		/*InputStream in1 = new FileInputStream("diceRoll.au");
		InputStream in2 = new FileInputStream("disappointment.wav");*/
		InputStream in1 = new FileInputStream("C:\\temp\\diceRoll.au");
		InputStream in2 = new FileInputStream("C:\\temp\\disappointment.wav");
		AudioStream[] sound = new AudioStream[2];
		sound[0] = new AudioStream(in1);
		sound[1] = new AudioStream(in2);
		return sound[clipNum];
		
		}//end method getSound */
	

}//end class Dice */
