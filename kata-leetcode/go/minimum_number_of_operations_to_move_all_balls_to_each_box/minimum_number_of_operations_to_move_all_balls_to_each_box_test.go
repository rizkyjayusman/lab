package main

import (
	"testing"
)

var (
	b Ball = Ball{}
)

func TestMinOperations(t *testing.T) {
	expected := []int{1, 1, 3}
	actual := b.MinOperations("110")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match\n")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v %v) is not match\n", v, expected[k])
		}
	}
}

func TestMinOperations2(t *testing.T) {
	expected := []int{11, 8, 5, 4, 3, 4}
	actual := b.MinOperations("001011")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match\n")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v %v) is not match\n", v, expected[k])
		}
	}
}
