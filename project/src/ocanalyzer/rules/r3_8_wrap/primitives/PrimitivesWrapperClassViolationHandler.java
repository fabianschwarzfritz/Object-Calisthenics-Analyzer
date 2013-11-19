package ocanalyzer.rules.r3_8_wrap.primitives;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class PrimitivesWrapperClassViolationHandler extends ValidationHandler {

	public PrimitivesWrapperClassViolationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, Reporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "The use of more than one instance variable in primitives wrapper classes violates rule 3";
		reportError(msg, node);
	}
}
