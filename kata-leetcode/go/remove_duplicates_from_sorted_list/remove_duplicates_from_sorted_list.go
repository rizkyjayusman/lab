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
	ln := List{}
	ln.Insert(1)
	ln.Insert(1)
	ln.Insert(2)
	ln.Insert(3)
	ln.Insert(3)

	nln := removeDuplicates(ln)
	Show(&nln)
}

func removeDuplicates(ln List) List {
	return remove(ln, -101)
}

func remove(ln List, x int) List {
	fmt.Println(x)
	o := ln.head.info.(int)
	if o > x {
		ln.head = ln.head.next
	}

	return remove(ln, o)
}
