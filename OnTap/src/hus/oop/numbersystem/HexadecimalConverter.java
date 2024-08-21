package hus.oop.numbersystem;

public class HexadecimalConverter extends AbstractNumberConverter {

    public HexadecimalConverter(OriginalNumber originalNumber) {
        super(originalNumber);
        convert();
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 16.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 16.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        int decimalNumber = Integer.parseInt(decimal);
        StringBuilder hex = new StringBuilder();
        String hexDigits = "0123456789ABCDEF";

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 16;
            hex.insert(0, hexDigits.charAt(remainder));
            decimalNumber = decimalNumber / 16;
        }

        return hex.toString();
    }

    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal
     * số được chuyển đổi theo định dạng a1a2...an(16).
     */
    @Override
    public void update() {
        convert();
        display();
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(16).
     */
    @Override
    public void display() {
        System.out.println(convertedNumber + "(16)");
    }
}
