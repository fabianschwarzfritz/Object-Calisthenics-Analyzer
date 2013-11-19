package ocanalyzer.rules;

import java.util.Set;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.r3_8_wrap.WrapTypeFactory;
import ocanalyzer.rules.r3_8_wrap.collections.CollectionReturnViolationHandler;
import ocanalyzer.rules.r3_8_wrap.determinator.CollectionDeterminator;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * This class is a {@link RuleFactory} creating all existing rules.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class CollectionWrapperRulesFactory extends RuleFactory {

	private WrapTypeFactory ruleFactory;

	public CollectionWrapperRulesFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter,
			Set<TypeDeclaration> types) {
		super(unit, compilationUnit, reporter);
		ValidationHandler validationHandler = new CollectionReturnViolationHandler(
				unit, compilationUnit, reporter);
		ruleFactory = new WrapTypeFactory(unit, compilationUnit, reporter,
				types, validationHandler, new CollectionDeterminator());
	}

	@Override
	public Rules createRules() {
		Rules rules = new Rules(unit);
		rules.add(ruleFactory.create());
		return rules;
	}

}
