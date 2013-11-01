package ocanalyzer.rules.task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.PrimitiveWrapperRulesFactory;
import ocanalyzer.rules.RuleFactory;
import ocanalyzer.rules.Rules;
import ocanalyzer.rules.wrapPrimitivesAndStrings.WrapPrimitivesVisitor;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class PrimitiveTypeTask extends ValidationTask {

	private Set<TypeDeclaration> wrappers;

	public PrimitiveTypeTask(List<CompilationUnit> unitsToAnalyze,
			RuleViolationReporter reporter) {
		super(unitsToAnalyze, reporter);
		wrappers = new HashSet<TypeDeclaration>();
	}

	@Override
	public void execute() {
		wrappers = new HashSet<TypeDeclaration>();

		for (CompilationUnit compilationUnit : unitsToAnalyze) {
			ITypeRoot typeRoot = compilationUnit.getTypeRoot();
			// This must be a ICompilationunit because nothing else was
			// extracted
			ICompilationUnit iCompilationUnit = (ICompilationUnit) typeRoot;
			RuleFactory ruleFactory = getRuleFactory(iCompilationUnit,
					compilationUnit);
			Rules rules = ruleFactory.createRules();
			rules.validate();
		}
	}

	protected RuleFactory getRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new PrimitiveWrapperRulesFactory(iCompilationUnit,
				compilationUnit, wrappers);
	}

	public Set<TypeDeclaration> getWrappers() {
		return new HashSet<TypeDeclaration>(wrappers);
	}

}
