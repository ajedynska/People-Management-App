import controller.PersonController;
import persistence.PersonPersistence;
import view.MainFrame;

public class Program {
    public static void main(String[] args) {
        PersonPersistence persistence = new PersonPersistence();
        PersonController controller = new PersonController(persistence);
        MainFrame mainFrame = new MainFrame(controller);
    }
}
