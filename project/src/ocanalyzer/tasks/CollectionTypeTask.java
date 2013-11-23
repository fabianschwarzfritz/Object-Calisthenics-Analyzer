package ocanalyzer.tasks;

import java.util.HashSet;
import java.util.List;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.factories.CollectionWrapperRulesFactory;
import ocanalyzer.rules.factories.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

class CollectionTypeTask extends WrapperTypeTask {

	public CollectionTypeTask(List<CompilationUnit> unitsToAnalyze,
			ClassReporter reporter) {
		super(unitsToAnalyze, reporter);
		wrappers = new HashSet<TypeDeclaration>();
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new CollectionWrapperRulesFactory(iCompilationUnit,
				compilationUnit, reporter, wrappers);
	}

}
