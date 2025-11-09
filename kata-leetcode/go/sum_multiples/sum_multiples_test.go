package main

import "testing"

var (
	sm SumMultiple = SumMultiple{}
)

func TestSumOfMultiples(t *testing.T) {
	expected := 21
	actual := sm.SumOfMultiples(7)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestSumOfMultiples2(t *testing.T) {
	expected := 40
	actual := sm.SumOfMultiples(10)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestSumOfMultiples3(t *testing.T) {
	expected := 30
	actual := sm.SumOfMultiples(9)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
