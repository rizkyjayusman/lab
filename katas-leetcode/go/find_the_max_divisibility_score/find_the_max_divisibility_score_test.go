package main

import "testing"

var (
	s Score = Score{}
)

func TestMaxDivScores(t *testing.T) {
	expected := 3
	actual := s.MaxDivScore([]int{4, 7, 9, 3, 9}, []int{5, 2, 3})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestMaxDivScores2(t *testing.T) {
	expected := 5
	actual := s.MaxDivScore([]int{20, 14, 21, 10}, []int{5, 7, 5})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestMaxDivScores3(t *testing.T) {
	expected := 10
	actual := s.MaxDivScore([]int{12}, []int{10, 16})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestMaxDivScores4(t *testing.T) {
	expected := 24
	actual := s.MaxDivScore([]int{73, 13, 20, 6}, []int{56, 75, 83, 26, 24, 53, 56, 61})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
