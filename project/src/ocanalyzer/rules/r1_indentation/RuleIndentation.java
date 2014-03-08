package ocanalyzer.rules.r1_indentation;

import ocanalyzer.reporter.Reporter;
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

	private Reporter reporter;

	public RuleIndentation(Reporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ViolationHandlerImpl instanceViolationHandler = new IndentationViolationHandler(
				iUnit, unit, reporter);
		IndentationVisitor visitor = new IndentationVisitor(
				instanceViolationHandler);
		unit.accept(visitor);
	}

}
