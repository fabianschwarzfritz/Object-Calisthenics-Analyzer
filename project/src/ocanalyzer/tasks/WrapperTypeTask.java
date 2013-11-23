package ocanalyzer.tasks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.impl.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

abstract class WrapperTypeTask extends ValidationTask implements
		RuleFactoryProvider {

	protected Set<TypeDeclaration> wrappers;

	public WrapperTypeTask(List<CompilationUnit> unitsToAnalyze,
			ClassReporter reporter) {
		super(unitsToAnalyze, reporter);
	}

	public abstract RuleFactory createRuleFactory(
			ICompilationUnit iCompilationUnit, CompilationUnit compilationUnit);

	@Override
	public void execute() {
		wrappers = new HashSet<TypeDeclaration>();
		super.execute();
	}

	public Set<TypeDeclaration> getWrappers() {
		return new HashSet<TypeDeclaration>(wrappers);
	}

}
