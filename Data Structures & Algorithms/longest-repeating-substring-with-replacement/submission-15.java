class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 1 || k + 1 >= s.length())
            return s.length();
        int max = 0;
        int i = 0;
        char[] charr = s.toCharArray();

        while (i < charr.length) {
            System.out.println(i);
            if (max  >= charr.length - i && charr.length - i + k < max) {
                return max;
            }
            int pomMax = 1;
            int pomK = k;
            while ((i + 1 < charr.length && charr[i] == charr[i + 1])) {
                i++;
                pomMax++;
                if (max < pomMax)
                    max = pomMax;
            }
            int j = i + 1;
            System.out.println(i);
            while (pomK >= 0 && j < charr.length) {
                if (charr[j] == charr[i]) {
                    pomMax++;
                    j++;

                } else {
                    pomK--;
                    j++;
                    if (pomK >= 0)
                        pomMax++;
                }
                if (pomMax > max) {
                    max = pomMax;
                }
            }
            System.out.print("k = " + pomK+ " pomMax = " + pomMax +" max = " + max);
            if(pomK + pomMax > max){
                if(pomK + pomMax > charr.length) max = charr.length;
                else
                max = pomK + pomMax;
            }
            i++;
        }

        return max;
    }
}
