import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
//---------------------------------------------------------Variable Initialization--------------------------------------------	
	static int i;
	Scanner sc = new Scanner(System.in);
	Random rnd = new Random();
	static ArrayList<Integer> preArray = new ArrayList<Integer>();
	static int j;
	static int[] guess = new int[4];
	static char[] ans = new char[4];

//  --------------------------------------------------------Constructor Part--------------------------------------------------

	public GuessingGame() {
		while (preArray.size() < 4) {
			int random = rnd.nextInt(9) + 1;
			if (!preArray.contains(random)) {
				preArray.add(random);
			}
		}
//		for (int i = 0; i < 4; i++) {
//
//			System.out.print(preArray.get(i) + "\t");
//		}
		for (int i = 0; i < 4; i++) {

			ans[i] = 'X';
		}

	}

//---------------------------------------------------------Main Method------------------------------------------------------

	public static void main(String[] args) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++---HINT---++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+\t\t\t\t\t\t\t\t\t\t\t\t +");
		System.out.println("+\t\t\t\tC ---> Correct Guess\t\t\t\t\t\t +\n+\t\t\t\tP ----> Present but Wrong Position\t\t\t\t +\n+\t\t\t\tX ---->Wrong Guess & Not Present\t\t\t\t + ");
		System.out.println("+\t\t\t\t\t\t\t\t\t\t\t\t +");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		GuessingGame game = new GuessingGame();
		do{
		
		game.getInput();
		game.check();
		System.out.println("");
		game.show();
		
		if(ans[0]=='C' && ans[1]=='C' && ans[2]=='C' && ans[2]=='C' && ans[3]=='C') {
			break;
		}
		}while(true);

		System.out.println("\n*****************Congrats You have been Sucessfully Guessed the Numbers*****************");

//--------------------------------------------------------Check Method---------------------------------------------------
	}

	private void check() {
		for (int i = 0; i < 4; i++) {
			if (preArray.get(i) == guess[i]) {
				ans[i] = 'C';

			}
			else 
			{
				for(j=0;j<4;j++) {
					if(guess[j]==preArray.get(i)) {
						ans[j]='P';
					}
				}
			}
		
			
		}
		
	
		
		

	}


//--------------------------------------------------------User input Method-------------------------------------------------
	private void getInput() {
		try {
			System.out.println("");
			System.out.println("Enter the Guessed Numbers (4 Digits unique numbers) from 1 to 9 ");
			for (int i = 0; i < 4; i++) {

				guess[i] = sc.nextInt();
			}
			
		} catch (InputMismatchException e) {
			System.out.println("\n Values Must be in Nnmbers From 1 to 9");
			System.out.println("\nExiting..................");
			System.exit(0);
			
		}
		catch (NoSuchElementException e) {
			System.out.println("\n Values Must Be entered");
			System.out.println("\nExiting..................");
			System.exit(0);
		}
		

	}

// --------------------------------------------------------Show Method-----------------------------------------------------
	private void show() {

//		for (int i = 0; i < 4; i++) {
//			int x = preArray.get(i);
//			System.out.print(x + "\t");
//
//		}
		
		System.out.println("");
		for (int i = 0; i < 4; i++) {
			System.out.print(guess[i] + "\t");

		}
		System.out.println("");
		for (int i = 0; i < 4; i++) {
			System.out.print(ans[i] + "\t");

		}
		System.out.println("");

	}

}
//-----------------------------------------------------------end of Class------------------------------------------------------