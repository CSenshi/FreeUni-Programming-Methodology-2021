package s24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class FriendsList {

	private ConsoleProgram p;
	private Map<String, List<String>> map;
	private Map<String, List<String>> mapRev;

	public FriendsList(ConsoleProgram program) {
		p = program;
	}

	public void readInput() {
		map = new HashMap<>();
		mapRev = new HashMap<>();
		while (true) {
			String s = p.readLine();
			if (s.equals(""))
				break;

			StringTokenizer st = new StringTokenizer(s);
			if (st.countTokens() != 2) {
				p.println("Invalid names");
				continue;
			}
			String nameA = st.nextToken();
			String nameB = st.nextToken();

			if (!map.containsKey(nameB)) {
				map.put(nameB, new ArrayList<>());
			}
			map.get(nameB).add(nameA);

			if (!mapRev.containsKey(nameA)) {
				mapRev.put(nameA, new ArrayList<>());
			}
			mapRev.get(nameA).add(nameB);
		}
	}

	/** Ex63 */
	public String mostPopular() {
		int maxFriendsCount = 0;
		String name = null;
		for (String s : map.keySet()) {
			List<String> friends = map.get(s);
			if (friends.size() > maxFriendsCount) {
				maxFriendsCount = friends.size();
				name = s;
			}
		}
		return name;
	}

	/** Ex64 */
	public void printFriends() {
		for (Entry<String, List<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			List<String> value = entry.getValue();

			p.println(key + " = " + value);
		}
	}

	/** Ex 65 */
	public String mostFriendly() {
		int maxFriendsCount = 0;
		String name = null;
		for (String s : mapRev.keySet()) {
			List<String> friends = mapRev.get(s);
			if (friends.size() > maxFriendsCount) {
				maxFriendsCount = friends.size();
				name = s;
			}
		}
		return name;
	}

	/** Ex 66 */
	public List<String> usersWithNoMutualFriends() {
		List<String> result = new ArrayList<>();
		for (Entry<String, List<String>> entry1 : map.entrySet()) {
			for (Entry<String, List<String>> entry2 : map.entrySet()) {
				String name1 = entry1.getKey();
				String name2 = entry2.getKey();
				List<String> l1 = entry1.getValue();
				List<String> l2 = entry2.getValue();

				boolean hasMutualFriends = false;

				for (String friendName : l1) {
					if (l2.contains(friendName)) {
						hasMutualFriends = true;
						break;
					}
				}

				if (!hasMutualFriends) {
					if (!result.contains(name1 + ":" + name2) && !result.contains(name2 + ":" + name1)) {
						result.add(name1 + ":" + name2);
					}
				}
			}
		}
		return result;
	}

}
