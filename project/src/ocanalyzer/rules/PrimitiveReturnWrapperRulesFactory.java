package ocanalyzer.rules;

import java.util.Set;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.wrap.determinator.PrimitiveDeterminator;
import ocanalyzer.rules.wrap.general.ReturnWrapperFactory;
import ocanalyzer.rules.wrap.primitives.PrimitivesReturnViolationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * This class is a {@link RuleFactory} creating all existing rules.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class PrimitiveReturnWrapperRulesFactory extends RuleFactory {

	private ReturnWrapperFactory ruleFactory;

	public PrimitiveReturnWrapperRulesFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter,
			Set<TypeDeclaration> types) {
		super(unit, compilationUnit, reporter);
		ValidationHandler validationHandler = new PrimitivesReturnViolationHandler(
				unit, compilationUnit, reporter);
		ruleFactory = new ReturnWrapperFactory(unit, compilationUnit, reporter,
				types, validationHandler, new PrimitiveDeterminator());
	}

	@Override
	public Rules createRules() {
		Rules rules = new Rules(unit);
		rules.add(ruleFactory.create());
		return rules;
	}

}
