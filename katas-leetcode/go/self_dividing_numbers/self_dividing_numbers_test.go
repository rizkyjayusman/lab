package main

import "testing"

var (
	dn DividingNumber = DividingNumber{}
)

func TestSelfDividingNumbers(t *testing.T) {
	expected := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22}
	actual := dn.SelfDividingNumbers(1, 22)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v, %v) is not match", expected[k], v)
		}
	}
}

func TestSelfDividingNumbers2(t *testing.T) {
	expected := []int{48, 55, 66, 77}
	actual := dn.SelfDividingNumbers(47, 85)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v, %v) is not match", expected[k], v)
		}
	}
}

func TestSelfDividingNumbers3(t *testing.T) {
	expected := []int{111}
	actual := dn.SelfDividingNumbers(110, 111)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v, %v) is not match", expected[k], v)
		}
	}
}
