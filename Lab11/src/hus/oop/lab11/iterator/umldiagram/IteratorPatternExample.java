package hus.oop.lab11.iterator.umldiagram;

public class IteratorPatternExample {
    public static void main(String[] args) {
        ProductCatalog productCatalog = new ProductCatalog();
        Iterator iterator = productCatalog.getIterator();
        while (iterator.hasNext()) {
            System.out.println("Product Name: " + iterator.next());
        }
    }
}
