package ocanalyzer.rules.instanceVariable;

import java.util.Collection;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.Rule;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class RuleInstanceVariable extends Rule {

	private ClassReporter reporter;

	public RuleInstanceVariable(ClassReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void validate(Collection<ICompilationUnit> units) {
		for (ICompilationUnit iUnit : units) {
			CompilationUnit unit = createUnit(iUnit);
			applyIntentiationRule(iUnit, unit);
		}
	}

	private void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ValidationHandler instanceValidationHandler = new InstanceVariableValidationHandler(
				iUnit, unit, reporter);
		InstanceVariableVisitor visitor = new InstanceVariableVisitor(
				instanceValidationHandler);
		unit.accept(visitor);
	}
}
