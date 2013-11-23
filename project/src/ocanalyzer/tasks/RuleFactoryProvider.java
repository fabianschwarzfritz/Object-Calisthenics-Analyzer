package ocanalyzer.tasks;

import ocanalyzer.rules.impl.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public interface RuleFactoryProvider {

	public abstract RuleFactory createRuleFactory(
			ICompilationUnit iCompilationUnit, CompilationUnit compilationUnit);

}
