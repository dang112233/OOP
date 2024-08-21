package oop.lab10.strategy.example;

public class FileContext {
    private CompressionStrategy compressionStrategy;

    public FileContext(CompressionStrategy compressionStrategy) {
        this.compressionStrategy = compressionStrategy;
    }

    public void executeCompression(String fileName) {
        compressionStrategy.compress(fileName);
    }

    public void setCompressionStrategy(CompressionStrategy compressionStrategy) {
        this.compressionStrategy = compressionStrategy;
    }
}
