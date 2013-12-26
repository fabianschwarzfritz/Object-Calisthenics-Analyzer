package ocanalyzer.rules.r9_properties;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.r9_properties.getter.GetterVisitor;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class RuleProperties extends ClassOCRuleImpl {

	private ClassReporter reporter;

	public RuleProperties(ClassReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ValidationHandler instanceValidationHandler = new PropertiesValidationHandler(
				iUnit, unit, reporter);
		GetterVisitor visitor = new GetterVisitor(instanceValidationHandler);
		unit.accept(visitor);
	}

}
