
public class SeatData 
{
	public static Boolean[] flightSeat;
	
	public SeatData()
	{
		flightSeat = new Boolean[10];
		for (int i=0;i<=9;i++)
		{
			flightSeat[i] = false;
		}
		
	}//end initSeats method
	
	/*
	 * @param returns false if all the seats are occupied in Economy class
	 */
	public static boolean vacantSeatsExistEcon()
	{
		boolean isSeatAvailable = true;
		for (int i=5; i<=9;i++)
		{
			if (flightSeat[i]==false) return isSeatAvailable;
		}//end for loop
		isSeatAvailable=false;
		return isSeatAvailable;
	}//end seatOccupied method */
	
	/*
	 * @param returns false if all the seats are occupied in First class
	 */
	public static boolean vacantSeatsExistFirstClass()
	{
		boolean isSeatAvailable = true;
		for (int i=0; i<=4;i++)
		{
			if (flightSeat[i]==false) return isSeatAvailable;
		}//end for loop
		isSeatAvailable=false;
		return isSeatAvailable;
	}//end seatOccupied method */

}//end class SeatData
