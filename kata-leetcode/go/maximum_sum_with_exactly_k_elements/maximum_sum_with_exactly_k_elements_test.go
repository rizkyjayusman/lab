package main

import (
	"testing"
)

var (
	ms MaxSum = MaxSum{}
)

func TestMaxSum(t *testing.T) {
	expected := 18
	actual := ms.MaximizeSum([]int{1, 2, 3, 4, 5}, 3)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)
	if expected != actual {
		t.Error("value is not match")
	}

}

func TestMaxSum2(t *testing.T) {
	expected := 11
	actual := ms.MaximizeSum([]int{5, 5, 5}, 2)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)
	if expected != actual {
		t.Error("value is not match")
	}

}
