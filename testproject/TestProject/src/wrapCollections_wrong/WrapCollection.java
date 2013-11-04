package wrapCollections_wrong;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WrapCollection {

	private List<Integer> collection = new ArrayList<Integer>();

	public Collection<Integer> getCollection() {
		return collection;
	}

}
