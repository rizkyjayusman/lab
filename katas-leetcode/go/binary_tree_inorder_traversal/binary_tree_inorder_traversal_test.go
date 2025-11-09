package main

import (
	"testing"
)

var (
	btit BinaryTreeInorderTraversal = BinaryTreeInorderTraversal{}
)

func TestBinaryTreeInOrderTraversal1(t *testing.T) {
	expected := []int{1, 3, 2}
	actual := btit.InorderTraversal(&TreeNode{
		Val: 1,
		Right: &TreeNode{
			Val: 2,
			Left: &TreeNode{
				Val: 3,
			},
		},
	})

	t.Logf("excepted : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Errorf("FAIL ~ value is not match\n")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("fail ~ index [%v] => (%v expected & %v actual) is not match", k, expected[k], v)
		}
	}
}

func TestBinaryTreeInOrderTraversal2(t *testing.T) {
	expected := []int{0}
	actual := btit.InorderTraversal(&TreeNode{})

	t.Logf("excepted : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Errorf("FAIL ~ value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("fail ~ index [%v] => (%v expected & %v actual) is not match", k, expected[k], v)
		}
	}
}

func TestBinaryTreeInOrderTraversal3(t *testing.T) {
	expected := []int{1, 1}
	actual := btit.InorderTraversal(&TreeNode{
		Val: 1,
		Right: &TreeNode{
			Val: 1,
		},
	})

	t.Logf("excepted : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Errorf("FAIL ~ value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("fail ~ index [%v] => (%v expected & %v actual) is not match", k, expected[k], v)
		}
	}
}
