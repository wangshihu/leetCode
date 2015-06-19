package Ch101_120;

import com.huihui.util.TreeNode;

/**
 * Created by hadoop on 2015/6/5 0005.
 */
public class Ch108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null|nums.length==0)
            return null;
        return doSortedArrayToBST(nums,0,nums.length-1);
    }
    public TreeNode doSortedArrayToBST(int[] nums,int begin,int end){
        if(end<begin)
            return  null;
        if(end==begin)
            return new TreeNode(nums[begin]);
        int mid = (begin+end)/2;

        TreeNode node = new TreeNode(nums[mid]);
        TreeNode left = doSortedArrayToBST(nums,begin,mid-1);
        TreeNode right = doSortedArrayToBST(nums,mid+1,end);
        node.left = left;
        node.right = right;
        return node;
    }

    public static void main(String[] args) {
        int n=10;
        int[] nums = new int[n];
        for(int i=1;i<=n;i++){
            nums[i-1] =i;
        }
        TreeNode root = new Ch108().sortedArrayToBST(nums);
        TreeNode.printInorder(root);
        System.out.println();
        TreeNode.printPreorder(root);
    }
}
