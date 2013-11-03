package ocanalyzer.rules.task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.PrimitiveWrapperRulesFactory;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class PrimitiveTypeTask extends ValidationTask implements
		RuleFactoryProvider {

	private Set<TypeDeclaration> wrappers;

	public PrimitiveTypeTask(List<CompilationUnit> unitsToAnalyze,
			RuleViolationReporter reporter) {
		super(unitsToAnalyze, reporter);
		wrappers = new HashSet<TypeDeclaration>();
	}

	@Override
	public void execute() {
		wrappers = new HashSet<TypeDeclaration>();

		new UnitsValidator().validate(unitsToAnalyze, this);
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new PrimitiveWrapperRulesFactory(iCompilationUnit,
				compilationUnit, reporter, wrappers);
	}

	public Set<TypeDeclaration> getWrappers() {
		return new HashSet<TypeDeclaration>(wrappers);
	}

}
