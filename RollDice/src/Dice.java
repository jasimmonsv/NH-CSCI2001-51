import java.applet.AudioClip;
import java.util.Random;
import javax.swing.*;
import sun.audio.*;
import java.io.*;

public class Dice
{	
	//Constructor
	public Dice()
	{
		int[] diceNum;
		ImageIcon[] diceFace;
		
	}//end constructor */
	
	public int rollDice()
	{
		int face;
		Random randomNumber = new Random();
		face = 1+ randomNumber.nextInt(6);
		return face;		
	}//end method rollDice */
	
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
	
	public AudioStream getSound(int clipNum) throws IOException
	{
		//TODO add try block
		try{
		InputStream in1 = new FileInputStream("./diceRoll.wav");
		InputStream in2 = new FileInputStream("./disappointment.wav");
		}catch{}
		AudioStream[] sound = new AudioStream[2];
		sound[0] = new AudioStream(in1);
		sound[1] = new AudioStream(in2);
		return sound[clipNum];
		
		}//end method getSound */
	

}//end class Dice */
