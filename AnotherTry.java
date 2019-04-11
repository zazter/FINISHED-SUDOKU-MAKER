// author: Villem Kand

import java.util.Random;


public class AnotherTry {
	
	private static Random random = new Random();
	private static int[][][] grid = new int[9][3][3];
	public static int[]  numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	public static void main(String[] args) {
		int randomNr;
		int counter;
		boolean isRepeat = true;
		for (int i = 0; i <= 8; i++) {
			for (int j = 0; j <= 2; j++) {
				
				for (int k = 0; k <= 2; k++) {
					counter = 0;
					isRepeat = true;
					while(isRepeat) {
						randomNr = numbers[random.nextInt(numbers.length)];
						grid[i][j][k] = randomNr;
						counter++;
						if(!checker(i, j, k) && !vertchecker(i, j, k) && !cubechecker(i, j, k))
							isRepeat = false;
						if (counter > 1000) {
							j = 0;
							k = -1;
							resetRow(i, j, k);
							break;
						}
					}
				}
			}
		}
		printSudoku();
	}
	
	public static void printSudoku() {
		for (int i = 0; i < 9; i++) {
			   for (int j = 0; j < 3; j++) {
				   for (int k = 0; k < 3; k++) {
					   System.out.printf("%d  ", grid[i][j][k]);
				   }
				   System.out.print(" ");
			   }
			   System.out.println("");
		   }
	}
	
	public static boolean checker(int i, int j, int k) {
		
		boolean isMatch = false;
		
		for (int x = -2; x <= 0; x++) {
			for (int y = -2; y <= 2; y++) {
				try {
					if (x == 0 && y == 0)
						continue;
					if (grid[i][j + x][k + y] == grid[i][j][k]) {
						isMatch = true;
					}
				} catch (Exception e) {
					
				}
			}
		}
		
		return isMatch;
	}
	
	public static boolean vertchecker(int i, int j, int k) {
		
		boolean isMatch = false;
		
		for (int x = -8; x <= 0; x++) {
				try {
					if (x == 0)
						continue;
					if (grid[i + x][j][k] == grid[i][j][k]) {
						isMatch = true;
					}
				} catch (Exception e) {
					
				}
		}
		
		return isMatch;
	}
	
	public static boolean cubechecker(int i, int j, int k) {
		
		boolean isMatch = false;
		
		for (int x = -2; x <= 2; x++) {
			for (int y = -2; y <= 2; y++) {
				try {
					if (x == 0 && y == 0)
						continue;
					if (grid[i + x][j][k + y] == grid[i][j][k]) {
						isMatch = true;
					}
				} catch (Exception e) {
					
				}
			}
		}
		
		return isMatch;
	}
	
	public static void resetRow(int i, int j, int k) {
		for (int x = -2; x <= 2; x++) {
			for (int y = -2; y <= 2; y++) {
				try {
					grid[i][j + x][k + y] = 0;
					
				} catch (Exception e) {
					
				}
			}
		}
	}
}
