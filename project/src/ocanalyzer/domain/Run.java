package ocanalyzer.domain;

public interface Run {

	public abstract Run update();

	public abstract int countViolations();
}
