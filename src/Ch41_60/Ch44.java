package Ch41_60;

/**
 * Created by hadoop on 2015/6/10 0010.
 */
public class Ch44 {
    public boolean isMatch(String s, String p) {
        if(s==null||p==null)
            return false;
        return match(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    public boolean match(char[] s,char[] p,int bs,int bp){
        if(bs==s.length&&bp==p.length)
            return true;
        if(bs!=s.length&&bp==p.length)
            return false;
        if(bs>s.length)
            return  false;
        if(bp<p.length-1&&p[bp+1]=='*'){
            if(bs<s.length&&s[bs]==p[bp]||p[bp]=='?'){
                return match(s, p, bs+1, bp+2)
                        ||match(s, p, bs+1, bp)
                        ||match(s, p, bs, bp+2);

            }else{
                return match(s, p, bs, bp+2);
            }
        }
        if(bp<p.length&&bs<s.length){
            if(p[bp]==s[bs]||p[bp]=='?'){
                return match(s, p, bs+1, bp+1);
            }
        }
        return false;
    }
}
