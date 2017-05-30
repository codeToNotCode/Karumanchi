package arrays;

import java.util.Arrays;

public class RoomBookings {
    public boolean hotel(int[] arrive, int[]depart, int K) {
        boolean roomsAvailable = true;
        Arrays.sort(arrive);
        Arrays.sort(depart);
        int numOfGuests = 0;
        for(int i = 0,j=0; i<arrive.length&&j<depart.length;){
            if(arrive[i] < depart[j]){
                i++;
                numOfGuests++;
            }
            else if(arrive[i] > depart[j]){
                j++;
                numOfGuests--;
            }else{
                i++;
                j++;
            }
            //At any day, if the number of guests present in the hotel
            //is greater than the number of rooms available,
            //No more reservations can be made!
            if(numOfGuests > K)
                roomsAvailable = false;
        }
        
        return roomsAvailable;
    }
    
    public static void main(String[] args) {
		RoomBookings rb = new RoomBookings();
		int arrive[] = {11, 24, 36, 15, 16, 23, 20, 19};
		int depart[] = {14, 32, 67, 25, 21, 54, 61, 34};
		System.out.println(rb.hotel(arrive, depart, 4));
	}
}
