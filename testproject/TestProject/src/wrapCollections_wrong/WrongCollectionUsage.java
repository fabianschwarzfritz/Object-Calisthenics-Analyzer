package wrapCollections_wrong;

import java.util.ArrayList;
import java.util.List;

public class WrongCollectionUsage {
	public void method() {
		List<Integer> l = new ArrayList<Integer>();
		int i = 3;
	}
}
