package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type BinaryTreeInorderTraversal struct{}

func (btit BinaryTreeInorderTraversal) InorderTraversal(root *TreeNode) []int {
	var arr []int
	if root == nil {
		return arr
	}

	arr = append(arr, btit.InorderTraversal(root.Left)...)
	arr = append(arr, root.Val)
	arr = append(arr, btit.InorderTraversal(root.Right)...)
	return arr
}
