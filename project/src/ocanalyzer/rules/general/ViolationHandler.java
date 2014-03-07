package ocanalyzer.rules.general;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Type;

public interface ViolationHandler {

	public abstract void printInfo(ASTNode node);

	public abstract void printInfo(ASTNode type, String customMessage);
}