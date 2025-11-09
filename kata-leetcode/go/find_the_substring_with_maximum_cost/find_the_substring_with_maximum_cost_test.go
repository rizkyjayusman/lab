package main

import "testing"

var (
	ftswmc FindTheSubstringWithMaximumCost = FindTheSubstringWithMaximumCost{}
)

func TestFormSmallestNumberFromTwoDigitArrays1(t *testing.T) {
	expected := 2
	actual := ftswmc.MaximumCostSubstring("adaa", "d", []int{-1000})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestFormSmallestNumberFromTwoDigitArrays2(t *testing.T) {
	expected := 0
	actual := ftswmc.MaximumCostSubstring("abc", "abc", []int{-1, -1, -1})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestFormSmallestNumberFromTwoDigitArrays3(t *testing.T) {
	expected := 24
	actual := ftswmc.MaximumCostSubstring("hghhghgghh", "hg", []int{2, 3})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestFormSmallestNumberFromTwoDigitArrays4(t *testing.T) {
	expected := 30
	actual := ftswmc.MaximumCostSubstring("kqqqqqkkkq", "kq", []int{-6, 6})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}
