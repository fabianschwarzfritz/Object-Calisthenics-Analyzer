package ocanalyzer.rules.r9_properties;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ViolationHandlerImpl;
import ocanalyzer.rules.r9_properties.getter.GetterVisitor;
import ocanalyzer.rules.r9_properties.setter.SetterVisitor;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * Visitor for rule: "Do not use any getter/setter/properties"
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

public class RuleProperties extends ClassOCRuleImpl {

	private Reporter reporter;

	public RuleProperties(Reporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ViolationHandlerImpl instanceviolationHandler = new PropertiesViolationHandler(
				iUnit, unit, reporter);
		GetterVisitor getterVisitor = new GetterVisitor(
				instanceviolationHandler);
		SetterVisitor setterVisitor = new SetterVisitor(
				instanceviolationHandler);
		unit.accept(getterVisitor);
		unit.accept(setterVisitor);
	}

}
