package ocanalyzer.rules.general;

import org.eclipse.jdt.core.ICompilationUnit;

public interface ICompilationUnitEvent {

	public void push(ICompilationUnit unit);

}
