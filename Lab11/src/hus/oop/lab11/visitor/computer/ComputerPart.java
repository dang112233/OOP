package hus.oop.lab11.visitor.computer;

public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
