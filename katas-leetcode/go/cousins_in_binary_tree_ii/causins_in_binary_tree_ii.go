package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type BinaryTree struct{}

func (bt BinaryTree) ReplaceValueInTree(root *TreeNode) *TreeNode {
	return bt.replace(root, false)
}

func (bt BinaryTree) replace(root *TreeNode, hasRelation bool) *TreeNode {
	if root == nil {
		return nil
	}

	leftSum := bt.sumChild(root.Left)
	rightSum := bt.sumChild(root.Right)

	root.Left = bt.replace(root.Left, bt.hasRelation(root.Left))
	if root.Left != nil && hasRelation {
		root.Left.Val = rightSum
	}

	root.Right = bt.replace(root.Right, bt.hasRelation(root.Right))
	if root.Right != nil && hasRelation {
		root.Right.Val = leftSum
	}

	if !hasRelation {
		root.Val = 0
	}

	return root
}

func (bt BinaryTree) hasRelation(root *TreeNode) bool {
	if root == nil {
		return false
	}

	if root.Left != nil && root.Right != nil {
		return true
	}

	return false
}

func (bt BinaryTree) sumChild(root *TreeNode) int {
	sum := 0
	if root == nil {
		return sum
	}

	if root.Left != nil {
		sum += root.Left.Val
	}

	if root.Right != nil {
		sum += root.Right.Val
	}

	return sum

}
