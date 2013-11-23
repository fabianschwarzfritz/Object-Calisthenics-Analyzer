package ocanalyzer.tasks;

import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.impl.CollectionReturnWrapperRulesFactory;
import ocanalyzer.rules.impl.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

class CollectionReturnWrapperTask extends WrapperReturnTask {

	public CollectionReturnWrapperTask(List<CompilationUnit> unitsToAnalyze,
			ClassReporter reporter, Set<TypeDeclaration> wrappers) {
		super(unitsToAnalyze, reporter);
		super.wrappers = wrappers;
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new CollectionReturnWrapperRulesFactory(iCompilationUnit,
				compilationUnit, reporter, wrappers);
	}

}
