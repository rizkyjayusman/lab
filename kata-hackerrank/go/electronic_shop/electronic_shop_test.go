package main

import (
	"testing"
)

var (
	gms GetMoneySpent = GetMoneySpent{}
)

func TestGetMoneySpent1(t *testing.T) {
	expected := int32(-1)
	actual := gms.GetMoneySpent([]int32{4}, []int32{5}, 5)
	t.Logf("expected : %v\n", expected)
	t.Logf("expected : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestGetMoneySpent2(t *testing.T) {
	expected := int32(9)
	actual := gms.GetMoneySpent([]int32{3, 1}, []int32{5, 2, 8}, 10)
	t.Logf("expected : %v\n", expected)
	t.Logf("expected : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestGetMoneySpent3(t *testing.T) {
	expected := int32(58)
	actual := gms.GetMoneySpent([]int32{40, 50, 60}, []int32{5, 8, 12}, 60)
	t.Logf("expected : %v\n", expected)
	t.Logf("expected : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}
