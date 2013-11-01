package wrapPrimitives.correct.db;

public class MainDB {

	public static void main(String[] args) {
		DBConfiguration configuration = new DBConfiguration("localhost", 2000,
				"asdf");
		String databaseName = configuration.getDatabaseName();
		System.out.println("DBName: " + databaseName);
	}

}
