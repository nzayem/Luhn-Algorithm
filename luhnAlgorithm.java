import java.util.Scanner;

public class luhnAlgorithm {

	public static void main(String[] args) {

		// This is a simple implementation of the algorithm, no exception handling
		// Such exceptions are handled in the Banking system project
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter card number, must be 15 digits");
		
		String card = scanner.next();
		
		String[] cardArr = card.split("");
		
		// Converting the String to an array of Integers
		
		int[] cardNumber = new int[15];
		
		for (int i = 0; i < 15; i++) {
			
			cardNumber[i] = Integer.parseInt(cardArr[i]);
			
		}
		
		//Multiply even digits by 2 and subtract 9
		
		for (int i = 0; i < cardNumber.length; i++) {
					
			if (i % 2 == 0) {
				
				cardNumber[i] *= 2;
				
				if (cardNumber[i] > 9) {
					
					cardNumber[i] -= 9;
					
				}
			}
			
		}
		
		// Calculating the Control number 
		
		
		int controlNumber = 0;
		
		for (int i = 0; i < cardNumber.length; i++) {
			
			controlNumber += cardNumber[i];
			
		}
		
		// Calculating the checkSum
		
		int checkSum = 0;
		
		while ((controlNumber + checkSum) % 10 != 0 ) {
			
			checkSum++;

			
		}
		
		System.out.println("CheckSum digit: " + checkSum);
		
		// Adding the checkSum and return the complete card Number
		
		String cardLuhn = "";
		
		if (card.concat(String.valueOf(checkSum)).length() == 16) {
			
			cardLuhn = card.concat(String.valueOf(checkSum));
		}
		
		System.out.println("Resulting Card number according to Luhn Algorithm: " + cardLuhn);
		
		scanner.close();

	}

}
