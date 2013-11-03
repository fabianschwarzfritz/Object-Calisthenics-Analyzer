package ocanalyzer.rules.task;

import java.util.List;

import ocanalyzer.rules.RuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class UnitsValidator {

	protected void validate(List<CompilationUnit> unitsToAnalyze,
			RuleFactoryProvider factoryProvider) {
		for (CompilationUnit compilationUnit : unitsToAnalyze) {
			ITypeRoot typeRoot = compilationUnit.getTypeRoot();
			// This must be a ICompilationunit because nothing else was
			// extracted
			ICompilationUnit iCompilationUnit = (ICompilationUnit) typeRoot;
			RuleFactory ruleFactory = factoryProvider.createRuleFactory(
					iCompilationUnit, compilationUnit);
			ruleFactory.createRules().validate();
		}
	}

}
