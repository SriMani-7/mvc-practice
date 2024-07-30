package assignments.service;

import assignments.entity.User;

public interface WhatsappService {
	boolean createProfile(User u);
	User currentUser();
	boolean login(String username, String password);
	void logout();

	boolean searchProfile(String find);
}

