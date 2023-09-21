package leetcode;

public class SumRootToLeafNumbers {

    public static int sumNumbers(TreeNode root) {
        return concatBranchNumbers(root, "");
    }

    public static int concatBranchNumbers(TreeNode node, String previousBranchNumbers) {
        if (node == null || node.val < 0 || node.val > 9) {
            return 0;
        }

        var concatenatedBranchNumbers = previousBranchNumbers + node.val;

        if (node.left == null && node.right == null) {
            return Integer.parseInt(concatenatedBranchNumbers);
        }

        return concatBranchNumbers(node.right, concatenatedBranchNumbers)
                + concatBranchNumbers(node.left, concatenatedBranchNumbers);
    }

    public static void main(String[] args) {
        var treeNode = new TreeNode(4,
                new TreeNode(9,
                        new TreeNode(5),
                        new TreeNode(1)
                ),
                new TreeNode(0)
        );

        System.out.println(sumNumbers(treeNode));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
