package telran.interviews;

import java.util.*;

public class InterviewQuestions {
	public static void displayOccurrences(String[] strings) {
		HashMap<String, Integer> mapOccurrences = getOccurrencesMap(strings);
		TreeMap<Integer, TreeSet<String>> treeMapOccurrences = getTreeMapOccurrences(mapOccurrences);
		displayOccurrences(treeMapOccurrences);
	}

	private static void displayOccurrences(TreeMap<Integer, TreeSet<String>> treeMapOccurrences) {
		treeMapOccurrences.entrySet().forEach(e -> {
			e.getValue().forEach(str -> System.out.printf("%s => %d\n", str, e.getKey()));
		});

	}

	private static TreeMap<Integer, TreeSet<String>> getTreeMapOccurrences(HashMap<String, Integer> mapOccurrences) {
		TreeMap<Integer, TreeSet<String>> result = new TreeMap<Integer, TreeSet<String>>(Comparator.reverseOrder());
		mapOccurrences.entrySet()
				.forEach(e -> result.computeIfAbsent(e.getValue(), k -> new TreeSet<>()).add(e.getKey()));

		return result;
	}

	private static HashMap<String, Integer> getOccurrencesMap(String[] strings) {
		HashMap<String, Integer> result = new HashMap<>();
		for (String str : strings) {
			result.merge(str, 1, Integer::sum);
		}
		return result;
	}

	static public boolean isSum2(int[] array, int sum) {
		Set<Integer> hashSet = hashSetSetup(array);
		Iterator<Integer> it = hashSet.iterator();
		boolean sumFound = false;
		while (it.hasNext() && !sumFound) {
			sumFound = hashSet.contains(sum - it.next());
		}
		return sumFound;
	}

	static public int getMaxWithNegativePresentation(int[] array) {
		Set<Integer> hashSet = hashSetSetup(array);
		int maxValue = -1;
		for (int i : hashSet) {
			if (hashSet.contains(-i) && Math.abs(i) > maxValue) {
				maxValue = Math.abs(i);
			}
		}
		return maxValue;
	}

	private static Set<Integer> hashSetSetup(int[] array) {
		Set<Integer> hashSet = new HashSet<>();
		for (Integer e : array) {
			hashSet.add(e);
		}
		return hashSet;
	}
}
