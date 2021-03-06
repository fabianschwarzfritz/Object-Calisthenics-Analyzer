package ocanalyzer.domain;

import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IPackageFragment;

public class ViolationFactory {

	public static ViolationImpl createClassViolation(String rulename,
			IResource resource, Integer line, String message) {
		Name name = new Name(rulename);
		Message messageO = new Message(message);
		Position position = new PositionInClass(resource, line);
		return new ViolationImpl(name, messageO, Degree.MIDDLE, position);
	}

	public static ViolationImpl createPackageViolation(
			IPackageFragment fragment, String message) {
		Name name = new Name(message);
		Message messageO = new Message(message);
		Position position = new PositionInPackage(fragment);
		return new ViolationImpl(name, messageO, Degree.MIDDLE, position);
	}
}
