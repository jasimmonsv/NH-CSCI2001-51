/**
 *  
* @(#)CAIController.java 
* 
* @author J.A. Simmons V
* @version 1.00 7Oct2009 
* 
* CSci 2001 01 Fall 2009 
* 
*/
import javax.swing.JLabel;

public class CAIController 
{
	//declarations
	
	
	public static boolean guessGame(int guessAnswer,int guessNum)
	{
		boolean answerCorrect;
		answerCorrect = false;
		if (CAIMainView.timesGuessed < 9) //using 9 since arrays start at 0
		{
			if (guessNum < guessAnswer)
			{
				CAIMainView.wrongAnswers.add(new JLabel(guessNum+" is too low. Try Again."));		
				answerCorrect = false;
			}
			else if (guessNum > guessAnswer)
			{
				CAIMainView.wrongAnswers.add(new JLabel(guessNum+" is too high. Try Again."));
				answerCorrect = false;
			}
			else if (guessNum == guessAnswer)
			{
				CAIMainView.wrongAnswers.add(new JLabel(guessNum+" is Correct! You either know the secret or got lucky"));
				answerCorrect = true;
			}
		}
		else if(CAIMainView.timesGuessed >= 9)//using 9 since arrays start at 0
		{
			if (guessNum != guessAnswer)
			{
				CAIMainView.wrongAnswers.add(new JLabel(guessNum+" is incorrect. You should be able to do better."));
				answerCorrect = true;
			}
			else if (guessNum == guessAnswer)
			{
				CAIMainView.wrongAnswers.add(new JLabel(guessNum+" is Correct! Aha! You know the secret!"));
				answerCorrect = true;	
			}
		}
			
	CAIMainView.answerPane.add(CAIMainView.wrongAnswers.get(CAIMainView.timesGuessed));
	CAIMainView.timesGuessed+=1;
	return answerCorrect;
	}//end method guessGame
	
	public static void mathGame()
	{
		
	}//end method mathGame */

}
