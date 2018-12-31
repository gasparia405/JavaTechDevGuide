public class SumNumbers {
    public static void main(String[] args) {
        System.out.println(sumNumbers("as12dfkl18jna34ds"));
    }

    private static int sumNumbers(String s) {
        char[] cArray = s.toCharArray();
        StringBuilder consecNumbers = new StringBuilder();
        Integer parsedNumber;
        int sumTotal = 0;

        for (char c : cArray) {
            // Try to parse char as Integer
            // If integer, add c to string consecNumbers, which will
            // be added to intArray once we hit a non-integer
            try {
                Integer cInt = Integer.parseInt(Character.toString(c));

                consecNumbers.append(c);

            } catch (NumberFormatException e) {

                if (consecNumbers != null && consecNumbers.length() != 0) {
                    parsedNumber = Integer.parseInt(consecNumbers.toString());

                    sumTotal += parsedNumber;

                    consecNumbers.setLength(0);
                }

            }
        }

        return sumTotal;
    }
}
