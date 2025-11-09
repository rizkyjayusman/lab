package main

import "testing"

var (
	wp WordPattern = WordPattern{}
)

func TestWordPattern(t *testing.T) {
	expected := true
	actual := wp.WordPattern("abba", "dog cat cat dog")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestWordPattern2(t *testing.T) {
	expected := false
	actual := wp.WordPattern("abba", "dog cat cat fish")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestWordPattern3(t *testing.T) {
	expected := false
	actual := wp.WordPattern("aaaa", "dog cat cat dog")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
