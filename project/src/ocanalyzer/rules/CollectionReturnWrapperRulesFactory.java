package ocanalyzer.rules;

import java.util.Set;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.wrap.collections.CollectionReturnViolationHandler;
import ocanalyzer.rules.wrap.determinator.CollectionDeterminator;
import ocanalyzer.rules.wrap.determinator.PrimitiveDeterminator;
import ocanalyzer.rules.wrap.general.ReturnWrapperFactory;
import ocanalyzer.rules.wrap.primitives.PrimitivesWrapperClassViolationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * This class is a {@link RuleFactory} creating all existing rules.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class CollectionReturnWrapperRulesFactory extends RuleFactory {

	private ReturnWrapperFactory ruleFactory;

	public CollectionReturnWrapperRulesFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, RuleViolationReporter reporter,
			Set<TypeDeclaration> types) {
		super(unit, compilationUnit, reporter);
		ValidationHandler validationHandler = new CollectionReturnViolationHandler(
				unit, compilationUnit, reporter);
		ruleFactory = new ReturnWrapperFactory(unit, compilationUnit, reporter,
				types, validationHandler, new CollectionDeterminator());
	}

	@Override
	public Rules createRules() {
		Rules rules = new Rules(unit);
		rules.add(ruleFactory.create());
		return rules;
	}

}
