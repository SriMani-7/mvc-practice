package assignments.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import assignments.entity.User;

public class MySqlDao implements WhatsappDao {

	private static final String url = "jdbc:mysql://localhost:3306/mvcprac";
	private static final String user = "root";
	private static final String password = "Mani88";

	@Override
	public boolean addUser(User u) {

		try {

			Connection connection = DriverManager.getConnection(url, user, password);

			var stmt = connection.prepareCall("insert into users values (?,?,?,?)");
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getPassword());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getAddress());
			int rows = stmt.executeUpdate();

			return rows > 0;
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public User currentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchProfile(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

}
