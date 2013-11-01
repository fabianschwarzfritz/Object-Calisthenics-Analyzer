package wrapPrimitives.correct.db;

public class MainDB {

	public static void main(String[] args) {
		DBConfiguration configuration = new DBConfiguration(new HostName(
				"localhost"), new Port(2302), new DatabaseName("hallo"));
		DatabaseName databaseName = configuration.getDatabaseName();
		System.out.println("DBName: " + databaseName);
	}

}
