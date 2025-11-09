package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type BinaryTreePostorderTraversal struct{}

func (btpot BinaryTreePostorderTraversal) PostorderTraversal(root *TreeNode) []int {
	var arr []int
	if root == nil {
		return arr
	}

	arr = append(arr, btpot.PostorderTraversal(root.Left)...)
	arr = append(arr, btpot.PostorderTraversal(root.Right)...)
	arr = append(arr, root.Val)

	return arr
}
