// Yuna Frolov

public class ReversiPlay {

	public static void main(String[] args) {

	}

	public static void printMatrix(int[][] matrix) {
		// prints the matrix
		for (int i = 0; i < matrix.length; i = i + 1){
			System.out.println();
			for (int j = 0; j < matrix[i].length; j = j + 1)
				System.out.print(matrix[i][j] + ", ");}
		System.out.println();
	}

	public static boolean isEqual(int[][] matrix1, int[][] matrix2) {
		// the function checks whether the given matrixes are equal - length and
		// body the same
		boolean isEqual = true;
		// if the length is unequal - returns false
		if (matrix1.length != matrix2.length
				|| matrix1[0].length != matrix2[0].length)
			return false;
		// if length is equal - checking if content is equal, default is true,
		// unless found not equal
		else {
			for (int i = 0; i < matrix1.length; i = i + 1)
				for (int j = 0; j < matrix1[i].length; j = j + 1)
					if (matrix1[i][j] != matrix2[i][j])
						isEqual = false;

			return isEqual;
		}
	}

	public static int[][] copyMatrix(int[][] matrix) {
		// the function duplicates a given matrix, and return a copy matrix but
		// with new address
		int[][] newMatrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i = i + 1)
			for (int j = 0; j < matrix[i].length; j = j + 1)
				newMatrix[i][j] = matrix[i][j];
		return newMatrix;
	}

	public static int[][] createBoard(int size) {
		//creates a default board
		int[][] initialBoard = new int[size][size];

		initialBoard[(size/2)-1][(size/2)-1] = 2;
		initialBoard[(size/2)-1][size/2] = 1;
		initialBoard[size/2][((size/2)-1)] = 1;
		initialBoard[size/2][size/2] = 2;

		return initialBoard;
	}

	public static boolean isLegal(int[][] board, int player, int row, int column) {
		//checking who is the other player
		int otherPlayer;
		if(player == 1)
			otherPlayer=2;
		else
			otherPlayer=1;
		boolean isLegal = false;

		//if the move is inside the bounds, send to check all directions
		//if one of the directions returns true - it's enough to say the move is legal. else, it's not
		if (board[row][column] == 0) {
			isLegal = f1(board, row-1, column-1, player, otherPlayer);
			if(isLegal) return isLegal;
			isLegal = f2(board, row-1, column, player, otherPlayer);
			if(isLegal) return isLegal;
			isLegal = f3(board, row-1, column+1, player, otherPlayer);
			if(isLegal) return isLegal;
			isLegal = f4(board, row, column-1, player, otherPlayer);
			if(isLegal) return isLegal;
			isLegal = f5(board, row, column+1, player, otherPlayer);
			if(isLegal) return isLegal;
			isLegal = f6(board, row+1, column-1, player, otherPlayer);
			if(isLegal) return isLegal;
			isLegal = f7(board, row+1, column, player, otherPlayer);
			if(isLegal) return isLegal;
			isLegal = f8(board, row+1, column+1, player, otherPlayer);
			if(isLegal) return isLegal;
		}
		else
			return false;
		return isLegal;
	}
	///////////////////////////////////////////////////////////
	//all functions in block are to check each direction to see if there is a player disk, recursive functions
	///////////////////////////////////////////////////////////
	public static boolean f1(int[][] board, int row, int column, int player, int otherPlayer){

		boolean isLegal = false;
		if(row>=1 && column>=1){
			if(board[row][column] == otherPlayer)
				if(board[row-1][column-1]==player)
					return true;
				else
					isLegal = f1(board, row-1, column-1, player, otherPlayer);
		}
		return isLegal;
	}

	public static boolean f2(int[][] board, int row, int column, int player, int otherPlayer){

		boolean isLegal = false;
		if(row>=1){
			if(board[row][column] == otherPlayer)
				if(board[row-1][column]==player)
					return true;
				else
					isLegal = f2(board, row-1, column, player, otherPlayer);
		}
		return isLegal;
	}

	public static boolean f3(int[][] board, int row, int column, int player, int otherPlayer){

		boolean isLegal = false;
		if(row>=1 && column<(board.length-1)){
			if(board[row][column] == otherPlayer)
				if(board[row-1][column+1]==player)
					return true;
				else
					isLegal = f3(board, row-1, column+1, player, otherPlayer);
		}
		return isLegal;
	}

	public static boolean f4(int[][] board, int row, int column, int player, int otherPlayer){

		boolean isLegal = false;
		if(column>=1){
			if(board[row][column] == otherPlayer)
				if(board[row][column-1]==player)
					return true;
				else
					isLegal = f4(board, row, column-1, player, otherPlayer);
		}
		return isLegal;
	}

	public static boolean f5(int[][] board, int row, int column, int player, int otherPlayer){

		boolean isLegal = false;
		if(column<(board.length-1)){
			if(board[row][column] == otherPlayer)
				if(board[row][column+1]==player)
					return true;
				else
					isLegal = f5(board, row, column+1, player, otherPlayer);
		}
		return isLegal;
	}

	public static boolean f6(int[][] board, int row, int column, int player, int otherPlayer){

		boolean isLegal = false;
		if(row<(board.length-1) && column>=1){
			if(board[row][column] == otherPlayer)
				if(board[row+1][column-1]==player)
					return true;
				else
					isLegal = f6(board, row+1, column-1, player, otherPlayer);
		}
		return isLegal;
	}

	public static boolean f7(int[][] board, int row, int column, int player, int otherPlayer){

		boolean isLegal = false;
		if(row<(board.length-1)){
			if(board[row][column] == otherPlayer)
				if(board[row+1][column]==player)
					return true;
				else
					isLegal = f7(board, row+1, column, player, otherPlayer);}

		return isLegal;
	}

	public static boolean f8(int[][] board, int row, int column, int player, int otherPlayer){

		boolean isLegal = false;
		if(row<(board.length-1) && column<(board.length-1)){
			if(board[row][column] == otherPlayer)
				if(board[row+1][column+1]==player)
					return true;
				else
					isLegal = f8(board, row+1, column+1, player, otherPlayer);
		}
		return isLegal;
	}
	///////////////////////////////////////////////////////////

	public static int[][] play(int[][] board, int player, int row, int column) {
		//if the move is legal - put a player disk, if not - return the board untouched
		if(isLegal(board, player, row, column))
			board[row][column] = player;
		else return board;

		//Determine the other player
		int otherPlayer;
		if(player == 1)
			otherPlayer=2;
		else
			otherPlayer=1;

		//According to the direction in which the move is legal - go and change all disks in the way
		if(f1(board, row-1, column-1, player, otherPlayer))
			board = fPlay1(board, row-1, column-1, player, otherPlayer);
		if(f2(board, row-1, column, player, otherPlayer))
			board = fPlay2(board, row-1, column, player, otherPlayer);
		if(f3(board, row-1, column+1, player, otherPlayer))
			board = fPlay3(board, row-1, column+1, player, otherPlayer);
		if(f4(board, row, column-1, player, otherPlayer))
			board = fPlay4(board, row, column-1, player, otherPlayer);
		if(f5(board, row, column+1, player, otherPlayer))
			board = fPlay5(board, row, column+1, player, otherPlayer);
		if(f6(board, row+1, column-1, player, otherPlayer))
			board = fPlay6(board, row+1, column-1, player, otherPlayer);
		if(f7(board, row+1, column, player, otherPlayer))
			board = fPlay7(board, row+1, column, player, otherPlayer);
		if(f8(board, row+1, column+1, player, otherPlayer))
			board = fPlay8(board, row+1, column+1, player, otherPlayer);

		return board;
	}
	///////////////////////////////////////////////////////////
	//all functions in block change the disks to player disks, recursively
	///////////////////////////////////////////////////////////
	public static int[][] fPlay1(int[][] board, int row, int column, int player, int otherPlayer){
		if(row>=1 && column>=1){
			if(board[row][column] == otherPlayer){
				board[row][column] = player;
				board = fPlay1(board, row-1, column-1, player, otherPlayer);
			}else return board;
		}
		return board;
	}

	public static int[][] fPlay2(int[][] board, int row, int column, int player, int otherPlayer){
		if(row>=1){
			if(board[row][column] == otherPlayer){
				board[row][column] = player;
				board = fPlay2(board, row-1, column, player, otherPlayer);
			}else return board;
		}
		return board;
	}

	public static int[][] fPlay3(int[][] board, int row, int column, int player, int otherPlayer){
		if(row>=1 && column<(board.length-1)){
			if(board[row][column] == otherPlayer){
				board[row][column] = player;
				board = fPlay3(board, row-1, column+1, player, otherPlayer);
			}else return board;
		}
		return board;
	}

	public static int[][] fPlay4(int[][] board, int row, int column, int player, int otherPlayer){
		if(column>=1){
			if(board[row][column] == otherPlayer){
				board[row][column] = player;
				board = fPlay4(board, row, column-1, player, otherPlayer);
			}else return board;
		}
		return board;
	}

	public static int[][] fPlay5(int[][] board, int row, int column, int player, int otherPlayer){
		if(column<(board.length-1)){
			if(board[row][column] == otherPlayer){
				board[row][column] = player;
				board = fPlay5(board, row, column+1, player, otherPlayer);
			}else return board;
		}
		return board;
	}

	public static int[][] fPlay6(int[][] board, int row, int column, int player, int otherPlayer){
		if(row<(board.length-1) && column>=1){
			if(board[row][column] == otherPlayer){
				board[row][column] = player;
				board = fPlay6(board, row+1, column-1, player, otherPlayer);
			}else return board;
		}
		return board;
	}

	public static int[][] fPlay7(int[][] board, int row, int column, int player, int otherPlayer){
		if(row<(board.length-1)){
			if(board[row][column] == otherPlayer){
				board[row][column] = player;
				board = fPlay7(board, row+1, column, player, otherPlayer);
			}else return board;
		}
		return board;
	}

	public static int[][] fPlay8(int[][] board, int row, int column, int player, int otherPlayer){
		if(row<(board.length-1) && column<(board.length-1)){
			if(board[row][column] == otherPlayer){
				board[row][column] = player;
				board = fPlay8(board, row+1, column+1, player, otherPlayer);
			}else return board;
		}
		return board;
	}


	///////////////////////////////////////////////////////////

	public static int benefit(int[][] board, int player, int row, int column) {
		//creating a new matrix on which we check what is the benefit of the move by playing it
		int[][] benefitBoard = copyMatrix(board);
		benefitBoard = play(benefitBoard, player, row, column);

		//counting the number of disks before the move
		int countDisksBefore = 0;
		for(int i=0; i<board.length; i=i+1)
			for(int j=0; j<board[i].length; j=j+1)
				if(board[i][j] == player)
					countDisksBefore = countDisksBefore+1;

		//counting the number of disks after the move
		int countDisksAfter = 0;
		for(int i=0; i<benefitBoard.length; i=i+1)
			for(int j=0; j<benefitBoard[i].length; j=j+1)
				if(benefitBoard[i][j] == player)
					countDisksAfter = countDisksAfter+1;

		//returning the benefit according to disks counters
		int benefit = countDisksAfter - countDisksBefore;
		return benefit;
	}

	public static int[][] possibleMoves(int[][] board, int player) {
		int countOfLegals = 0;

		//counting how many legal moves there are
		for(int i=0; i<board.length; i=i+1)
			for(int j=0; j<board[i].length; j=j+1)
				if(isLegal(board, player, i, j))
					countOfLegals=countOfLegals+1;

		int[][] matOfPossibleMoves = new int[countOfLegals][2];
		int nextMove = 0;

		//putting to coordinates of legal moves to mat of possible moves
		for(int i=0; i<board.length; i=i+1)
			for(int j=0; j<board[i].length; j=j+1)
				if(isLegal(board, player, i, j)){
					matOfPossibleMoves[nextMove][0] = i;
					matOfPossibleMoves[nextMove][1] = j;
					nextMove = nextMove+1;
				}

		return matOfPossibleMoves;
	}

	public static boolean hasMoves(int[][] board, int player) {
		boolean hasMoves = false;
		int[][] matPossMoves = possibleMoves(board, player);

		//if there are no possible moves - he has no moves
		if(matPossMoves.length>0)
			hasMoves = true;

		return hasMoves;
	}

	public static int findTheWinner(int[][] board) {
		int countOfFirst = 0;
		int countOfSecond = 0;
		//counting the disks of each player
		for(int i=0; i<board.length; i=i+1)
			for(int j=0; j<board[i].length; j=j+1)
				if(board[i][j] == 1)
					countOfFirst = countOfFirst+1;
				else if(board[i][j] == 2)
					countOfSecond = countOfSecond+1;

		//he who has more disks is the winner, if the same = return 0
		int winner = 0;
		if(countOfFirst>countOfSecond)
			winner = 1;
		else if(countOfFirst<countOfSecond) winner = 2;
		else winner = 0;

		return winner;
	}

	public static boolean gameOver(int[][] board) {
		//checking if the board is full by counting empty spaces
		int countOfEmpty = 0;
		for(int i=0; i<board.length; i=i+1)
			for(int j=0; j<board[i].length; j=j+1)
				if(board[i][j] == 0)
					countOfEmpty = countOfEmpty+1;
		if(countOfEmpty == 0)
			return true;

		//checking if all disks are same color
		int countOfFirst = 0;
		int countOfSecond = 0;
		for(int i=0; i<board.length; i=i+1)
			for(int j=0; j<board[i].length; j=j+1)
				if(board[i][j] == 1)
					countOfFirst = countOfFirst+1;
				else if(board[i][j] == 2)
					countOfSecond = countOfSecond+1;
		if(countOfFirst == 0 || countOfSecond == 0)
			return true;

		//checking if no possible moves for someone
		if(!hasMoves(board, 1) && !hasMoves(board, 2))
			return true;

		return false;
	}

	public static int[] randomPlayer(int[][] board, int player) {
		int[][] randomPossibleMoves = possibleMoves(board,player);
		int[] theMove = new int[2];

		//if there are more than one possible move - randomize the coordinates of move
		if(randomPossibleMoves.length>0){
			int randomNum = (int)(Math.random() * (randomPossibleMoves.length - 0) + 0);
			theMove[0] = randomPossibleMoves[randomNum][0];
			theMove[1] = randomPossibleMoves[randomNum][1];
		}else return null;

		return theMove;
	}

	public static int[] greedyPlayer(int[][] board, int player) {

		int[][] possibleMoves = possibleMoves(board,player);
		int[][] matBenefitCheck = new int[possibleMoves.length][3];

		//creating the mat of all possible benefits
		for(int i=0; i<matBenefitCheck.length; i=i+1){
			matBenefitCheck[i][0] = possibleMoves[i][0];
			matBenefitCheck[i][1] = possibleMoves[i][1];
			matBenefitCheck[i][2] = benefit(board, player, possibleMoves[i][0], possibleMoves[i][1]);	
		}
		//checking what is the max benefit
		int maxBenefit = 0;
		for(int i=0; i<matBenefitCheck.length; i=i+1)
			if(matBenefitCheck[i][2] > maxBenefit)
				maxBenefit = matBenefitCheck[i][2];

		//counting how much maximum benefits there are
		int maxBenefitCounter = 0;
		for(int i=0; i<matBenefitCheck.length; i=i+1)
			if(matBenefitCheck[i][2] == maxBenefit)
				maxBenefitCounter = maxBenefitCounter+1;

		//creating mat of places of max number
		int[][] matMaxBenefit = new int[maxBenefitCounter][2];
		int maxBenefitIndex = 0;
		for(int i=0; i<matBenefitCheck.length; i=i+1)
			if(matBenefitCheck[i][2] == maxBenefit){
				matMaxBenefit[maxBenefitIndex][0] = matBenefitCheck[i][0];
				matMaxBenefit[maxBenefitIndex][1] = matBenefitCheck[i][1];
				maxBenefitIndex++;
			}

		//randomizing the greedy move according to max benefit
		int[] arrGreedy = new int[2];
		if(matMaxBenefit.length>0){
			int randomNum = (int)(Math.random() * (matMaxBenefit.length - 0) + 0);
			arrGreedy[0] = matMaxBenefit[randomNum][0];
			arrGreedy[1] = matMaxBenefit[randomNum][1];
		}else return null;

		return arrGreedy;
	}

	public static int[] defensivePlayer(int[][] board, int player) {

		int[][] afterBoard = new int[board.length][board[0].length];
		int[][] possibleMoves = possibleMoves(board, player);
		int[] possibleGreedyMove;
		int firstMoveBenefit;
		int greedyMoveBenefit;
		int [] arrAllBenefit = new int[possibleMoves.length];

		int otherPlayer;
		if(player == 1)
			otherPlayer = 2;
		else otherPlayer = 1;

		for(int i=0; i<possibleMoves.length; i=i+1){
			//checking the first move benefit
			firstMoveBenefit = benefit(board, player, possibleMoves[i][0], possibleMoves[i][1]);
			//creating a new board with probable move to check what will be the next move benefit if greedy
			afterBoard = copyMatrix(board);
			afterBoard = play(afterBoard, player, possibleMoves[i][0], possibleMoves[i][1]);
			possibleGreedyMove = greedyPlayer(afterBoard, otherPlayer);

			if(possibleGreedyMove!=null){
				greedyMoveBenefit = benefit(afterBoard, otherPlayer, possibleGreedyMove[0], possibleGreedyMove[1]);
				//entering the benefit of the move if next player's move is greedy
				arrAllBenefit[i] = firstMoveBenefit - greedyMoveBenefit;
			}
		}

		//checking what is the max benefit
		int maxBenefit = -1000;
		for(int i=0; i<arrAllBenefit.length; i=i+1)
			if(arrAllBenefit[i] > maxBenefit)
				maxBenefit = arrAllBenefit[i];

		//counting how much maximum benefits there are
		int maxBenefitCounter = 0;
		for(int i=0; i<arrAllBenefit.length; i=i+1)
			if(arrAllBenefit[i] == maxBenefit)
				maxBenefitCounter = maxBenefitCounter+1;

		//creating mat of places of max number
		int[] matMaxBenefit = new int[maxBenefitCounter];
		int maxBenefitIndex = 0;
		for(int i=0; i<arrAllBenefit.length; i=i+1)
			if(arrAllBenefit[i] == maxBenefit){
				matMaxBenefit[maxBenefitIndex] = i;
				maxBenefitIndex++;
			}

		//randomizing the greedy move according to max benefit
		int[] arrBestMove = new int[2];
		if(matMaxBenefit.length>0){
			int randomNum = (int)(Math.random() * (matMaxBenefit.length - 0) + 0);
			arrBestMove[0] = possibleMoves[matMaxBenefit[randomNum]][0];
			arrBestMove[1] =  possibleMoves[matMaxBenefit[randomNum]][1];
		}else return null;

		return arrBestMove;

	}

	public static int[] byLocationPlayer(int[][] board, int player) {
		/////////////////////// creating location board
		int[][] arrLocation = new int[board.length][board[0].length];
		//creating the four pieces of the board
		for(int i=0; i<(board.length/2); i=i+1)
			for(int j=0; j<(board.length/2); j=j+1)
				arrLocation[i][j] = board.length-1-j-i;

		for(int i=0; i<(board.length/2); i=i+1)
			for(int j=(board.length-1); j>(board.length/2 - 1); j=j-1)
				arrLocation[i][j] = j-i;

		for(int i=(board.length-1); i>(board.length/2-1); i=i-1)
			for(int j=0; j<(board.length/2); j=j+1)
				arrLocation[i][j] = i-j;

		for(int i=(board.length-1); i>(board.length/2 - 1); i=i-1)
			for(int j=(board.length-1); j>(board.length/2 - 1); j=j-1)
				arrLocation[i][j] = j -(board.length-i)+1;
		//////////////////////////////////////////////////

		int[] theChosenMove = new int[2];
		int[][] arrPossibleMoves = possibleMoves(board, player);
		int[][] arrOfPlaces = new int[arrPossibleMoves.length][3];
		//placing the possible moves with their location together in one array
		for(int i = 0; i<arrOfPlaces.length; i=i+1){
			arrOfPlaces[i][0] = arrPossibleMoves[i][0];
			arrOfPlaces[i][1] = arrPossibleMoves[i][1];
			arrOfPlaces[i][2] = arrLocation[arrPossibleMoves[i][0]][arrPossibleMoves[i][1]];
		}
		//checking if possible to move to corner
		int counterOfMax = 0;
		for(int i =0; i<arrOfPlaces.length; i=i+1)
			if(arrOfPlaces[i][2] == arrLocation[0][0])
				counterOfMax++;

		int[][] arrOfMax = new int[counterOfMax][2];
		int maxIndex=0;
		for(int i =0; i<arrOfPlaces.length; i=i+1)
			if(arrOfPlaces[i][2] == (board.length-1)){
				arrOfMax[maxIndex][0]=arrOfPlaces[i][0];
				arrOfMax[maxIndex][1]=arrOfPlaces[i][1];
				maxIndex++;
			}

		//randomizing the move
		if(arrOfMax.length>0){
			int randomNum = (int)(Math.random() * (arrOfMax.length - 0) + 0);
			theChosenMove[0] = arrOfMax[randomNum][0];
			theChosenMove[1] =  arrOfMax[randomNum][1];

			return theChosenMove;
		}else{
			//if no corner available - go to closest to center move
			int minNum = 1000;
			int counterOfMin = 0;
			for(int j=0; j<arrOfPlaces.length; j=j+1)
				if(arrOfPlaces[j][2]<minNum)
					minNum = arrOfPlaces[j][2];

			for(int k=0; k<arrOfPlaces.length; k=k+1)
				if(arrOfPlaces[k][2]==minNum){
					counterOfMin++;
				}

			int[][] arrOfMin = new int[counterOfMin][2];
			int minIndex=0;
			for(int i =0; i<arrOfPlaces.length; i=i+1)
				if(arrOfPlaces[i][2] == minNum){
					arrOfMin[minIndex][0]=arrOfPlaces[i][0];
					arrOfMin[minIndex][1]=arrOfPlaces[i][1];
					minIndex++;
				}

			//randomizing the move
			if(arrOfMin.length>0){
				int randomNum = (int)(Math.random() * (arrOfMin.length - 0) + 0);
				theChosenMove[0] = arrOfMin[randomNum][0];
				theChosenMove[1] =  arrOfMin[randomNum][1];

				return theChosenMove;
			} else return null;
		}

	}

	public static int[] myPlayer(int[][] board, int player) {
		return null;
	}
}