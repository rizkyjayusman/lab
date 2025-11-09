package main

import (
	"testing"
)

var (
	mt MaxTree = MaxTree{}
)

func TestConstructMaximumBinaryTree(t *testing.T) {
	expected := &TreeNode{
		Val: 6,
		Left: &TreeNode{
			Val: 3,
			Right: &TreeNode{
				Val: 2,
				Right: &TreeNode{
					Val: 1,
				},
			},
		},
		Right: &TreeNode{
			Val: 5,
			Left: &TreeNode{
				Val: 0,
			},
		},
	}

	actual := mt.ConstructMaximumBinaryTree([]int{3, 2, 1, 6, 0, 5})

	checkTree(expected, actual, t)
}

func TestConstructMaximumBinaryTree2(t *testing.T) {
	expected := &TreeNode{
		Val: 3,
		Right: &TreeNode{
			Val: 2,
			Right: &TreeNode{
				Val: 1,
			},
		},
	}

	actual := mt.ConstructMaximumBinaryTree([]int{3, 2, 1})

	checkTree(expected, actual, t)
}

func checkTree(expected *TreeNode, actual *TreeNode, t *testing.T) {
	if expected == nil && actual == nil {
		return
	}

	if expected == nil || actual == nil {
		t.Error("value is not match")
		return
	}

	if expected.Val != actual.Val {
		t.Errorf("value (%v %v) is not match\n", expected.Val, actual.Val)
		return
	}

	checkTree(expected.Left, actual.Left, t)
	checkTree(expected.Right, actual.Right, t)
}
