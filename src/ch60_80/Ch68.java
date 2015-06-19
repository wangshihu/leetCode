package ch60_80;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/3 0003.
 */
public class Ch68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> list = new ArrayList<>();
        List<Integer> lengthList = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(words[i]==null)
                return null;
            List<String> tempList = new ArrayList<>();
            int num = 0;
            while(i<words.length&&num+words[i].length()<=maxWidth){
                tempList.add(words[i]);
                num+=words[i].length()+1;
                i++;
            }
            lengthList.add(num-tempList.size());
            i--;
            list.add(tempList);
        }

        List<String >result = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            result.add(dealListString(list.get(i),maxWidth-lengthList.get(i),i==list.size()-1));
        }
        return result;
    }

    public String dealListString(List<String> list,int spaceNum,boolean isLast){
        StringBuilder result = new StringBuilder();
        if(!isLast){
            int size = list.size()-1;
            if(size<=0)
                size=1;
            String[] spaceArr = new String[size];
            for(int i=0;i<spaceArr.length;i++){
                spaceArr[i] = "";
            }
            for(int i=0,index =0;i<spaceNum;i++){
                spaceArr[index] = spaceArr[index]+" ";
                if(++index==size)
                    index =0;
            }
            for(int i=0;i<list.size();i++){
                if(i<spaceArr.length){
                    result.append(list.get(i)+spaceArr[i]);
                }else{
                    result.append(list.get(i));
                }
            }
        }else {
            String leftSpace =" ";
            int right = spaceNum-list.size()+1;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<right;i++)
                sb.append(" ");
            String rightSpace = sb.toString();

            for(int i=0;i<list.size();i++){
                if(i==list.size()-1){
                    result.append(list.get(i)+rightSpace);
                }else{
                    result.append(list.get(i)+leftSpace);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        //String[] words = {"This", "", "an", "example", "of", "text", "justi","fication."};
//        String[] words = {"a","b","c","d","e"};
//        int maxlength = 1;
        String[] words = {""};
        int maxlength = 0;
//        String[] words = {"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};
//        int maxlength = 30;

//        String[] words = {"Listen","to","many,","speak","to","a","few."};
//        int maxlength = 6;
        List<String> result = new Ch68().fullJustify(words,maxlength);
        System.out.println(result.size());
        for(String a:result)
            System.out.print(a+",");
    }
}
