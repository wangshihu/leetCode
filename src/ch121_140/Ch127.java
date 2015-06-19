package ch121_140;

import java.util.*;

/**
 * Created by hadoop on 2015/6/3 0003.
 */
public class Ch127 {

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(beginWord.equals(endWord))
            return 1;
        if(beginWord==null||endWord==null|wordDict==null||wordDict.isEmpty())
            return 0;
        Set<String> beginList = new HashSet<>();
        for(char c='a';c<='z';c++){
            for(int i=0;i<beginWord.length();i++){
                String temp = replaceIndex(beginWord,i,c);
                if(wordDict.contains(temp))
                    beginList.add(temp);
                temp = replaceIndex(endWord,i,c);

            }
        }
        if (beginList.isEmpty())
            return 0;
        if(beginList.contains(endWord))
            return 2;
        Set<String> allSet = new HashSet<>(beginList);
        int num = 2;
        Set<String> nowList = new HashSet<>(beginList);
        for (; ; ) {
            if (nowList.isEmpty())
                return 0;
            Set<String> tempList = new HashSet<>();
            for (String str : nowList) {
                for(char c='a';c<='z';c++) {
                    for (int i = 0; i < str.length(); i++) {
                        String temp = replaceIndex(str,i,c);
                        if(temp.equals(endWord)){
                            return num+1;
                        }
                        if(wordDict.contains(temp)&&!allSet.contains(temp)){
                            tempList.add(temp);
                            allSet.add(temp);
                            wordDict.remove(temp);
                        }

                    }
                }
            }
            nowList = tempList;
            num++;
        }
    }

    public String replaceIndex(String word,int i,char c){
        char[] arr = word.toCharArray();
        arr[i] =c;
        return new String(arr);
    }



    public int ladderLength3(String beginWord, String endWord, Set<String> wordDict) {
        List<String> words = new ArrayList<>(wordDict);
        List<Integer> beginList = new ArrayList<>();
        List<Integer> endList = new ArrayList<>();
        for(int i=0;i<words.size();i++){
            if(enableChange(beginWord,words.get(i)))
                beginList.add(i);
            if(enableChange(endWord,words.get(i)))
                endList.add(i);
        }
        if(beginList.isEmpty()||endList.isEmpty())
            return -1;
        int[][] lengthArr = new int[words.size()][words.size()];
        for(int i=1;i<words.size();i++){
            for(int j=0;j<i;j++){
                if(enableChange(words.get(i),words.get(j))){
                    lengthArr[i][j] =1;
                    lengthArr[j][i] =1;
                }
                else{
                    lengthArr[i][j] =-1;
                    lengthArr[j][i] =-1;
                }

            }
        }
        for(boolean flag=true;flag;){
            flag =false;
            for(int i=1;i<words.size();i++){
                for(int j=0;j<i;j++){
                    if(lengthArr[i][j]==-1){
                        int min = Integer.MAX_VALUE;
                        for(int k=0;k<words.size();k++){
                            if(lengthArr[i][k]!=-1&&lengthArr[j][k]!=-1&&k!=i){
                                min = Math.min(min,lengthArr[i][k]+lengthArr[j][k]);
                            }
                        }
                        if(min!=Integer.MAX_VALUE){
                            lengthArr[i][j] = min;
                            lengthArr[j][i] = min;
                            flag = true;
                        }
                    }
                }
            }
        }
        int result =Integer.MAX_VALUE;
        for(Integer begin:beginList){
            for(Integer end:endList){
                result = Math.min(result,lengthArr[begin][end]);
            }
        }
        return result==Integer.MAX_VALUE?-1:result+3;
    }

    public boolean enableChange(String word1, String word2) {
        int num = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                num++;
            if (num > 1) {
                return false;
            }
        }
        return num == 1;
    }





    public static void test(String beginWord, String endWord, Set<String> wordDict){
        long beginTime = System.currentTimeMillis();
        Ch127 ch = new Ch127();
        int result = -1;
//        for(int i=0;i<1000;i++){
        result = ch.ladderLength(beginWord, endWord, wordDict);
        int result3 = ch.ladderLength3(beginWord,endWord,wordDict);
//        }
        long endTime =System.currentTimeMillis();
        System.out.println("test 1 use:  "+(endTime-beginTime));
        System.out.println(result+" , "+" , "+result3);
    }

    public static void main(String[] args) {
        String beginWord = "a";
        String endWord = "b";
        String[] dict = {"a", "b","c"};
//        String beginWord = "hot";
//        String endWord = "dog";
//        String[] dict = {"hot", "dog"};
//        String beginWord = "hit";
//        String endWord = "cog";
//        String[] dict = {"hot", "dot", "dog", "lot", "log"};
//        String beginWord = "sand";
//        String endWord = "acne";
        //String[] dict ={"slit","bunk","wars","ping","viva","wynn","wows","irks","gang","pool","mock","fort","heel","send","ship","cols","alec","foal","nabs","gaze","giza","mays","dogs","karo","cums","jedi","webb","lend","mire","jose","catt","grow","toss","magi","leis","bead","kara","hoof","than","ires","baas","vein","kari","riga","oars","gags","thug","yawn","wive","view","germ","flab","july","tuck","rory","bean","feed","rhee","jeez","gobs","lath","desk","yoko","cute","zeus","thus","dims","link","dirt","mara","disc","limy","lewd","maud","duly","elsa","hart","rays","rues","camp","lack","okra","tome","math","plug","monk","orly","friz","hogs","yoda","poop","tick","plod","cloy","pees","imps","lead","pope","mall","frey","been","plea","poll","male","teak","soho","glob","bell","mary","hail","scan","yips","like","mull","kory","odor","byte","kaye","word","honk","asks","slid","hopi","toke","gore","flew","tins","mown","oise","hall","vega","sing","fool","boat","bobs","lain","soft","hard","rots","sees","apex","chan","told","woos","unit","scow","gilt","beef","jars","tyre","imus","neon","soap","dabs","rein","ovid","hose","husk","loll","asia","cope","tail","hazy","clad","lash","sags","moll","eddy","fuel","lift","flog","land","sigh","saks","sail","hook","visa","tier","maws","roeg","gila","eyes","noah","hypo","tore","eggs","rove","chap","room","wait","lurk","race","host","dada","lola","gabs","sobs","joel","keck","axed","mead","gust","laid","ends","oort","nose","peer","kept","abet","iran","mick","dead","hags","tens","gown","sick","odis","miro","bill","fawn","sumo","kilt","huge","ores","oran","flag","tost","seth","sift","poet","reds","pips","cape","togo","wale","limn","toll","ploy","inns","snag","hoes","jerk","flux","fido","zane","arab","gamy","raze","lank","hurt","rail","hind","hoot","dogy","away","pest","hoed","pose","lose","pole","alva","dino","kind","clan","dips","soup","veto","edna","damp","gush","amen","wits","pubs","fuzz","cash","pine","trod","gunk","nude","lost","rite","cory","walt","mica","cart","avow","wind","book","leon","life","bang","draw","leek","skis","dram","ripe","mine","urea","tiff","over","gale","weir","defy","norm","tull","whiz","gill","ward","crag","when","mill","firs","sans","flue","reid","ekes","jain","mutt","hems","laps","piss","pall","rowe","prey","cull","knew","size","wets","hurl","wont","suva","girt","prys","prow","warn","naps","gong","thru","livy","boar","sade","amok","vice","slat","emir","jade","karl","loyd","cerf","bess","loss","rums","lats","bode","subs","muss","maim","kits","thin","york","punt","gays","alpo","aids","drag","eras","mats","pyre","clot","step","oath","lout","wary","carp","hums","tang","pout","whip","fled","omar","such","kano","jake","stan","loop","fuss","mini","byrd","exit","fizz","lire","emil","prop","noes","awed","gift","soli","sale","gage","orin","slur","limp","saar","arks","mast","gnat","port","into","geed","pave","awls","cent","cunt","full","dint","hank","mate","coin","tars","scud","veer","coax","bops","uris","loom","shod","crib","lids","drys","fish","edit","dick","erna","else","hahs","alga","moho","wire","fora","tums","ruth","bets","duns","mold","mush","swop","ruby","bolt","nave","kite","ahem","brad","tern","nips","whew","bait","ooze","gino","yuck","drum","shoe","lobe","dusk","cult","paws","anew","dado","nook","half","lams","rich","cato","java","kemp","vain","fees","sham","auks","gish","fire","elam","salt","sour","loth","whit","yogi","shes","scam","yous","lucy","inez","geld","whig","thee","kelp","loaf","harm","tomb","ever","airs","page","laud","stun","paid","goop","cobs","judy","grab","doha","crew","item","fogs","tong","blip","vest","bran","wend","bawl","feel","jets","mixt","tell","dire","devi","milo","deng","yews","weak","mark","doug","fare","rigs","poke","hies","sian","suez","quip","kens","lass","zips","elva","brat","cosy","teri","hull","spun","russ","pupa","weed","pulp","main","grim","hone","cord","barf","olav","gaps","rote","wilt","lars","roll","balm","jana","give","eire","faun","suck","kegs","nita","weer","tush","spry","loge","nays","heir","dope","roar","peep","nags","ates","bane","seas","sign","fred","they","lien","kiev","fops","said","lawn","lind","miff","mass","trig","sins","furl","ruin","sent","cray","maya","clog","puns","silk","axis","grog","jots","dyer","mope","rand","vend","keen","chou","dose","rain","eats","sped","maui","evan","time","todd","skit","lief","sops","outs","moot","faze","biro","gook","fill","oval","skew","veil","born","slob","hyde","twin","eloy","beat","ergs","sure","kobe","eggo","hens","jive","flax","mons","dunk","yest","begs","dial","lodz","burp","pile","much","dock","rene","sago","racy","have","yalu","glow","move","peps","hods","kins","salk","hand","cons","dare","myra","sega","type","mari","pelt","hula","gulf","jugs","flay","fest","spat","toms","zeno","taps","deny","swag","afro","baud","jabs","smut","egos","lara","toes","song","fray","luis","brut","olen","mere","ruff","slum","glad","buds","silt","rued","gelt","hive","teem","ides","sink","ands","wisp","omen","lyre","yuks","curb","loam","darn","liar","pugs","pane","carl","sang","scar","zeds","claw","berg","hits","mile","lite","khan","erik","slug","loon","dena","ruse","talk","tusk","gaol","tads","beds","sock","howe","gave","snob","ahab","part","meir","jell","stir","tels","spit","hash","omit","jinx","lyra","puck","laue","beep","eros","owed","cede","brew","slue","mitt","jest","lynx","wads","gena","dank","volt","gray","pony","veld","bask","fens","argo","work","taxi","afar","boon","lube","pass","lazy","mist","blot","mach","poky","rams","sits","rend","dome"};
        Set<String> wordDict = new HashSet<>();
        Collections.addAll(wordDict, dict);
        test(beginWord,endWord,wordDict);
    }
}
