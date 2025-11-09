package main

import (
	"testing"
)

var (
	ati AddTwoIntegers = AddTwoIntegers{}
)

func TestAddTwoInteger1(t *testing.T) {
	expected := 17
	actual := ati.sum(12, 5)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Errorf("FAIL ~ value is not match")
	}
}

func TestAddTwoInteger2(t *testing.T) {
	expected := -6
	actual := ati.sum(-10, 4)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Errorf("FAIL ~ value is not match")
	}
}
