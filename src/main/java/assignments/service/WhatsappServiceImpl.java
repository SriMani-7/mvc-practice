package assignments.service;

import assignments.dao.WhatsappDao;
import assignments.entity.User;

public class WhatsappServiceImpl implements WhatsappService {
	private final WhatsappDao dao;
	
	public WhatsappServiceImpl(WhatsappDao dao) {
		this.dao = dao;
	}

    @Override
    public boolean createProfile(User u) {
    	return dao.addUser(u);
    }

    @Override
    public User currentUser() {
        return dao.currentUser();
    }

	@Override
	public boolean login(String username, String password) {
		return dao.login(username, password);
	}

	@Override
	public void logout() {
		dao.logout();
	}

	@Override
	public boolean searchProfile(String find) {
		return dao.searchProfile(find);
	}
}
