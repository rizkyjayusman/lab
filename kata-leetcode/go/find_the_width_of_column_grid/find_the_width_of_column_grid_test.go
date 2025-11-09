package main

import (
	"testing"
)

var (
	g Grid = Grid{}
)

func TestFindColumnWidth(t *testing.T) {
	expected := []int{3}
	actual := g.FindColumnWidth([][]int{{1}, {22}, {333}})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("FAIL ~ value is not match\n")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("FAIL ~ value (%v, %v) is not match\n", v, expected[k])
		}
	}
}

func TestFindColumnWidth2(t *testing.T) {
	expected := []int{3, 1, 2}
	actual := g.FindColumnWidth([][]int{{-15, 1, 3}, {15, 7, 12}, {5, 6, -2}})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("FAIL ~ value is not match\n")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("FAIL ~ value (%v, %v) is not match\n", v, expected[k])
		}
	}
}
