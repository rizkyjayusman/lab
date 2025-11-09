package main

import "testing"

var (
	e Element = Element{}
)

func TestSumOfElements(t *testing.T) {
	expected := 4
	actual := e.SumOfUnique([]int{1, 2, 3, 2})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestSumOfElements2(t *testing.T) {
	expected := 0
	actual := e.SumOfUnique([]int{1, 1, 1, 1, 1})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestSumOfElements3(t *testing.T) {
	expected := 15
	actual := e.SumOfUnique([]int{1, 2, 3, 4, 5})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
