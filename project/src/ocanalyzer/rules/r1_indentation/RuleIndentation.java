package ocanalyzer.rules.r1_indentation;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * Rule: "Use only one level of Indentation per method".
 * 
 * @see IndentationVisitor for more information
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

public class RuleIndentation extends ClassOCRuleImpl {

	private ClassReporter reporter;

	public RuleIndentation(ClassReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ViolationHandlerImpl instanceValidationHandler = new IndentationViolationHandler(
				iUnit, unit, reporter);
		IndentationVisitor visitor = new IndentationVisitor(
				instanceValidationHandler);
		unit.accept(visitor);
	}

}
