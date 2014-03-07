package ocanalyzer.rules.r38_wrap;

import java.util.Map;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;

class RuleWrapNew extends ClassOCRuleImpl {

	private ClassReporter reporter;
	private TypeDeterminator determinator;

	public RuleWrapNew(ClassReporter reporter, TypeDeterminator determinator) {
		this.reporter = reporter;
		this.determinator = determinator;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		ViolationHandlerImpl instanceViolationHandler = new WrapNewViolationHandler(
				iUnit, unit, reporter);

		WrapperVisitor wrapperVisitor = new WrapperVisitor(determinator,
				instanceViolationHandler);
		unit.accept(wrapperVisitor);

		Map<TypeDeclaration, Type> wrappers = wrapperVisitor.wrapperUnits();

		WrapNewVisitor usageVisitor = new WrapNewVisitor(
				instanceViolationHandler, wrappers);
		unit.accept(usageVisitor);
	}
}