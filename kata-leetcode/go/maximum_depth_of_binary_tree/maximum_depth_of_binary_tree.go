package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	fmt.Println(maxDepth(&TreeNode{
		Val: 3,
		Left: &TreeNode{
			Val: 9,
		},
		Right: &TreeNode{
			Val: 20,
			Left: &TreeNode{
				Val: 15,
			},
			Right: &TreeNode{
				Val: 7,
			},
		},
	}))

	// fmt.Println(maxDepth(&TreeNode{
	// 	Val: 1,
	// 	Left: &TreeNode{
	// 		Val: 3,
	// 	},
	// 	Right: &TreeNode{
	// 		Val: 2,
	// 	},
	// }))

	// fmt.Println(maxDepth(&TreeNode{
	// 	Val: 1,
	// }))
}

func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	left := 1 + maxDepth(root.Left)
	right := 1 + maxDepth(root.Right)

	if left > right {
		return left
	}

	return right
}
