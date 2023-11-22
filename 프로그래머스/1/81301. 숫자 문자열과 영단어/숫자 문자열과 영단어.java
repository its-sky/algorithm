class Solution {
    public long solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chr = s.toCharArray();
        
        int i = 0;
        while (i < chr.length) {
            if (isNumber(chr[i])) sb.append(chr[i]);
            else {
                if (chr[i] == 'z') {
                    if (s.substring(i, i + 4).equals("zero")) {
                        sb.append("0");
                        i += 3;
                    }
                } else if (chr[i] == 'o') {
                    if (s.substring(i, i + 3).equals("one")) {
                        sb.append("1");
                        i += 2;
                    }
                } else if (chr[i] == 't') {
                    if (s.substring(i, i + 3).equals("two")) {
                        sb.append("2");
                        i += 2;
                    } else if (s.substring(i, i + 5).equals("three")) {
                        sb.append("3");
                        i += 4;
                    }
                } else if (chr[i] == 'f') {
                    if (s.substring(i, i + 4).equals("four")) {
                        sb.append("4");
                        i += 3;
                    } else if (s.substring(i, i + 4).equals("five")) {
                        sb.append("5");
                        i += 3;
                    }
                } else if (chr[i] == 's') {
                    if (s.substring(i, i + 3).equals("six")) {
                        sb.append("6");
                        i += 2;
                    } else if (s.substring(i, i + 5).equals("seven")) {
                        sb.append("7");
                        i += 4;
                    }
                } else if (chr[i] == 'e') {
                    if (s.substring(i, i + 5).equals("eight")) {
                        sb.append("8");
                        i += 4;
                    }
                } else if (chr[i] == 'n') {
                    if (s.substring(i, i + 4).equals("nine")) {
                        sb.append("9");
                        i += 3;
                    }
                }
            }
            i += 1;
        }
        
        return Long.parseLong(sb.toString());
    }
    
    private static boolean isNumber(char chr) {
        if (chr == '0' || chr == '1' || chr == '2' || chr == '3' || chr == '4' || chr == '5'
           || chr == '6' || chr == '7' || chr == '8' || chr == '9') return true;
        return false;
    }
}