package ocanalyzer.rules.r6_small;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * Visitor for rule: "Keep all entities small"
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

public class RuleSmallEntities extends ClassOCRuleImpl {

	private ClassReporter reporter;

	public RuleSmallEntities(ClassReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ViolationHandlerImpl instanceviolationHandler = new SmallViolationHandler(
				iUnit, unit, reporter);
		SmallVisitor visitor = new SmallVisitor(instanceviolationHandler);
		unit.accept(visitor);
	}

}
