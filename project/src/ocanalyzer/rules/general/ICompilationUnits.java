package ocanalyzer.rules.general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jdt.core.ICompilationUnit;

public class ICompilationUnits {

	private List<ICompilationUnit> units;

	public ICompilationUnits() {
		units = new ArrayList<ICompilationUnit>();
	}

	public void addAll(ICompilationUnits units) {
		addAll(units.units);
	}

	private void addAll(Collection<ICompilationUnit> unitsFrom) {
		units.addAll(unitsFrom);
	}

	public boolean add(ICompilationUnit e) {
		return units.add(e);
	}

	public void each(ICompilationUnitEvent event) {
		for (ICompilationUnit unit : units) {
			event.push(unit);
		}
	}
}
