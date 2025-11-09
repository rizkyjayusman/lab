package main

import (
	"testing"
)

var (
	ad AddDigits = AddDigits{}
)

func TestAddDigits1(t *testing.T) {
	expected := 6
	actual := ad.AddDigits(1212)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestAddDigits2(t *testing.T) {
	expected := 0
	actual := ad.AddDigits(0)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}
