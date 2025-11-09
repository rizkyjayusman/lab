package main

import "testing"

var (
	g Grid = Grid{}
)

func TestExecuteInstructions(t *testing.T) {
	expected := []int{1, 5, 4, 3, 1, 0}
	actual := g.ExecuteInstructions(3, []int{0, 1}, "RRDDLU")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v %v) is not match\n", v, expected[k])
		}
	}
}

func TestExecuteInstructions2(t *testing.T) {
	expected := []int{4, 1, 0, 0}
	actual := g.ExecuteInstructions(2, []int{1, 1}, "LURD")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v %v) is not match\n", v, expected[k])
		}
	}
}

func TestExecuteInstructions3(t *testing.T) {
	expected := []int{0, 0, 0, 0}
	actual := g.ExecuteInstructions(1, []int{0, 0}, "LRUD")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v %v) is not match\n", v, expected[k])
		}
	}
}
