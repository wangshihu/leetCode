package ch60_80;

import java.util.HashMap;

public class Ch76 {
	public String minWindow2(String S, String T) {
		if (S == null || S.length() == 0) {
			return S;
		}
		if (T == null || T.length() == 0) {
			return "";
		}

		HashMap<Character, Integer> tCounter = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			Character c = T.charAt(i);
			if (tCounter.containsKey(c)) {
				tCounter.put(c, tCounter.get(c) + 1);
			} else {
				tCounter.put(c, 1);
			}
		}

		HashMap <Character, Integer> minWindowCounter = new HashMap<Character, Integer>();
		String minWindow = null;
		int tCount = 0, leftBound = 0;
		for (int i = 0; i < S.length(); i++) {
			Character c = S.charAt(i);
			if (!tCounter.containsKey(c)) {
				continue;
			}

			if (minWindowCounter.containsKey(c)) {
				minWindowCounter.put(c, minWindowCounter.get(c) + 1);
			} else {
				minWindowCounter.put(c, 1);
			}
			if (minWindowCounter.get(c) <= tCounter.get(c)) {
				tCount ++;
			}


			if (tCount == T.length()) {
				while (leftBound < S.length()) {
					Character ch = S.charAt(leftBound);
					if (!tCounter.containsKey(ch)) {
						leftBound ++;
						continue;
					}

					if (minWindowCounter.get(ch) > tCounter.get(ch)) {
						minWindowCounter.put(ch, minWindowCounter.get(ch) - 1);
						leftBound ++;
						continue;
					}

					break;
				}

				if (minWindow == null || i - leftBound + 1 < minWindow.length()) {
					minWindow = S.substring(leftBound, i + 1);
				}
			}
		}

		if (minWindow == null) {
			return "";
		}
		return minWindow;
	}

	public String minWindow(String s, String t) {
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		int[] position = new int[t.length()];
		int begin =Integer.MAX_VALUE;
		int end = -1;
		int beginIndex = -1;
		int endIndex =-1;
		boolean firstScanner = true;

		for(int i=0;i<position.length;i++){
			position[i] = -1;
		}
		boolean flag =true;
		for(int i=0;i<sArr.length;i++){
			flag =true;
			boolean firstbd =false;
			char c = sArr[i];
			int index = -1;
			int length = Integer.MAX_VALUE;
			for(int k=0;k<tArr.length;k++){
				if(c==tArr[k]&&position[k]==-1){
					index = k;
					break;
				}
				if(c==tArr[k]&&length>position[k]){
					length=position[k];
					index = k;
				}
			}
			if(index!=-1)
				position[index]=i;
			if(firstScanner){//第一次扫描��
				for(int k=0;k<tArr.length;k++){
					if(position[k]==-1){
						flag=false;
					}
				}
				if(flag){//第一次全部填完，获取最小值和最大值
					for(int j=0;j<position.length;j++){
						if(begin>position[j]){
							begin=position[j];
							beginIndex = j;
						}
						if(end<position[j]){
							end = position[j];
							endIndex=j;
						}
					}
					firstScanner=false;
					firstbd =true;//第一次构建
				}
			}
			if(!firstbd&&index!=-1){//更新最小值和最大值，只有在index==BeginIndex的时候 才有可能更新，大量剪枝
				if(index==beginIndex){
					int small = Integer.MAX_VALUE;
					for(int j =0;j<position.length;j++){
						if(position[j]<small){
							small=position[j];
							beginIndex=j;
						}
					}
					endIndex = index;
					if(position[endIndex]-position[beginIndex]<(end-begin)){
						end=position[endIndex];
						begin=position[beginIndex];
					}
				}
			}
		}
		if(!flag){
			return "";
		}else {
			return s.substring(begin, end+1);
		}
	}

	public static void  test1(String s,String t){
		long beginTime = System.currentTimeMillis();
		Ch76 ch = new Ch76();
		for(int i=0;i<10000;i++){
			ch.minWindow(s,t);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("方法1耗时:"+(endTime-beginTime));
	}
	public static void test2(String s,String t){
		long beginTime = System.currentTimeMillis();
		Ch76 ch = new Ch76();
		for(int i=0;i<10000;i++){
			ch.minWindow(s,t);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("方法2耗时:"+(endTime-beginTime));
	}

	public static void main(String[] args) {
		String s="acadcagcxvbdsgbchegecagcxvbdsgbchegergwfgshgnvcbnbvcgwfgerguiqyifuhdsjkafhuiwfbnmbzxvhjgwajhfgewafjegwayjgfbjewdbaacadcagcxvbdsgbchegecagcxvbdsgbchegergwfgshgnvcbnbvcgwfgerguiqyifuhdsjkafhuiwfbnmbzxvhjgwajhfgewafjegwayjgfbjewdbaacadcagcxvbdsgbchegecagcxvbdsgbchegergwfgshgnvcbnbvcgwfgerguiqyifuhdsjkafhuiwfbnmbzxvhjgwajhfgewafjegwayjgfbjewdbaacadcagcxvbdsgbchegecagcxvbdsgbchegergwfgshgnvcbnbvcgwfgerguiqyifuhdsjkafhuiwfbnmbzxvhjgwajhfgewafjegwayjgfbjewdbaacadcagcxvbdsgbchegecagcxvbdsgbchegergwfgshgnvcbnbvcgwfgerguiqyifuhdsjkafhuiwfbnmbzxvhjgwajhfgewafjegwayjgfbjewdba";
		String t = "agcxvbdsgbchegecagcxvbdsgbchegergwfgshgnvcbnbvcgwfgerguiqyifuhds";

		test2(s, t);
		test1(s, t);
		System.out.println(new Ch76().minWindow(s,t).equals(new Ch76().minWindow2(s,t)));

	}
}
