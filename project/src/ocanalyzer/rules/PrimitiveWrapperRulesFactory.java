package ocanalyzer.rules;

import java.util.Set;

import ocanalyzer.reporter.NoReporter;
import ocanalyzer.rules.wrapPrimitivesAndStrings.WrapPrimitivesFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * This class is a {@link RuleFactory} creating all existing rules.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class PrimitiveWrapperRulesFactory extends RuleFactory {

	private WrapPrimitivesFactory ruleFactory;

	public PrimitiveWrapperRulesFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, Set<TypeDeclaration> types) {
		// The fact if the class is a wrapper class or not, is never reported
		super(unit, compilationUnit, new NoReporter());
		ruleFactory = new WrapPrimitivesFactory(unit, compilationUnit,
				reporter, types);
	}

	@Override
	public Rules createRules() {
		Rules rules = new Rules(unit);
		rules.add(ruleFactory.create());
		return rules;
	}

}
