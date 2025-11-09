package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func (ln ListNode) MergeNodes(head *ListNode) *ListNode {
	cur := head.Next

	for cur != nil {
		n := cur
		sum := 0
		for n.Val > 0 {
			sum += n.Val
			n = n.Next
		}

		cur.Val = sum
		cur.Next = n.Next
		cur = n.Next
	}

	return head.Next
}
