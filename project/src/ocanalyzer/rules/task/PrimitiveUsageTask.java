package ocanalyzer.rules.task;

import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.PrimitiveUsageRulesFactory;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class PrimitiveUsageTask extends ValidationTask {

	private Set<TypeDeclaration> wrappers;

	public PrimitiveUsageTask(List<CompilationUnit> unitsToAnalyze,
			RuleViolationReporter reporter, Set<TypeDeclaration> wrappers) {
		super(unitsToAnalyze, reporter);
		this.wrappers = wrappers;
	}

	@Override
	public void execute() {
		validate(unitsToAnalyze);
	}

	public RuleFactory getRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new PrimitiveUsageRulesFactory(iCompilationUnit,
				compilationUnit, reporter, wrappers);
	}
}
