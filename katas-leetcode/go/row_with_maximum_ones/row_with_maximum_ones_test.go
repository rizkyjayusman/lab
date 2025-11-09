package main

import "testing"

var (
	mo MaxOne = MaxOne{}
)

func TestRowAndMaxOnes(t *testing.T) {
	expected := []int{0, 1}
	actual := mo.RowAndMaximumOnes([][]int{{0, 1}, {1, 0}})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	if expected[0] != actual[0] || expected[1] != expected[1] {
		t.Error("value is not match")
	}
}

func TestRowAndMaxOnes2(t *testing.T) {
	expected := []int{1, 2}
	actual := mo.RowAndMaximumOnes([][]int{{0, 0, 0}, {0, 1, 1}})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	if expected[0] != actual[0] || expected[1] != expected[1] {
		t.Error("value is not match")
	}
}

func TestRowAndMaxOnes3(t *testing.T) {
	expected := []int{1, 2}
	actual := mo.RowAndMaximumOnes([][]int{{0, 0}, {1, 1}, {0, 0}})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	if expected[0] != actual[0] || expected[1] != expected[1] {
		t.Error("value is not match")
	}
}
