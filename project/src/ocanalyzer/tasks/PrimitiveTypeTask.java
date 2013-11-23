package ocanalyzer.tasks;

import java.util.HashSet;
import java.util.List;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.impl.PrimitiveWrapperRulesFactory;
import ocanalyzer.rules.impl.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class PrimitiveTypeTask extends WrapperTypeTask {

	public PrimitiveTypeTask(List<CompilationUnit> unitsToAnalyze,
			ClassReporter reporter) {
		super(unitsToAnalyze, reporter);
		wrappers = new HashSet<TypeDeclaration>();
	}

	public RuleFactory createRuleFactory(ICompilationUnit iCompilationUnit,
			CompilationUnit compilationUnit) {
		return new PrimitiveWrapperRulesFactory(iCompilationUnit,
				compilationUnit, reporter, wrappers);
	}

}
