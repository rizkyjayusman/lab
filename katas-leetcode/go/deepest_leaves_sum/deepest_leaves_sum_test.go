package main

import "testing"

var (
	dl DeepestLeave = DeepestLeave{}
)

func TestDeepestLeavesSum(t *testing.T) {
	expected := 15
	actual := dl.DeepestLeavesSum(&TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val: 2,
			Left: &TreeNode{
				Val: 4,
				Left: &TreeNode{
					Val: 7,
				},
			},
			Right: &TreeNode{
				Val: 5,
			},
		},
		Right: &TreeNode{
			Val: 3,
			Right: &TreeNode{
				Val: 6,
				Right: &TreeNode{
					Val: 8,
				},
			},
		},
	})

	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}
