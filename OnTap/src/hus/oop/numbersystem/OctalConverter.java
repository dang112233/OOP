package hus.oop.numbersystem;

public class OctalConverter extends AbstractNumberConverter {

    public OctalConverter(OriginalNumber originalNumber) {
        super(originalNumber);
        convert();
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 8.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 8.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        int decimalNumber = Integer.parseInt(decimal);
        StringBuilder octal = new StringBuilder();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 8;
            octal.insert(0, remainder);
            decimalNumber = decimalNumber / 8;
        }

        return octal.toString();
    }

    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal
     * số được chuyển đổi theo định dạng a1a2...an(8).
     */
    @Override
    public void update() {
        convert();
        display();
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(8).
     */
    @Override
    public void display() {
        System.out.println(convertedNumber + "(8)");
    }
}
