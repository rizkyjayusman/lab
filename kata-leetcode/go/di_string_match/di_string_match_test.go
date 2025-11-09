package main

import "testing"

var (
	sm StringMatcher = StringMatcher{}
)

func TestDiStringMatch(t *testing.T) {
	expected := []int{0, 4, 1, 3, 2}
	actual := sm.DiStringMatch("IDID")
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

func TestDiStringMatch2(t *testing.T) {
	expected := []int{0, 1, 2, 3}
	actual := sm.DiStringMatch("III")
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

func TestDiStringMatch3(t *testing.T) {
	expected := []int{3, 2, 0, 1}
	actual := sm.DiStringMatch("DDI")
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
