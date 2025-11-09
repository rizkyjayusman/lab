package main

import "testing"

var (
	os OptimalString = OptimalString{}
)

func TestPartitionString(t *testing.T) {
	expected := 4
	actual := os.PartitionString("abacaba")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestPartitionString2(t *testing.T) {
	expected := 6
	actual := os.PartitionString("ssssss")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestPartitionString3(t *testing.T) {
	expected := 4
	actual := os.PartitionString("hdklqkcssgxlvehva")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
