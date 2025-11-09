package main

import "testing"

var (
	ta TwoArray = TwoArray{}
)

func TestFindDifference(t *testing.T) {
	expected := [][]int{{1, 3}, {4, 6}}
	actual := ta.FindDifference([]int{1, 2, 3}, []int{2, 4, 6})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		for kk, vv := range v {
			if vv != expected[k][kk] {
				t.Errorf("value (%v %v) is not match", vv, expected[k][kk])
			}
		}
	}

}

func TestFindDifference2(t *testing.T) {
	expected := [][]int{{-81, -35, -10, -28, -61, -45, -15, 14, -80, 63}, {-1, 2, 69, -40, 41, 10, -43, -44}}
	actual := ta.FindDifference([]int{-80, -15, -81, -28, -61, 63, 14, -45, -35, -10}, []int{-1, -40, -44, 41, 10, -43, 69, 10, 2})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		for kk, vv := range v {
			if vv != expected[k][kk] {
				t.Errorf("value (%v %v) is not match", vv, expected[k][kk])
			}
		}
	}

}
