package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	// fmt.Println(rangeSumBST(&TreeNode{
	// 	Val: 10,
	// 	Left: &TreeNode{
	// 		Val: 5,
	// 		Left: &TreeNode{
	// 			Val: 3,
	// 		},
	// 		Right: &TreeNode{
	// 			Val: 7,
	// 		},
	// 	},
	// 	Right: &TreeNode{
	// 		Val: 15,
	// 		Right: &TreeNode{
	// 			Val: 18,
	// 		},
	// 	},
	// }, 7, 15))

	fmt.Println(rangeSumBST(&TreeNode{
		Val: 10,
		Left: &TreeNode{
			Val: 5,
			Left: &TreeNode{
				Val: 3,
				Left: &TreeNode{
					Val: 1,
				},
			},
			Right: &TreeNode{
				Val: 7,
				Left: &TreeNode{
					Val: 6,
				},
			},
		},
		Right: &TreeNode{
			Val: 15,
			Left: &TreeNode{
				Val: 13,
			},
			Right: &TreeNode{
				Val: 18,
			},
		},
	}, 6, 10))
}

func rangeSumBST(root *TreeNode, low int, high int) int {
	if root == nil {
		return 0
	}

	res := root.Val
	if root.Val < low || root.Val > high {
		res = 0
	}

	return res + rangeSumBST(root.Left, low, high) + rangeSumBST(root.Right, low, high)
}
