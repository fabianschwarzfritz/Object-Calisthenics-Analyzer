package ocanalyzer.tasks;

import java.util.List;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.dom.CompilationUnit;

public abstract class ValidationTask implements Executable {

	protected List<CompilationUnit> unitsToAnalyze;
	protected Reporter reporter;

	public ValidationTask(List<CompilationUnit> unitsToAnalyze,
			Reporter reporter) {
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
