package main

import (
	"testing"
)

var (
	cts CheckIfTwoStringArraysAreEquivalent = CheckIfTwoStringArraysAreEquivalent{}
)

func TestCheckIfTwoStringArraysAreEquivalent1(t *testing.T) {
	expected := true
	actual := cts.ArrayStringsAreEqual([]string{"ab", "c"}, []string{"a", "bc"})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestCheckIfTwoStringArraysAreEquivalent2(t *testing.T) {
	expected := false
	actual := cts.ArrayStringsAreEqual([]string{"a", "cb"}, []string{"ab", "c"})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestCheckIfTwoStringArraysAreEquivalent3s(t *testing.T) {
	expected := true
	actual := cts.ArrayStringsAreEqual([]string{"abc", "d", "defg"}, []string{"abcddefg"})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}
