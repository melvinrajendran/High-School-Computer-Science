import java.util.Scanner;
public class TicTacToe {
	public static void main (String[]args) {

		Scanner num = new Scanner (System.in);

		int[][]boardLine = {{0,200,600,200},
							{0,400,600,400},
							{200,0,200,600},
							{400,0,400,600}};

		char [][]arr = new char[3][3];
			for (int i=0;i<2;i++)
				for (int j=0;j<2;j++)
					arr[i][j]='-';

		TicTacToeBoard board = new TicTacToeBoard(620,720);
		board.defineBoard(boardLine);
		board.setFiles("x.jpg","o.jpg");
		board.setBoard(arr);
		board.repaint();

		System.out.print("Welcome to Tic-Tac-Toe!\n\nInstructions: For each turn of single-player Tic-Tac-Toe, the player will be the \"X\", and selects the row and column\n\t      for the space where he/she wants to place the marker.  In two-player mode, player one will be the \"X\",\n\t      and player two will be the \"O\".  Both players will alternate selecting spaces in which to place their\n\t      markers by entering the row and column of their desired space.\n\nPlease select a mode: [1]-Player / [2]-Player: ");
		int gamemode = num.nextInt();
		while ((gamemode != 1) && (gamemode != 2)) {
			System.out.print("Please select a valid mode: [1]-Player / [2]-Player: ");
			gamemode = num.nextInt();
		}
		System.out.println();
		if (gamemode == 1) {
			for (int turn = 0; turn < 5; turn++) {
				System.out.print("Please enter the row where you would like to place your marker (0-2): ");
				int row = num.nextInt();
				while ((row < 0) || (row > 2)) {
					System.out.print("Please enter a valid row where you would like to place your marker (0-2): ");
					row = num.nextInt();
				}
				System.out.print("Please enter the column where you would like to place your marker (0-2): ");
				int col = num.nextInt();
				while ((col < 0) || (col > 2)) {
					System.out.print("Please enter a valid column where you would like to place your marker (0-2): ");
					col = num.nextInt();
				}
				while ((arr[row][col] == 'x') || (arr[row][col] == 'o')) {
					System.out.println("\nThat space is already taken.");
					System.out.print("Please enter the row where you would like to place your marker (0-2): ");
					row = num.nextInt();
					while ((row < 0) || (row > 2)) {
						System.out.print("Please enter a valid row where you would like to place your marker (0-2): ");
						row = num.nextInt();
					}
					System.out.print("Please enter the column where you would like to place your marker (0-2): ");
					col = num.nextInt();
					while ((col < 0) || (col > 2)) {
						System.out.print("Please enter a valid column where you would like to place your marker (0-2): ");
						col = num.nextInt();
					}
				}
				arr[row][col] = 'x';
				board.setBoard(arr);
				board.repaint();

				if (((arr[0][0] == 'x') && (arr[0][1] == 'x') && (arr[0][2] == 'x')) || ((arr[1][0] == 'x') && (arr[1][1] == 'x') && (arr[1][2] == 'x')) || ((arr[2][0] == 'x') && (arr[2][1] == 'x') && (arr[2][2] == 'x')) || ((arr[0][0] == 'x') && (arr[1][0] == 'x') && (arr[2][0] == 'x'))
				|| ((arr[0][1] == 'x') && (arr[1][1] == 'x') && (arr[2][1] == 'x')) || ((arr[0][2] == 'x') && (arr[1][2] == 'x') && (arr[2][2] == 'x')) || ((arr[0][0] == 'x') && (arr[1][1] == 'x') && (arr[2][2] == 'x')) || ((arr[0][2] == 'x') && (arr[1][1] == 'x') && (arr[2][0] == 'x'))) {
					board.setWinner("X Wins!", 225, 655, 50);
					board.showText(true);
					break;
				}
				else if (((arr[0][0] == 'x') || (arr[0][0] == 'o')) && ((arr[0][1] == 'x') || (arr[0][1] == 'o')) && ((arr[0][2] == 'x') || (arr[0][2] == 'o')) && ((arr[1][0] == 'x') || (arr[1][0] == 'o')) && ((arr[1][1] == 'x') || (arr[1][1] == 'o')) && ((arr[1][2] == 'x') || (arr[1][2] == 'o')) &&
				((arr[2][0] == 'x') || (arr[2][0] == 'o')) && ((arr[2][1] == 'x') || (arr[2][1] == 'o')) && ((arr[2][2] == 'x') || (arr[2][2] == 'o'))){
					board.setWinner("Tie!", 260, 655, 50);
					board.showText(true);
					break;
				}

				int altrow = (int)(Math.random()*3);
				int altcol = (int)(Math.random()*3);
				while ((arr[altrow][altcol] == 'x') || (arr[altrow][altcol] == 'o')) {
					altrow = (int)(Math.random()*3);
					altcol = (int)(Math.random()*3);
				}
				board.delay(2000);
				arr[altrow][altcol] = 'o';
				board.setBoard(arr);
				board.repaint();

				if (((arr[0][0] == 'o') && (arr[0][1] == 'o') && (arr[0][2] == 'o')) || ((arr[1][0] == 'o') && (arr[1][1] == 'o') && (arr[1][2] == 'o')) || ((arr[2][0] == 'o') && (arr[2][1] == 'o') && (arr[2][2] == 'o')) || ((arr[0][0] == 'o') && (arr[1][0] == 'o') && (arr[2][0] == 'o'))
				|| ((arr[0][1] == 'o') && (arr[1][1] == 'o') && (arr[2][1] == 'o')) || ((arr[0][2] == 'o') && (arr[1][2] == 'o') && (arr[2][2] == 'o')) || ((arr[0][0] == 'o') && (arr[1][1] == 'o') && (arr[2][2] == 'o')) || ((arr[0][2] == 'o') && (arr[1][1] == 'o') && (arr[2][0] == 'o'))) {
					board.setWinner("O Wins!", 225, 655, 50);
					board.showText(true);
					break;
				}
				System.out.println();
			}
		}
		else if (gamemode == 2) {
			for (int turn1 = 0; turn1 < 5; turn1++) {
				System.out.print("Player 1: Please enter the row where you would like to place your marker (0-2): ");
				int row1 = num.nextInt();
				while ((row1 < 0) || (row1 > 2)) {
					System.out.print("\t  Please enter a valid row where you would like to place your marker (0-2): ");
					row1 = num.nextInt();
				}
				System.out.print("\t  Please enter the column where you would like to place your marker (0-2): ");
				int col1 = num.nextInt();
				while ((col1 < 0) || (col1 > 2)) {
					System.out.print("\t  Please enter a valid column where you would like to place your marker (0-2): ");
					col1 = num.nextInt();
				}
				while ((arr[row1][col1] == 'x') || (arr[row1][col1] == 'o')) {
					System.out.println("\nThat space is already taken.");
					System.out.print("Player 1: Please enter the row where you would like to place your marker (0-2): ");
					row1 = num.nextInt();
					while ((row1 < 0) || (row1 > 2)) {
						System.out.print("\t  Please enter a valid row where you would like to place your marker (0-2): ");
						row1 = num.nextInt();
					}
					System.out.print("\t  Please enter the column where you would like to place your marker (0-2): ");
					col1 = num.nextInt();
					while ((col1 < 0) || (col1 > 2)) {
						System.out.print("\t  Please enter a valid column where you would like to place your marker (0-2): ");
						col1 = num.nextInt();
					}
				}
				arr[row1][col1] = 'x';
				board.setBoard(arr);
				board.repaint();

				if (((arr[0][0] == 'x') && (arr[0][1] == 'x') && (arr[0][2] == 'x')) || ((arr[1][0] == 'x') && (arr[1][1] == 'x') && (arr[1][2] == 'x')) || ((arr[2][0] == 'x') && (arr[2][1] == 'x') && (arr[2][2] == 'x')) || ((arr[0][0] == 'x') && (arr[1][0] == 'x') && (arr[2][0] == 'x'))
				|| ((arr[0][1] == 'x') && (arr[1][1] == 'x') && (arr[2][1] == 'x')) || ((arr[0][2] == 'x') && (arr[1][2] == 'x') && (arr[2][2] == 'x')) || ((arr[0][0] == 'x') && (arr[1][1] == 'x') && (arr[2][2] == 'x')) || ((arr[0][2] == 'x') && (arr[1][1] == 'x') && (arr[2][0] == 'x'))) {
					board.setWinner("X Wins!", 225, 655, 50);
					board.showText(true);
					break;
				}
				else if (((arr[0][0] == 'x') || (arr[0][0] == 'o')) && ((arr[0][1] == 'x') || (arr[0][1] == 'o')) && ((arr[0][2] == 'x') || (arr[0][2] == 'o')) && ((arr[1][0] == 'x') || (arr[1][0] == 'o')) && ((arr[1][1] == 'x') || (arr[1][1] == 'o')) && ((arr[1][2] == 'x') || (arr[1][2] == 'o')) &&
				((arr[2][0] == 'x') || (arr[2][0] == 'o')) && ((arr[2][1] == 'x') || (arr[2][1] == 'o')) && ((arr[2][2] == 'x') || (arr[2][2] == 'o'))) {
					board.setWinner("Tie!", 260, 655, 50);
					board.showText(true);
					break;
				}

				System.out.print("\nPlayer 2: Please enter the row where you would like to place your marker (0-2): ");
				int row2 = num.nextInt();
				while ((row2 < 0) || (row2 > 2)) {
					System.out.print("\t  Please enter a valid row where you would like to place your marker (0-2): ");
					row2 = num.nextInt();
				}
				System.out.print("\t  Please enter the column where you would like to place your marker (0-2): ");
				int col2 = num.nextInt();
				while ((col2 < 0) || (col2 > 2)) {
					System.out.print("\t  Please enter a valid column where you would like to place your marker (0-2): ");
					col2 = num.nextInt();
				}
				while ((arr[row2][col2] == 'x') || (arr[row2][col2] == 'o')) {
					System.out.println("\nThat space is already taken.");
					System.out.print("Player 2: Please enter the row where you would like to place your marker (0-2): ");
					row2 = num.nextInt();
					while ((row2 < 0) || (row2 > 2)) {
						System.out.print("\t  Please enter a valid row where you would like to place your marker (0-2): ");
						row2 = num.nextInt();
					}
					System.out.print("\t  Please enter the column where you would like to place your marker (0-2): ");
					col2 = num.nextInt();
					while ((col2 < 0) || (col2 > 2)) {
						System.out.print("\t  Please enter a valid column where you would like to place your marker (0-2): ");
						col2 = num.nextInt();
					}
				}
				arr[row2][col2] = 'o';
				board.setBoard(arr);
				board.repaint();

				if (((arr[0][0] == 'o') && (arr[0][1] == 'o') && (arr[0][2] == 'o')) || ((arr[1][0] == 'o') && (arr[1][1] == 'o') && (arr[1][2] == 'o')) || ((arr[2][0] == 'o') && (arr[2][1] == 'o') && (arr[2][2] == 'o')) || ((arr[0][0] == 'o') && (arr[1][0] == 'o') && (arr[2][0] == 'o'))
				|| ((arr[0][1] == 'o') && (arr[1][1] == 'o') && (arr[2][1] == 'o')) || ((arr[0][2] == 'o') && (arr[1][2] == 'o') && (arr[2][2] == 'o')) || ((arr[0][0] == 'o') && (arr[1][1] == 'o') && (arr[2][2] == 'o')) || ((arr[0][2] == 'o') && (arr[1][1] == 'o') && (arr[2][0] == 'o'))) {
					board.setWinner("O Wins!", 225, 655, 50);
					board.showText(true);
					break;
				}
				System.out.println();
			}
		}
	}
}