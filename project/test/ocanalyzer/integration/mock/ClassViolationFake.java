package ocanalyzer.integration.mock;

import ocanalyzer.domain.Degree;
import ocanalyzer.domain.Message;
import ocanalyzer.domain.Name;
import ocanalyzer.domain.PositionInClass;
import ocanalyzer.domain.ViolationImpl;

import org.eclipse.core.resources.IResource;

public class ClassViolationFake extends ViolationImpl {

	private String resourceName;

	public ClassViolationFake(String resourceName, Integer line, String message) {
		super(new Name(message), new Message(message), Degree.MIDDLE,
				new PositionInClass(new NamedIResource(resourceName), line));
		this.resourceName = resourceName;
	}

	@Override
	public IResource getResource() {
		return new NamedIResource(resourceName);
	}

}
