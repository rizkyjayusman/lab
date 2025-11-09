package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type DeepestLeave struct{}

func (dl DeepestLeave) DeepestLeavesSum(root *TreeNode) int {
	var cnt int
	if root == nil {
		return cnt
	}

	cnt = dl.DeepestLeavesSum(root.Left) + dl.DeepestLeavesSum(root.Right)
	if cnt == 0 {
		if root.Left != nil {
			cnt += root.Left.Val
		}

		if root.Right != nil {
			cnt += root.Right.Val
		}
	}

	return cnt
}
