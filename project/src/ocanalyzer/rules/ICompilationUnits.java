package ocanalyzer.rules;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jdt.core.ICompilationUnit;

public class ICompilationUnits {

	private Collection<ICompilationUnit> units;

	public ICompilationUnits() {
		units = new ArrayList<ICompilationUnit>();
	}

	public void addAll(Collection<ICompilationUnit> unitsFrom) {
		units.addAll(unitsFrom);
	}

	public boolean add(ICompilationUnit e) {
		return units.add(e);
	}
	
	

}
