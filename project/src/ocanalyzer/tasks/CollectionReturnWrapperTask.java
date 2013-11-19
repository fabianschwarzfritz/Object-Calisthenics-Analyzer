package ocanalyzer.tasks;

import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.CollectionReturnWrapperRulesFactory;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

class CollectionReturnWrapperTask extends WrapperReturnTask {

	public CollectionReturnWrapperTask(List<CompilationUnit> unitsToAnalyze,
			Reporter reporter, Set<TypeDeclaration> wrappers) {
		super(unitsToAnalyze, reporter);
		super.wrappers = wrappers;
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new CollectionReturnWrapperRulesFactory(iCompilationUnit,
				compilationUnit, reporter, wrappers);
	}

}
