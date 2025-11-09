package main

import "testing"

var (
	btpot BinaryTreePreorderTraversal = BinaryTreePreorderTraversal{}
)

func TestBinaryTreePreorderTraversal1(t *testing.T) {
	expected := []int{1, 2, 3}
	actual := btpot.PreorderTraversal(&TreeNode{
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

func TestBinaryTreePreorderTraversal2(t *testing.T) {
	expected := []int{0}
	actual := btpot.PreorderTraversal(&TreeNode{})
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

func TestBinaryTreePreorderTraversal3(t *testing.T) {
	expected := []int{1}
	actual := btpot.PreorderTraversal(&TreeNode{Val: 1})
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
