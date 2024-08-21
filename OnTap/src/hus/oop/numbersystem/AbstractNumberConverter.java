package hus.oop.numbersystem;

public abstract class AbstractNumberConverter implements NumberConverter {
    protected OriginalNumber originalNumber;  // Số gốc
    protected String convertedNumber;         // Số được chuyển đổi theo cơ số nào đó từ số gốc

    public AbstractNumberConverter(OriginalNumber originalNumber) {
        this.originalNumber = originalNumber;
        this.convertedNumber = "";
        this.originalNumber.addConverter(this);  // Register this converter with the original number
    }

    /**
     * Chuyển đổi số decimal từ hệ cơ số 10 thành số có hệ cơ số nào đó.
     * @param decimal
     * @return xâu ký tự biểu diễn một số trong hệ cơ số nào đó.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     *
     * Gợi ý: có thể sử dụng lớp trung gian BigInteger để thuận lợi hơn cho việc tính toán.
     */
    public abstract String decimalTo(String decimal);

    /**
     * Chuyển đổi số được biểu diễn trong originalNumber sang biểu diễn số trong hệ cơ số 10.
     * @return xâu ký tự biểu diễn một số trong hệ cơ số 10.
     *
     * Yêu cầu: sử dụng thuật toán Horner để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    public String toDecimal() {
        String number = originalNumber.getNumberPresentation();
        int radix = originalNumber.getRadix();
        int length = number.length();
        int decimalValue = 0;

        for (int i = 0; i < length; i++) {
            char digitChar = number.charAt(i);
            int digit = Character.digit(digitChar, radix);
            decimalValue = decimalValue * radix + digit;
        }

        return Integer.toString(decimalValue);
    }

    /**
     * Thực hiện chuyển đổi số từ biểu diễn số và hệ cơ số ban đầu trong originalNumber
     * sang số có hệ cơ số nào đó. Kết quả số được chuyển đổi được lưu trong biến
     * thành viên convertedNumber.
     */
    public void convert() {
        String decimalValue = toDecimal();
        convertedNumber = decimalTo(decimalValue);
    }

    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi.
     */
    @Override
    public void update() {
        convert();
    }

    /**
     * Hiển thị số theo định dạng a1a2...an(radix).
     */
    @Override
    public void display() {
        System.out.println(convertedNumber + "(" + originalNumber.getRadix() + ")");
    }
}
