package ocanalyzer.rules.neu.wrap;

import java.util.HashMap;
import java.util.Map;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ViolationHandlerImpl;
import ocanalyzer.rules.r3_8_wrap.determinator.PrimitiveDeterminator;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class RuleWrapNew extends ClassOCRuleImpl {

	private ClassReporter reporter;

	public RuleWrapNew(ClassReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		Map<TypeDeclaration, Type> wrappers = new HashMap<TypeDeclaration, Type>();
		WrapperVisitor wrapperVisitor = new WrapperVisitor(wrappers, new PrimitiveDeterminator());
		unit.accept(wrapperVisitor);
		
		ViolationHandlerImpl instanceViolationHandler = new WrapNewViolationHandler(
				iUnit, unit, reporter);
		WrapNewVisitor usageVisitor = new WrapNewVisitor(
				instanceViolationHandler, wrappers);
		unit.accept(usageVisitor);
	}
}