package main

import "testing"

var (
	bn BinaryNumber = BinaryNumber{}
)

func TestMinPartitions(t *testing.T) {
	expected := 3
	actual := bn.MinPartitions("32")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestMinPartitions2(t *testing.T) {
	expected := 8
	actual := bn.MinPartitions("82734")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestMinPartitions3(t *testing.T) {
	expected := 9
	actual := bn.MinPartitions("27346209830709182346")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
