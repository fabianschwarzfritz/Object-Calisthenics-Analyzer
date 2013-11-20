package ocanalyzer.tasks;

import java.util.List;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.dom.CompilationUnit;

abstract class ValidationTask implements Executable {

	private List<CompilationUnit> unitsToAnalyze;
	protected ClassReporter reporter;

	public ValidationTask(List<CompilationUnit> unitsToAnalyze,
			ClassReporter reporter) {
		super();
		this.unitsToAnalyze = unitsToAnalyze;
		this.reporter = reporter;
	}

	@Override
	public void execute() {
		validate(unitsToAnalyze);
	}

	public abstract RuleFactory createRuleFactory(
			ICompilationUnit iCompilationUnit, CompilationUnit compilationUnit);

	protected void validate(List<CompilationUnit> unitsToAnalyze) {
		for (CompilationUnit compilationUnit : unitsToAnalyze) {
			ITypeRoot typeRoot = compilationUnit.getTypeRoot();
			// This must be a ICompilationunit because nothing else was
			// extracted
			ICompilationUnit iCompilationUnit = (ICompilationUnit) typeRoot;
			RuleFactory ruleFactory = createRuleFactory(iCompilationUnit,
					compilationUnit);
			ruleFactory.createRules().validate();
		}
	}
}
