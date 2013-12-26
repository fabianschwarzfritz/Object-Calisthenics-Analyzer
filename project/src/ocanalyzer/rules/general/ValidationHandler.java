package ocanalyzer.rules.general;

import org.eclipse.jdt.core.dom.ASTNode;

public interface ValidationHandler {
	public abstract void printInfo(ASTNode node);
}