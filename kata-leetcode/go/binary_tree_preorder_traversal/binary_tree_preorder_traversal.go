package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type BinaryTreePreorderTraversal struct{}

func (btpot BinaryTreePreorderTraversal) PreorderTraversal(root *TreeNode) []int {
	var arr []int
	if root == nil {
		return arr
	}

	arr = append(arr, root.Val)
	arr = append(arr, btpot.PreorderTraversal(root.Left)...)
	arr = append(arr, btpot.PreorderTraversal(root.Right)...)
	return arr
}
