package ocanalyzer.tasks;

import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.impl.PrimitiveUsageRulesFactory;
import ocanalyzer.rules.impl.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

class PrimitiveUsageTask extends WrapperUsageTask {

	private Set<TypeDeclaration> wrappers;

	public PrimitiveUsageTask(List<CompilationUnit> unitsToAnalyze,
			ClassReporter reporter, Set<TypeDeclaration> wrappers) {
		super(unitsToAnalyze, reporter);
		this.wrappers = wrappers;
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new PrimitiveUsageRulesFactory(iCompilationUnit,
				compilationUnit, reporter, wrappers);
	}
}
