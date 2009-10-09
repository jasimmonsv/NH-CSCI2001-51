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
import java.util.Random;
import javax.swing.JLabel;

public class CAIController 
{
	//declarations
	//**N/A**
	
	/*
	 * @param guessAnswer is the correct answer passed 
	 * @param guessNum is the users guess passed
	 */
	public static boolean guessGame(int guessAnswer,int guessNum)
	{
		boolean answerCorrect; //throw away var to pass if answer is correct or not
		answerCorrect = false; //set var just in case. **not needed but will throw warning without.
		
		/*
		 * the guessGame method will determine how many times the user has
		 * guessed, and weither the answer is correct or not.
		 * If user gets the answer on 10th time, that is still a successful situation
		 */
		
		//if the times guessed are not yet 10 executed this if statement
		if (CAIMainView.timesGuessed < 9) //using 9 since arrays start at 0
		{
			if (guessNum < guessAnswer)
			{
				CAIMainView.wrongAnswers.add(new JLabel(guessNum+" is too low. Try Again."));		
				answerCorrect = false;
			}//end if statement */
			else if (guessNum > guessAnswer)
			{
				CAIMainView.wrongAnswers.add(new JLabel(guessNum+" is too high. Try Again."));
				answerCorrect = false;
			}//end else if statement */
			else if (guessNum == guessAnswer)
			{
				CAIMainView.wrongAnswers.add(new JLabel(guessNum+" is Correct! You either know the secret or got lucky"));
				answerCorrect = true;
			}//end else if statement */
		}//end if statment */
		
		//if the times guessed are 10 or greater execute this if statement
		else if(CAIMainView.timesGuessed >= 9)//using 9 since arrays start at 0
		{
			if (guessNum != guessAnswer)
			{
				CAIMainView.wrongAnswers.add(new JLabel(guessNum+" is incorrect. You should be able to do better."));
				answerCorrect = true;
			}//end if statement */
			else if (guessNum == guessAnswer)
			{
				CAIMainView.wrongAnswers.add(new JLabel(guessNum+" is Correct! Aha! You know the secret!"));
				answerCorrect = true;	
			}//end else if statement */
		}//end over 10 else if statement */
			
	CAIMainView.answerPane.add(CAIMainView.wrongAnswers.get(CAIMainView.timesGuessed)); //this will add the last guess to the wrongAnswers ArrayList
	CAIMainView.timesGuessed+=1;//increment times guessed ***increment is after the if statment checks***
	return answerCorrect; //return boolean 1 if answer was answered correctly, 0 if incorrectly
	}//end method guessGame */
	
	
	/*
	 * mathGame will determine if the users guess matches the answer
	 * @param guess is the users guess
	 * @param ans is the actual answer passed to method
	 * 
	 *  TODO Make code more moduler - created seperate method to pass response and boolean ansCorrectFlag 
	 * 
	 */
	public static boolean mathGame(int guess,int ans)
	{
		Random random= new Random(); //initalize throw away random method for different responses
		boolean ansCorrectFlag = false; //returned var if answer was correct or not 1 = correct 0= not correct
		int rand = random.nextInt(4); //initalized var for random responses 
		String outputStr=""; //displayed response added directly to answerMathPane
		
		if (guess == ans)
		{
			ansCorrectFlag = true;
			switch (rand){
			case 1: outputStr = "Very good!";break;
			case 2: outputStr = "Excellent!";break;
			case 3: outputStr = "Nice Work!";break;
			case 4: outputStr = "Keep up the good work!";break;
			}//end correct ans switch */
		}//end correct if statement */
		
		if (guess != ans)
		{
			ansCorrectFlag = false;
			switch (rand){
			case 1: outputStr = "No. Please try again.";break;
			case 2: outputStr = "Wrong. Try once more.";break;
			case 3: outputStr = "Don't give up!";break;
			case 4: outputStr = "No. Keep trying";break;
			}//end incorrect switch */
		}//end incorrect if statement */
		if (CAIMainView.timesGuessedMath >=1)
		{
			ansCorrectFlag = true;
			CAIMainView.txtMathGuess.setEditable(false);
		}//end if statment */
		CAIMainView.answerMathPane.add(new JLabel(outputStr)); //add outputStr directly to answerMathPane
		CAIMainView.timesGuessedMath+=1;//increment times guessed
		return ansCorrectFlag;	
		
	}//end method mathGame */
}//end class CAIController */
