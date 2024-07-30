package assignments.controller;
import assignments.entity.User;
import assignments.service.WhatsappService;

import java.util.Scanner;

public class WhatsappControllerImpl implements WhatsappController {
	private Scanner sc = new Scanner(System.in);
    private final WhatsappService service;

    public WhatsappControllerImpl(WhatsappService service) {
        this.service = service;
    }

    @Override
    public void createProfile() {
    	User u = new User();
    	System.out.print("Enter username: ");
    	u.setName(sc.nextLine());
        System.out.print("Enter password: ");
        u.setPassword(sc.nextLine());
        System.out.print("Enter address: ");
        u.setAddress(sc.nextLine());
        System.out.print("Enter email: ");
        u.setEmail(sc.nextLine());
    	
    	if (service.createProfile(u)) System.out.println("Welcome to family");
        else System.out.println("There was a problem");
    }

    @Override
    public void edit() {
        System.out.println("let me introduce");
    }

    @Override
    public void view() {
        var user = service.currentUser();
        if (user != null) {
            System.out.printf("User details username: %s,\nemail %s,\naddress: %s", user.getName(), user.getEmail(), user.getAddress());
        } else System.out.println("Login and try again");
    }

    @Override
    public void search() {
        System.out.print("Enter profile name: ");
        var find = sc.next();
        if (service.searchProfile(find)) {
            System.out.println("Found");
        } else System.out.println("Not found");
    }	

    @Override
    public void login() {
        System.out.print("Enter username: ");
        var username = sc.next();
        System.out.print("Enter password: ");
        var password = sc.next();
        var logged = service.login(username, password);
        if (logged) System.out.println("Login successfully");
        else System.out.println("Login failed");
    }

    @Override
    public void logout() {
    	service.logout();
        System.out.println("Logout successfully");
    }
}
