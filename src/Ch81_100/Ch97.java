package Ch81_100;

/**
 * Created by hadoop on 2015/6/3 0003.
 */
public class Ch97 {
    //    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s1 == null || s2 == null || s3 == null)
//            return false;
//        if (s3.equals("")) {
//            if (s1.equals("") && s2.equals(""))
//                return true;
//            else
//                return false;
//        } else {
//            if (s2.equals("")) {
//                if (!s1.equals(s3))
//                    return false;
//                else
//                    return true;
//            }
//            if (s1.equals("")) {
//                if (!s2.equals(s3))
//                    return false;
//                else
//                    return true;
//            }
//        }
//        int p1 = 0;
//        int p2 = 0;
//        int p3 = 0;
//
//        int t1 = findStartSame(s1, p1, s3, p3);
//        for (int i = t1; i >= 1; i--) {
//            int t2 = findStartSame(s2, p2, s3, p3 + i);
//            if (t2 < i && (p3 + i < s3.length() || p2 < s2.length()))
//                continue;
//            else {
//                boolean flag = isInterleave(s1.substring(p1 + i), s2.substring(p2 + i), s3.substring(p3 + i * 2));
//                if (flag)
//                    return true;
//            }
//        }
//        int t2 = findStartSame(s2, p2, s3, p3);
//        for (int i = t2; i >= 1; i--) {
//            t1 = findStartSame(s1, p1, s3, p3 + i);
//            if (t1 < i && (p3 + i < s3.length() || p1 < s1.length()))
//                continue;
//            else {
//                boolean flag = isInterleave(s1.substring(p1 + i), s2.substring(p2 + i), s3.substring(p3 + i * 2));
//                if (flag)
//                    return true;
//            }
//        }
//        if (t1 < 0 && t2 < 0)
//            return false;
//
//        if (p1 < s1.length() || p2 < s2.length())
//            return false;
//        return false;
//    }
//

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        if(s1.length()+s2.length()!=s3.length())
            return false;
       boolean[][] isIntered = new boolean[s2.length()+1][s1.length()+1];
        isIntered[0][0] =true;
        for(int i=1;i<=s1.length();i++){
            if(s1.charAt(i-1)==s3.charAt(i-1)&&isIntered[0][i-1])
                isIntered[0][i] = true;
        }
        for(int i=1;i<=s2.length();i++){
            if(s2.charAt(i-1)==s3.charAt(i-1)&&isIntered[i-1][0])
                isIntered[i][0] =true ;
        }

        for(int i=1;i<=s2.length();i++){
            for(int j=1;j<=s1.length();j++){
                if((s3.charAt(i+j-1)==s1.charAt(j-1)&&isIntered[i][j-1])||(s3.charAt(i+j-1)==s2.charAt(i-1)&&isIntered[i-1][j]))
                    isIntered[i][j] =true;
            }
        }
        return isIntered[s2.length()][s1.length()];
    }



    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "ab";
        String s3 = "aaba";
//        System.out.println(new Ch97().isInterleave(s1, s2, s3) + ", 1 true");
        s1 = "db";
        s2 = "b";
        s3 = "cbb";
        System.out.println(new Ch97().isInterleave(s1, s2, s3) + ", 2 false");
        s1 = "a";
        s2 = "";
        s3 = "a";
        System.out.println(new Ch97().isInterleave(s1, s2, s3) + ", 2 true");
        s1 = "";
        s2 = "a";
        s3 = "a";
        System.out.println(new Ch97().isInterleave(s1, s2, s3) + ",3  true");
        s1 = "";
        s2 = "a";
        s3 = "";
        System.out.println(new Ch97().isInterleave(s1, s2, s3) + ",4 false");
        s1 = "a";
        s2 = "b";
        s3 = "ab";
        System.out.println(new Ch97().isInterleave(s1, s2, s3) + ",4 true");
        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbcbcac";
        System.out.println(new Ch97().isInterleave(s1, s2, s3) + ",5 true");
        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";
        System.out.println(new Ch97().isInterleave(s1, s2, s3) + ",6 false");
        s1 = "aa";
        s2 = "ab";
        s3 = "abaa";
        System.out.println(new Ch97().isInterleave(s1, s2, s3) + ",7 true");
        s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        s3 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaababaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        System.out.println(new Ch97().isInterleave(s1, s2, s3) + ",8 true");
        s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
        System.out.println(new Ch97().isInterleave(s1, s2, s3) + ",9 flase");
    }
}
