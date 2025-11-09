package main

import (
	"testing"
)

var (
	bt BinaryTree = BinaryTree{}
)

func TestBinaryTreeInOrderTraversal1(t *testing.T) {
	expected := bt.ReplaceValueInTree(&TreeNode{
		Val: 0,
		Left: &TreeNode{
			Val: 0,
			Left: &TreeNode{
				Val: 7,
			},
			Right: &TreeNode{
				Val: 7,
			},
		},
		Right: &TreeNode{
			Val: 0,
			Right: &TreeNode{
				Val: 11,
			},
		},
	})

	actual := bt.ReplaceValueInTree(&TreeNode{
		Val: 5,
		Left: &TreeNode{
			Val: 4,
			Left: &TreeNode{
				Val: 1,
			},
			Right: &TreeNode{
				Val: 10,
			},
		},
		Right: &TreeNode{
			Val: 9,
			Right: &TreeNode{
				Val: 7,
			},
		},
	})

	checkTree(expected, actual, t)
}

func checkTree(expected *TreeNode, actual *TreeNode, t *testing.T) {
	if expected == nil && actual == nil {
		return
	}

	if expected == nil && actual != nil || expected != nil && actual == nil {
		t.Errorf("value is not match\n")
		return
	}

	if actual.Val != expected.Val {
		t.Errorf("value (%v, %v) is not match\n", actual.Val, expected.Val)
		return
	}

	checkTree(expected.Left, actual.Left, t)
	checkTree(expected.Right, actual.Right, t)
}
