package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type ConvertSortedArrayToBinarySearchTree struct{}

func (csa ConvertSortedArrayToBinarySearchTree) print(root *TreeNode) {
	if root == nil {
		return
	}

	fmt.Println(root.Val)
	print(root.Left)
	print(root.Right)
}

func (csa ConvertSortedArrayToBinarySearchTree) SortedArrayToBST(nums []int) *TreeNode {
	if len(nums) == 0 {
		return nil
	}

	mid := len(nums) / 2
	return &TreeNode{
		Val:   nums[mid],
		Left:  csa.SortedArrayToBST(nums[:mid]),
		Right: csa.SortedArrayToBST(nums[mid+1:]),
	}
}
