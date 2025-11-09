package main

import "testing"

var (
	v StringValidator = StringValidator{}
)

func TestAddMinimum(t *testing.T) {
	expected := 2
	actual := v.AddMinimum("b")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestAddMinimum2(t *testing.T) {
	expected := 6
	actual := v.AddMinimum("aaa")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestAddMinimum3(t *testing.T) {
	expected := 0
	actual := v.AddMinimum("abc")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
