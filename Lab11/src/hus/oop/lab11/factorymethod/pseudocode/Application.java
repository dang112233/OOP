package hus.oop.lab11.factorymethod.pseudocode;

public class Application {
    private Dialog dialog;

    public void initialize() {
        String configOS = readApplicationConfigFile();

        if ("Windows".equals(configOS)) {
            dialog = new WindowsDialog();
        } else if ("Web".equals(configOS)) {
            dialog = new WebDialog();
        } else {
            throw new RuntimeException("Error! Unknown operating system.");
        }
    }

    public void main() {
        initialize();
        dialog.render();
    }

    private String readApplicationConfigFile() {
        return "Windows";
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.main();
    }
}