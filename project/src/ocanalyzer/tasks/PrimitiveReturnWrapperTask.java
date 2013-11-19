package ocanalyzer.tasks;

import java.util.List;
import java.util.Set;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.PrimitiveReturnWrapperRulesFactory;
import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

class PrimitiveReturnWrapperTask extends WrapperReturnTask {

	public PrimitiveReturnWrapperTask(List<CompilationUnit> unitsToAnalyze,
			Reporter reporter, Set<TypeDeclaration> wrappers) {
		super(unitsToAnalyze, reporter);
		this.wrappers = wrappers;
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new PrimitiveReturnWrapperRulesFactory(iCompilationUnit,
				compilationUnit, reporter, wrappers);
	}

}
