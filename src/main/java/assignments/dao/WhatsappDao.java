package assignments.dao;

import assignments.entity.User;

public interface WhatsappDao {
	boolean addUser(User u);
	User currentUser();

	boolean login(String name, String password);
	boolean searchProfile(String name);

	void logout();
}
