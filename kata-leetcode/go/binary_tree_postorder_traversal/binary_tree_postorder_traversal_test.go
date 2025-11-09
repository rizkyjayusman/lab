package main

import (
	"testing"
)

var (
	btpot BinaryTreePostorderTraversal = BinaryTreePostorderTraversal{}
)

func TestBinaryTreePostorderTraversal1(t *testing.T) {
	expected := []int{3, 2, 1}
	actual := btpot.PostorderTraversal(&TreeNode{
		Val: 1,
		Right: &TreeNode{
			Val: 2,
			Left: &TreeNode{
				Val: 3,
			},
		},
	})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("FAIL ~ value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("fail ~ index [%v] => (%v expected & %v actual) is not match", k, expected[k], v)
		}
	}
}

func TestBinaryTreePostorderTraversal2(t *testing.T) {
	expected := []int{0}
	actual := btpot.PostorderTraversal(&TreeNode{})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("FAIL ~ value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("fail ~ index [%v] => (%v expected & %v actual) is not match", k, expected[k], v)
		}
	}
}

func TestBinaryTreePostorderTraversal3(t *testing.T) {
	expected := []int{1}
	actual := btpot.PostorderTraversal(&TreeNode{Val: 1})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("FAIL ~ value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("fail ~ index [%v] => (%v expected & %v actual) is not match", k, expected[k], v)
		}
	}
}
