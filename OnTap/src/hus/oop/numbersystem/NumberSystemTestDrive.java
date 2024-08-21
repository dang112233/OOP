package hus.oop.numbersystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSystemTestDrive {
    public static void main(String[] args) {
        /* Yêu cầu:

        - Sinh ngẫu nhiên 3 số bằng cách:
            - Cơ số radix là một số tự nhiên nằm trong đoạn [2, 16] được sinh ngẫu nhiên.
            - Xâu ký tự biểu diễn số được sinh ra bằng cách:
                + Độ dài số là một số tự nhiên nằm trong đoạn [10, 30] được sinh ra ngẫu nhiên.
                 + Mỗi chữ số được sinh ra bằng cách: sinh ra một chỉ số ngẫu nhiên nằm trong đoạn [0, radix - 1],
                  sau đó lấy tương ứng với chỉ số đó một chữ số nằm trong xâu "0123456789ABCDEF".

        - Mỗi lần sinh ra một số và một cơ số mới, thực hiện việc cập nhật và in ra các số được chuyển đổi
          tự động sang các số được biểu diễn trong hệ cơ số 2, 8, 16.

        - Thực hiện chạy chương trình để in ra terminal thông tin về các số ban đầu và các số chuyển đổi, ví dụ:
          Original number: 123456
          radix 12
          Binary: 1111111
          Octal: 7777777
          Hexadecimal: FFFFFF

          Original number: 456789
          radix 7
          Binary: 1111111
          Octal: 7777777
          Hexadecimal: FFFFFF

          Lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_NumberSystemConverter>.txt (Ví dụ, NguyenVanA_123456_NumberSystemConverter.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_NumberSystemConverter>.zip (Ví dụ, NguyenVanA_123456_NumberSystemConverter.zip),
          nộp lên classroom.
         */
        Random random = new Random();
        List<OriginalNumber> originalNumbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int radix = random.nextInt(15) + 2; // Radix in the range [2, 16]
            int length = random.nextInt(21) + 10; // Length in the range [10, 30]
            String numberPresentation = generateRandomNumberPresentation(radix, length, random);
            OriginalNumber originalNumber = new OriginalNumber(numberPresentation, radix);
            originalNumbers.add(originalNumber);

            // Create converters
            BinaryConverter binaryConverter = new BinaryConverter(originalNumber);
            OctalConverter octalConverter = new OctalConverter(originalNumber);
            HexadecimalConverter hexConverter = new HexadecimalConverter(originalNumber);

            // Add converters to the original number
            originalNumber.addConverter(binaryConverter);
            originalNumber.addConverter(octalConverter);
            originalNumber.addConverter(hexConverter);

            // Display the original and converted numbers
            System.out.println("Original number: " + numberPresentation);
            System.out.println("Radix: " + radix);
            binaryConverter.display();
            octalConverter.display();
            hexConverter.display();
            System.out.println();
        }
    }

    private static String generateRandomNumberPresentation(int radix, int length, Random random) {
        String digits = "0123456789ABCDEF";
        StringBuilder number = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int digitIndex = random.nextInt(radix);
            number.append(digits.charAt(digitIndex));
        }
        return number.toString();
    }
}
