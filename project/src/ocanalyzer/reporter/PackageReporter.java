package ocanalyzer.reporter;

public interface PackageReporter {

	public abstract void reportError(PackageViolation violation);

}
