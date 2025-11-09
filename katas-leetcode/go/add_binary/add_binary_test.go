package main

import "testing"

var (
	ab AddBinary = AddBinary{}
)

func TestAddBinary1(t *testing.T) {
	expected := "100"
	actual := ab.addBinary("11", "1")
	t.Logf("expected : %s\n", expected)
	t.Logf("actual : %s\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestAddBinary2(t *testing.T) {
	expected := "10101"
	actual := ab.addBinary("1010", "1011")
	t.Logf("expected : %s\n", expected)
	t.Logf("actual : %s\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}
