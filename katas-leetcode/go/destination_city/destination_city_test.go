package main

import (
	"testing"
)

var (
	dc DestinationCity = DestinationCity{}
)

func TestDestCity(t *testing.T) {
	expected := "Sao Paulo"
	actual := dc.destCity([][]string{{"New York", "Lima"}, {"London", "New York"}, {"Lima", "Sao Paulo"}})
	t.Logf("expected : %s\n", expected)
	t.Logf("actual : %s\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestDestCity2(t *testing.T) {
	expected := "A"
	actual := dc.destCity([][]string{{"D", "B"}, {"C", "A"}, {"B", "C"}})
	t.Logf("expected : %s\n", expected)
	t.Logf("actual : %s\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestDestCity3(t *testing.T) {
	expected := "Z"
	actual := dc.destCity([][]string{{"A", "Z"}})
	t.Logf("expected : %s\n", expected)
	t.Logf("actual : %s\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
