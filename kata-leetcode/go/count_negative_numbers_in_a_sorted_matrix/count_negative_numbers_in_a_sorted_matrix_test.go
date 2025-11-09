package main

import "testing"

var (
	c Counter = Counter{}
)

func TestCountNegatives(t *testing.T) {
	expected := 8
	actual := c.CountNegatives([][]int{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestCountNegatives2(t *testing.T) {
	expected := 0
	actual := c.CountNegatives([][]int{{3, 2}, {1, 0}})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
