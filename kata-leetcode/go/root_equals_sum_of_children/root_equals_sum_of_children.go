package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	fmt.Println(checkTree(&TreeNode{
		Val: 10,
		Left: &TreeNode{
			Val: 4,
		},
		Right: &TreeNode{
			Val: 6,
		},
	}))

	// fmt.Println(checkTree(&TreeNode{
	// 	Val: 5,
	// 	Left: &TreeNode{
	// 		Val: 3,
	// 	},
	// 	Right: &TreeNode{
	// 		Val: 2,
	// 	},
	// }))
}

func checkTree(root *TreeNode) bool {
	if root == nil || (root.Left == nil && root.Right == nil) {
		return true
	}
	if !checkTree(root.Left) || !checkTree(root.Right) {
		return false
	}
	res := 0
	if root.Left != nil {
		res += root.Left.Val
	}
	if root.Right != nil {
		res += root.Right.Val
	}
	return res == root.Val
}
