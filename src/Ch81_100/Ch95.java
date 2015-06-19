package Ch81_100;


import com.huihui.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 2015/6/3 0003.
 */
public class Ch95 {

    public List<TreeNode> generateTrees(int n) {
        Map<String,List<TreeNode>> map = new HashMap<>();//¼Ó¸ö»º´æ
        List<TreeNode> result = doGenerateTrees(1,n,map);

        return result;
    }

    public List<TreeNode> doGenerateTrees(int begin,int end,Map<String,List<TreeNode>> map){
        String key = new StringBuilder().append(begin).append("-").append(end).toString();

        List<TreeNode> result = map.get(key);
        if(result==null)
            result = new ArrayList<>();
        else
            return result;
        if(begin==end){
            result.add(new TreeNode(end));
            return result;
        }
        if(begin>end)
            result.add(null);
        for(int i=begin;i<=end;i++){
            List<TreeNode> leftList = doGenerateTrees(begin,i-1,map);
            List<TreeNode> rightList = doGenerateTrees(i+1,end,map);
            for(TreeNode left:leftList){
                for(TreeNode right:rightList){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        map.put(key,result);
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> result = new Ch95().generateTrees(15);
        System.out.println(result.size());
    }
}
