package ocanalyzer.rules;

import java.util.Set;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.r3_8_wrap.collections.UseCollectionViolationHandler;
import ocanalyzer.rules.r3_8_wrap.determinator.CollectionDeterminator;
import ocanalyzer.rules.r3_8_wrap.general.UseWrapperFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * This class is a {@link RuleFactory} creating all existing rules.
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class CollectionUsageRulesFactory extends RuleFactory {

	private UseWrapperFactory ruleFactory;

	public CollectionUsageRulesFactory(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter,
			Set<TypeDeclaration> types) {
		super(unit, compilationUnit, reporter);
		ValidationHandler validationHandler = new UseCollectionViolationHandler(
				unit, compilationUnit, reporter);
		ruleFactory = new UseWrapperFactory(unit, compilationUnit, reporter,
				types, validationHandler, new CollectionDeterminator());
	}

	@Override
	public Rules createRules() {
		Rules rules = new Rules(unit);
		rules.add(ruleFactory.create());
		return rules;
	}

}
