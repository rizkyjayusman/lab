package main

import (
	"testing"
)

var (
	bafp BuildArrayFromPermutation = BuildArrayFromPermutation{}
)

func TestBuildArrayFromPermutation1(t *testing.T) {
	expected := []int{0, 1, 2, 4, 5, 3}
	actual := bafp.BuildArray([]int{0, 2, 1, 5, 3, 4})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("FAIL ~ value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("fail ~ index [%v] => (%v expected & %v actual) is not match", k, expected[k], v)
		}
	}
}

func TestBuildArrayFromPermutation2(t *testing.T) {
	expected := []int{4, 5, 0, 1, 2, 3}
	actual := bafp.BuildArray([]int{5, 0, 1, 2, 3, 4})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("FAIL ~ value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("fail ~ index [%v] => (%v expected & %v actual) is not match", k, expected[k], v)
		}
	}
}
