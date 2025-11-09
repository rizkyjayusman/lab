package main

import (
	"testing"
)

var (
	s StudentScore = StudentScore{}
)

func TestSortTheStudents(t *testing.T) {
	expected := [][]int{{7, 5, 11, 2}, {10, 6, 9, 1}, {4, 8, 3, 15}}
	actual := s.SortTheStudents([][]int{{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}}, 2)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is  not match")
	}

	for k, v := range actual {
		if len(v) != len(expected[k]) {
			t.Error("value is  not match")
		}

		for kk, vv := range v {
			if vv != expected[k][kk] {
				t.Errorf("value (%v, %v) is not match", vv, expected[k][kk])
			}
		}
	}
}

func TestSortTheStudents2(t *testing.T) {
	expected := [][]int{{5, 6}, {3, 4}}
	actual := s.SortTheStudents([][]int{{3, 4}, {5, 6}}, 0)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is  not match")
	}

	for k, v := range actual {
		if len(v) != len(expected[k]) {
			t.Error("value is  not match")
		}

		for kk, vv := range v {
			if vv != expected[k][kk] {
				t.Errorf("value (%v, %v) is not match", vv, expected[k][kk])
			}
		}
	}
}
