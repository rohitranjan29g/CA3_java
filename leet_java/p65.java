
class Solution {
    public boolean isNumber(String s) {

        boolean digit = false;
        boolean dot = false;
        boolean exponent = false;
        boolean digitAfterE = true;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                digit = true;

                if (exponent) {
                    digitAfterE = true;
                }
            }

            else if (c == '+' || c == '-') {

                // Sign is allowed only at beginning or after e/E
                if (i > 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            else if (c == '.') {

                // Dot cannot appear after exponent or twice
                if (dot || exponent) {
                    return false;
                }

                dot = true;
            }

            else if (c == 'e' || c == 'E') {

                // Exponent requires a digit before it
                // and can appear only once
                if (exponent || !digit) {
                    return false;
                }

                exponent = true;
                digitAfterE = false;
            }

            else {
                return false;
            }
        }

        return digit && digitAfterE;
    }
}
