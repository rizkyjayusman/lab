package main

import "testing"

var (
	ln ListNode = ListNode{}
)

func TestMergeNodes(t *testing.T) {
	expected := &ListNode{
		Val: 4,
		Next: &ListNode{
			Val: 11,
		},
	}

	actual := ln.MergeNodes(&ListNode{
		Val: 0,
		Next: &ListNode{
			Val: 3,
			Next: &ListNode{
				Val: 1,
				Next: &ListNode{
					Val: 0,
					Next: &ListNode{
						Val: 4,
						Next: &ListNode{
							Val: 5,
							Next: &ListNode{
								Val: 2,
								Next: &ListNode{
									Val: 0,
								},
							},
						},
					},
				},
			},
		},
	})

	expectedAsArr := toArr(expected, t)
	t.Logf("expected : %v", expectedAsArr)
	actualAsArr := toArr(actual, t)
	t.Logf("actual : %v", actualAsArr)

	if len(expectedAsArr) != len(actualAsArr) {
		t.Error("value is not match")
	}

	for k, v := range actualAsArr {
		if expectedAsArr[k] != v {
			t.Error("value is not match")
		}
	}
}

func toArr(node *ListNode, t *testing.T) []int {
	arr := make([]int, 0)
	if node != nil {
		arr = append(arr, node.Val)
		arr = append(arr, toArr(node.Next, t)...)
	}

	return arr
}
