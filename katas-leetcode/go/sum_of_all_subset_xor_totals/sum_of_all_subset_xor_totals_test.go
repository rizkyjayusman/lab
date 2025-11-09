package main

import (
	"testing"
)

var (
	s SumSubset = SumSubset{}
)

func TestSubsetXorSum1(t *testing.T) {
	actual := s.SubsetXORSum([]int{1, 3})
	t.Logf("actual : %v\n", actual)
}

func TestSubsetXorSum(t *testing.T) {
	expected := 6
	actual := s.SubsetXORSum([]int{1, 3})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestSubsetXorSum2(t *testing.T) {
	expected := 28
	actual := s.SubsetXORSum([]int{5, 1, 6})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestSubsetXorSum3(t *testing.T) {
	expected := 480
	actual := s.SubsetXORSum([]int{3, 4, 5, 6, 7, 8})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}
