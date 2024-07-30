package assignments.view;

import assignments.controller.WhatsappController;
import assignments.controller.WhatsappControllerImpl;
import assignments.dao.InMemoryDao;
import assignments.service.WhatsappServiceImpl;

import java.util.Scanner;

public class WhatsappView {
    public static void main(String[] args) {
        System.out.println("\n:::Here are list of available options:::");
        System.out.println("1. Create the profile");
        System.out.println("2. Edit profile");
        System.out.println("3. View profile");
        System.out.println("4. Search profile");
        System.out.println("5. Login");
        System.out.println("6. Logout");
        System.out.println("0. exist");

        Scanner sc = new Scanner(System.in);

        WhatsappController controller = new WhatsappControllerImpl(new WhatsappServiceImpl(new InMemoryDao()));

        do {
            System.out.print("> Enter your option: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    controller.createProfile();
                    break;
                case 2:
                    controller.edit();
                    break;
                case 3:
                    controller.view();
                    break;
                case 4:
                    controller.search();
                    break;
                case 5:
                    controller.login();
                    break;
                case 6:
                    controller.logout();
                    break;
                case 0:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("You entered invalid option");
            }
        } while (true);
    }
}
