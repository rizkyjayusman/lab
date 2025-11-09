package main

import "testing"

var (
	fs FindScore = FindScore{}
)

func TestFindScore(t *testing.T) {
	expected := []int64{4, 10, 24, 36, 56}
	actual := fs.FindPrefixScore([]int{2, 3, 7, 5, 10})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v, %v) is not match\n", v, expected[k])
		}
	}
}

func TestFindScore2(t *testing.T) {
	expected := []int64{2, 4, 8, 16, 32, 64}
	actual := fs.FindPrefixScore([]int{1, 1, 2, 4, 8, 16})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v, %v) is not match\n", v, expected[k])
		}
	}
}
