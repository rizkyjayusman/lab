package main

import (
	"testing"
)

var (
	cp CommonPrefix = CommonPrefix{}
)

func TestFindThePrefixCommonArray(t *testing.T) {
	expected := []int{0, 2, 3, 4}
	actual := cp.FindThePrefixCommonArray([]int{1, 3, 2, 4}, []int{3, 1, 2, 4})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)
	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

}

func TestFindThePrefixCommonArray2(t *testing.T) {
	expected := []int{0, 1, 3}
	actual := cp.FindThePrefixCommonArray([]int{2, 3, 1}, []int{3, 1, 2})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)
	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

}
