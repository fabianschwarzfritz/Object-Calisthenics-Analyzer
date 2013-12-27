package ocanalyzer.rules.r3_8_wrap.collections;

import java.util.HashSet;
import java.util.Set;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ClassOCRuleImpl;
import ocanalyzer.rules.general.ViolationHandlerImpl;
import ocanalyzer.rules.r3_8_wrap.determinator.CollectionDeterminator;
import ocanalyzer.rules.r3_8_wrap.general.ReturnVisitor;
import ocanalyzer.rules.r3_8_wrap.general.WrapperVisitor;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;
//TODO documentation
public class RuleWrapCollections extends ClassOCRuleImpl {

	private ClassReporter reporter;

	public RuleWrapCollections(ClassReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void applyIntentiationRule(ICompilationUnit iUnit,
			CompilationUnit unit) {
		Set<TypeDeclaration> wrapperTypes = determineWrapperTypes(iUnit, unit);
		searchNonWrapperUsage(wrapperTypes, iUnit, unit);
	}

	private void searchNonWrapperUsage(Set<TypeDeclaration> wrapperTypes,
			ICompilationUnit iUnit, CompilationUnit unit) {
		ViolationHandlerImpl instanceValidationHandler = new CollectionReturnViolationHandler(
				iUnit, unit, reporter);
		ReturnVisitor visitor = new ReturnVisitor(instanceValidationHandler,
				wrapperTypes, new CollectionDeterminator());
		unit.accept(visitor);
	}

	private Set<TypeDeclaration> determineWrapperTypes(ICompilationUnit iUnit,
			CompilationUnit unit) {
		Set<TypeDeclaration> wrappers = new HashSet<TypeDeclaration>();

		ViolationHandlerImpl instanceValidationHandler = new CollectionWrapperClassViolationHandler(
				iUnit, unit, reporter);
		WrapperVisitor visitor = new WrapperVisitor(instanceValidationHandler,
				wrappers, new CollectionDeterminator());
		// FIXME does this really already trigger all visits, and are there
		// already all wrapper types in there after calling this?
		unit.accept(visitor);

		return wrappers;
	}

}
