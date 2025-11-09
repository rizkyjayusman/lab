package main

import (
	"testing"
)

var (
	coa ConcatenationOfArray = ConcatenationOfArray{}
)

func TestConcatenationOfArray1(t *testing.T) {
	expected := []int{1, 2, 1, 1, 2, 1}
	actual := coa.GetConcatenation([]int{1, 2, 1})
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

func TestConcatenationOfArray2(t *testing.T) {
	expected := []int{1, 3, 2, 1, 1, 3, 2, 1}
	actual := coa.GetConcatenation([]int{1, 3, 2, 1})
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
