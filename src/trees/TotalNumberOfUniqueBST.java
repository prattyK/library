package trees;

public class TotalNumberOfUniqueBST {

	public static int totalNumberOfGST(int n) {

		int G[] = new int[n + 1];

		G[0] = 1;
		G[1] = 1;

		for (int i = 2; i <= n; i++) { 

			for (int j = 1; j <= i; j++) {
				G[i] = G[i] + G[j - 1] * G[i - j];
			}

		}

		return G[n];
	}

	public static void main(String[] args) {

		totalNumberOfGST(5);
		
	}

}
