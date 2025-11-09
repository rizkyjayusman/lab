package main

import "testing"

var (
	g Group = Group{}
)

func TestGroupThePeople(t *testing.T) {
	expected := [][]int{{5}, {0, 1, 2}, {3, 4, 6}}
	actual := g.GroupThePeople([]int{3, 3, 3, 3, 3, 1, 3})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)
}
