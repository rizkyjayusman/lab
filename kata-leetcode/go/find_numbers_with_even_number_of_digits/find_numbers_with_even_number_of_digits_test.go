package main

import "testing"

var (
	fn FindNumber = FindNumber{}
)

func TestFindNumbers(t *testing.T) {
	expected := 2
	actual := fn.FindNumbers([]int{12, 345, 2, 6, 7896})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestFindNumbers2(t *testing.T) {
	expected := 1
	actual := fn.FindNumbers([]int{555, 901, 482, 1771})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
