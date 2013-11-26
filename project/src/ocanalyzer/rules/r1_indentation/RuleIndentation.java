package ocanalyzer.rules.r1_indentation;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ICompilationUnits;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class RuleIndentation extends ClassOCRuleImpl {

	private ClassReporter reporter;

	public RuleIndentation(ClassReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ValidationHandler instanceValidationHandler = new IndentationValidationHandler(
				iUnit, unit, reporter);
		IndentationVisitor visitor = new IndentationVisitor(
				instanceValidationHandler);
		unit.accept(visitor);
	}

}
