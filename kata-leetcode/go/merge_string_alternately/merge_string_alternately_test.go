package main

import "testing"

var (
	s String = String{}
)

func TestMergeSimilarItems(t *testing.T) {
	expected := "apbqcr"
	actual := s.MergeAlternately("abc", "pqr")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestMergeSimilarItems2(t *testing.T) {
	expected := "apbqrs"
	actual := s.MergeAlternately("ab", "pqrs")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestMergeSimilarItems3(t *testing.T) {
	expected := "apbqcd"
	actual := s.MergeAlternately("abcd", "pq")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
