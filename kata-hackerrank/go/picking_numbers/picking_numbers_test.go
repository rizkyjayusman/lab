package main

import "testing"

var (
	pn PickingNumbers = PickingNumbers{}
)

func TestPickingNumbers(t *testing.T) {
	expected := int32(2)
	actual := pn.PickingNumbers([]int32{1, 1, 3, 3})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestPickingNumbers1(t *testing.T) {
	expected := int32(5)
	actual := pn.PickingNumbers([]int32{1, 1, 2, 2, 4, 4, 5, 5, 5})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestPickingNumbers2(t *testing.T) {
	expected := int32(3)
	actual := pn.PickingNumbers([]int32{4, 6, 5, 3, 3, 1})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestPickingNumbers3(t *testing.T) {
	expected := int32(5)
	actual := pn.PickingNumbers([]int32{1, 2, 2, 3, 1, 2})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}
