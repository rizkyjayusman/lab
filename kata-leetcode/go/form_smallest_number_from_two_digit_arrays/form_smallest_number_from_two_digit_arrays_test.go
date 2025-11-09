package main

import "testing"

var (
	fsnftda FormSmallestNumberFromTwoDigitArrays = FormSmallestNumberFromTwoDigitArrays{}
)

func TestFormSmallestNumberFromTwoDigitArrays1(t *testing.T) {
	expected := 15
	actual := fsnftda.MinNumber([]int{4, 1, 3}, []int{5, 7})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestFormSmallestNumberFromTwoDigitArrays2(t *testing.T) {
	expected := 3
	actual := fsnftda.MinNumber([]int{3, 5, 2, 6}, []int{3, 1, 7})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestFormSmallestNumberFromTwoDigitArrays3(t *testing.T) {
	expected := 15
	actual := fsnftda.MinNumber([]int{7, 5, 6}, []int{1, 4})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}
