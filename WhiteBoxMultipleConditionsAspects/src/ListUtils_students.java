

import java.util.ArrayList;

public class ListUtils_students {
	public static int findName(ArrayList<String> list, String name) {
		int i = 0;
		while(list.get(i).equals(name) && i<= list.size()) i++;
		
		if(i>=list.size()) return -1;
			
		return i;
	}
}
