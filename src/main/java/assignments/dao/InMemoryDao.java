package assignments.dao;

import java.util.ArrayList;
import java.util.List;

import assignments.entity.User;

public class InMemoryDao implements WhatsappDao {
	private final List<User> users = new ArrayList<>();
	private User currentUser;

	@Override
	public boolean addUser(User u) {
		var hasUser = users.stream().anyMatch(user -> user.getName().equals(u.getName()));
		if (!hasUser) {
			users.add(u);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User currentUser() {
		return currentUser;
	}

	@Override
	public boolean login(String name, String password) {
		for (User u : users) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				currentUser = u;
			}
		}

		return currentUser != null;
	}

	@Override
	public boolean searchProfile(String name) {
		return users.stream().anyMatch(user -> user.getName().equals(name));
	}

	@Override
	public void logout() {
		currentUser = null;
	}

}
