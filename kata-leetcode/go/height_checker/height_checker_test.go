package main

import "testing"

var (
	c HeightChecker = HeightChecker{}
)

func TestHeightChecker(t *testing.T) {
	expected := 3
	actual := c.HeightChecker([]int{1, 1, 4, 2, 1, 3})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Errorf("value is not match")
	}
}

func TestHeightChecker2(t *testing.T) {
	expected := 5
	actual := c.HeightChecker([]int{5, 1, 2, 3, 4})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Errorf("value is not match")
	}
}

func TestHeightChecker3(t *testing.T) {
	expected := 0
	actual := c.HeightChecker([]int{1, 2, 3, 4, 5})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Errorf("value is not match")
	}
}
