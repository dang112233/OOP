package hus.oop.lab11.factorymethod.pseudocode;

public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
