package LinkedList;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

	public boolean hasGroupsSizeX(int[] deck) {

		if (deck.length < 2) {
			return false;
		}

		Map<Integer, Integer> result = new LinkedHashMap<>();

		for (int i = 0; i <= deck.length - 1; i++) {

			if (result.get(deck[i]) != null) {
				result.put(deck[i], result.get(deck[i]) + 1);

				continue;
			}
			result.put(deck[i], 1);
		}

		Set<Integer> finalResult = new HashSet<>();

		for (int i : result.keySet()) {
			if (result.get(i) % 2 == 0) {

				if (result.get(i) == 2) {
					finalResult.add(2);
					continue;
				}

				if (result.get(i) % 2 == 0) {
					finalResult.add(result.get(i) / 2);
					continue;
				}

				finalResult.add(result.get(i));
			} else if (result.get(i) % 3 == 0) {

				if (result.get(i) == 3) {
					finalResult.add(3);
					continue;
				}

				if (result.get(i) % 3 == 0) {
					finalResult.add(result.get(i) / 3);
					continue;
				}

				finalResult.add(result.get(i));
			} else {
				finalResult.add(result.get(i));
			}
		}

		if (finalResult.size() > 1) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		int deck[] = { 1, 1, 1, 1, 2, 2, 2, 2, 2, 2 };
		System.out.println(new Solution().hasGroupsSizeX(deck));

	}

}