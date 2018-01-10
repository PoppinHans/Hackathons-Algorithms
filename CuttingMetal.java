package JupiterHackathon;

import java.util.Arrays;
import java.util.Scanner;

/* - Why to show this piece of code as a sample?
 * - Because this is a simple problem, yet there are details that need to be handled properly.
 * - In addition, this sample illustrates some basic linear optimization.
 *
 * Given a collection of metal pieces, price of metal per unit length, and cost per cut.
 * You want to cut each piece of metal to uniform length, and desert any metal of different length,
 * so that the profit is maximized. 
 * 
 * The profit is: metalUnitPrice * metalLength * metalPieces - totalCuts * costPerCut
 */
public class CuttingMetal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cutCost = 0;
		int metalPrice = 0;
		int l = 0;
		int maxLen = 0;
		int maxProfit = 0;
		int[] metal;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the cost for each cut: ");
		cutCost = sc.nextInt();
		
		System.out.println("Enter the price per unit length of metal: ");
		metalPrice = sc.nextInt();
		
		System.out.println("Enter the number of metal pieces: ");
		l = sc.nextInt();
		metal = new int[l];
		
		System.out.println("Enter the length of each metal piece: ");
		for (int i = 0; i < l; i++) {
			metal[i] = sc.nextInt();
		}
		Arrays.sort(metal);
		maxLen = metal[l - 1];
		
		for (int i = 1; i <= maxLen; i++) {
			int piece = 0;
			int cut = 0;
			int curProfit = 0;
			for (int len : metal) {
				// when a cut is more expensive than a after-cut piece can make
				// desert the whole metal piece
				if (cutCost * (len / i) > metalPrice * i * (len / i) && i != len) {
					continue;
				}
				if (i <= len) {
					piece += len / i;
				}
				if (i < len) {
					cut += len / i;
				}
			}
			curProfit = piece * i * metalPrice - cut * cutCost;
			// System.out.println(piece + " " + i + " " + cut + " " + curProfit);
			maxProfit = Math.max(maxProfit, curProfit);
		}
		System.out.println("The max profit is calculated by: "
				+ "metalUnitPrice * metalLength * metalPieces - totalCuts * costPerCut: ");
		System.out.println(maxProfit);
	}
}
