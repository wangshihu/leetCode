package Ch101_120;

import com.huihui.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nowList = new ArrayList<>();
        doPathSum(root,sum,0,nowList,result);
        return result;
    }

    public void doPathSum(TreeNode root, int sum,int cNum,List<Integer> nowList,List<List<Integer>> result){
        cNum = cNum+ root.val;
        nowList.add(root.val);
        if(root.left==null&&root.right==null&&cNum==sum) {
            result.add(nowList);
        }
        if(root.left!=null){
            doPathSum(root.left, sum, cNum,new ArrayList<Integer>(nowList),result);

        }
        if(root.right!=null){
            doPathSum(root.right, sum, cNum,new ArrayList<Integer>(nowList),result);
        }
    }
}
