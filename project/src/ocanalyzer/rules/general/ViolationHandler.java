package ocanalyzer.rules.general;

import org.eclipse.jdt.core.dom.ASTNode;

public interface ViolationHandler {
	public abstract void printInfo(ASTNode node);
}