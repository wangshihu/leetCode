package Ch01;

public class Ch10 {
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
			if(bs<s.length&&s[bs]==p[bp]||p[bp]=='.'){
				return match(s, p, bs+1, bp+2)
						||match(s, p, bs+1, bp)
						||match(s, p, bs, bp+2);
				
			}else{
				return match(s, p, bs, bp+2);
			}
		}
		if(bp<p.length&&bs<s.length){
			if(p[bp]==s[bs]||p[bp]=='.'){
				return match(s, p, bs+1, bp+1);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		String s = "aab";
		String p ="c*a*b";
		System.out.println(s+", "+p+" ,"+new Ch10().isMatch(s,p));
		s="ab";
		p=".*";
		System.out.println(s+", "+p+" ,"+new Ch10().isMatch(s,p));
		s="aa";
		p=".*";
		System.out.println(s+", "+p+" ,"+new Ch10().isMatch(s,p));

		s="aa";
		p="a";
		System.out.println(s+", "+p+" ,"+new Ch10().isMatch(s,p));
		s="aa";
		p="aa";
		System.out.println(s+", "+p+" ,"+new Ch10().isMatch(s,p));
		s="aaaaaa";
		p="a";
		System.out.println(s+", "+p+" ,"+new Ch10().isMatch(s,p));
		s="a";
		p="aaaaaaa";
		System.out.println(s+", "+p+" ,"+new Ch10().isMatch(s,p));
		s="a";
		p=".*c";
		System.out.println(s+", "+p+" ,"+new Ch10().isMatch(s,p));
	}
}
