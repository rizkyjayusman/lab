package main

import (
	"fmt"
)

type Node struct {
	info interface{}
	next *Node
}

type List struct {
	head *Node
}

func (l *List) Insert(d interface{}) {
	list := &Node{info: d, next: nil}
	if l.head == nil {
		l.head = list
	} else {
		p := l.head
		for p.next != nil {
			p = p.next
		}
		p.next = list
	}
}

func Show(l *List) {
	p := l.head
	for p != nil {
		fmt.Printf("-> %v ", p.info)
		p = p.next
	}
}

func main() {
	list1 := List{}
	list1.Insert(1)
	list1.Insert(3)

	list2 := List{}
	list2.Insert(0)
	list2.Insert(2)

	res := sort(list1, list2)
	Show(&res)
}

func sort(list1 List, list2 List) List {
	res := List{}
	for list1.head != nil || list2.head != nil {
		if list1.head != nil && list2.head != nil {
			if list1.head.info.(int) > list2.head.info.(int) {
				res.Insert(list2.head.info)
				list2.head = list2.head.next
			} else {
				res.Insert(list1.head.info)
				list1.head = list1.head.next
			}
		} else if list1.head != nil {
			res.Insert(list1.head.info)
			list1.head = list1.head.next
		} else if list2.head != nil {
			res.Insert(list2.head.info)
			list2.head = list2.head.next
		}
	}
	return res
}
