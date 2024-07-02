import java.util.*;

class Solution {

	static Set<String> currSet;
	static Set<Set<String>> resSet;

	public static int solution(String[] user_id, String[] banned_id) {

		// 초기화 안했음
		currSet = new HashSet<>();
		resSet = new HashSet<>();

		// 백트랙킹으로 모든경우의수

		List<List<String>> matchingIds = new ArrayList<>();

		for (String pattern : banned_id) {
			List<String> mathcingUsers = new ArrayList<>();

			for (String user : user_id) {
				if (IsMathced(user, pattern)) {
					mathcingUsers.add(user);
				}
			}
			matchingIds.add(mathcingUsers);
		}

		recur(matchingIds, 0);

		return resSet.size();

	}

	public static boolean IsMathced(String user, String pattern) {
		if (user.length() != pattern.length())
			return false;

		for (int i = 0; i < user.length(); i++) {
			if (pattern.charAt(i) != '*' && user.charAt(i) != pattern.charAt(i))
				return false;
		}
		return true;
	}

	public static void recur(List<List<String>> matchingIds, int index) {

		// 기저
		if (index == matchingIds.size()) {
			resSet.add(new HashSet<>(currSet));
			return;
		}

		// 반복
		for (String user : matchingIds.get(index)) {
			if (!currSet.contains(user)) {
				currSet.add(user);
				recur(matchingIds, index + 1);
				currSet.remove(user);
			}
		}
	}// recur
}