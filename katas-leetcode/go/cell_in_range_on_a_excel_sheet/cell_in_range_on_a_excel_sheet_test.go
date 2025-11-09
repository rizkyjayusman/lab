package main

import (
	"testing"
)

var (
	ciroes CellInRangeOnAExcelSheet = CellInRangeOnAExcelSheet{}
)

func TestCellInRangeOnAExcelSheet1(t *testing.T) {
	expected := []string{"K1", "K2", "L1", "L2"}
	actual := ciroes.CellsInRange("K1:L2")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("FAIL ~ value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("fail ~ index [%v] => (%v expected & %v actual) is not match", k, expected[k], v)
		}
	}
}

func TestCellInRangeOnAExcelSheet2(t *testing.T) {
	expected := []string{"A1", "B1", "C1", "D1", "E1", "F1"}
	actual := ciroes.CellsInRange("A1:F1")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("FAIL ~ value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("fail ~ index [%v] => (%v expected & %v actual) is not match", k, expected[k], v)
		}
	}
}
