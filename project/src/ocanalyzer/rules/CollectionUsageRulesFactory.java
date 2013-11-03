package ocanalyzer.rules;

import java.util.Set;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.wrap.useWrappers.UseWrapperFactory;
import ocanalyzer.rules.wrapCollections.useWrappers.UseCollectionViolationHandler;
import ocanalyzer.rules.wrapCollections.wrapperTypes.CollectionWrapperClassViolationHandler;
import ocanalyzer.rules.wrapPrimitivesAndStrings.useWrappers.UsePrimitivesViolationHandler;
import ocanalyzer.rules.wrapTypes.determinator.CollectionDeterminator;
import ocanalyzer.rules.wrapTypes.determinator.PrimitiveDeterminator;

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
			CompilationUnit compilationUnit, RuleViolationReporter reporter,
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
