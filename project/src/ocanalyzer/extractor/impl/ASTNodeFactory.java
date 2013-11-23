package ocanalyzer.extractor.impl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;

/**
 * This class is used to create the root {@link ASTNode} for the given
 * {@link ICompilationUnit}
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class ASTNodeFactory {
	public ASTNode parse(ICompilationUnit unit) {
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(unit);
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		return parser.createAST(null);
	}
}
