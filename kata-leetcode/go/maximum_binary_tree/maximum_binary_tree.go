package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type MaxTree struct{}

func (mt MaxTree) ConstructMaximumBinaryTree(nums []int) *TreeNode {
	if len(nums) == 0 {
		return nil
	}

	max := 0
	for k, v := range nums {
		if v > nums[max] {
			max = k
		}
	}

	return &TreeNode{
		Val:   nums[max],
		Left:  mt.ConstructMaximumBinaryTree(nums[:max]),
		Right: mt.ConstructMaximumBinaryTree(nums[max+1:]),
	}
}
