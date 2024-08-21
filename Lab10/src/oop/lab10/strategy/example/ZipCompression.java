package oop.lab10.strategy.example;

public class ZipCompression implements CompressionStrategy {
    @Override
    public void compress(String fileName) {
        System.out.println("Compressing " + fileName + " using ZIP.");
    }
}
