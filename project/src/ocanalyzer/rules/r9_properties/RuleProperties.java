package ocanalyzer.rules.r9_properties;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ValidationHandlerImpl;
import ocanalyzer.rules.r9_properties.getter.GetterVisitor;
import ocanalyzer.rules.r9_properties.setter.SetterVisitor;

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
		ValidationHandlerImpl instanceValidationHandler = new PropertiesValidationHandler(
				iUnit, unit, reporter);
		GetterVisitor getterVisitor = new GetterVisitor(
				instanceValidationHandler);
		SetterVisitor setterVisitor = new SetterVisitor(
				instanceValidationHandler);
		unit.accept(getterVisitor);
		unit.accept(setterVisitor);
	}

}
