package ocanalyzer.rules.r3_8_wrap.primitives;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ViolationHandlerImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

class PrimitivesWrapperClassViolationHandler extends ViolationHandlerImpl {

	public PrimitivesWrapperClassViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "The use of more than one instance variable in primitives wrapper classes violates rule 3";
		reportError(msg, node);
	}
}
