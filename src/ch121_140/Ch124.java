package ch121_140;

import com.huihui.util.TreeNode;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch124 {
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
       return doMaxPathSum(root)[1];

    }

    public int[] doMaxPathSum(TreeNode root){
        int[] zero = {0,Integer.MIN_VALUE};
        if(root==null)
            return zero;
        int[] result = {root.val,root.val};
        int[] leftSum = doMaxPathSum(root.left);
        int[] rightSum = doMaxPathSum(root.right);
        int single = Math.max(leftSum[0],rightSum[0])+root.val;
        single = Math.max(0,single);
        int max = Math.max(leftSum[1],rightSum[1]);
        max = Math.max(max,leftSum[0]+rightSum[0]+root.val);

        result[0] =single;
        result[1] = max;
        return  result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        root.left =node1;
        System.out.println(new Ch124().maxPathSum(root));
    }
}
