package main

import "testing"

func TestSubRectangleQueries(t *testing.T) {
	sq := Constructor([][]int{{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}})
	expected := 1
	actual := sq.GetValue(0, 2)
	if actual != expected {
		t.Error("value is not match")
	}

	sq.UpdateSubrectangle(0, 0, 3, 2, 5)
	expected = 5
	actual = sq.GetValue(0, 2)
	if actual != expected {
		t.Errorf("value (%v %v) is not match", actual, expected)
	}

	expected = 5
	actual = sq.GetValue(3, 1)
	if actual != expected {
		t.Errorf("value (%v %v) is not match", actual, expected)
	}

	sq.UpdateSubrectangle(3, 0, 3, 2, 10)
	expected = 10
	actual = sq.GetValue(3, 1)
	if actual != expected {
		t.Errorf("value (%v %v) is not match", actual, expected)
	}

	expected = 5
	actual = sq.GetValue(0, 2)
	if actual != expected {
		t.Errorf("value (%v %v) is not match", actual, expected)
	}
}

func TestSubRectangleQueries2(t *testing.T) {
	sq := Constructor([][]int{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}})
	expected := 1
	actual := sq.GetValue(0, 0)
	if actual != expected {
		t.Error("value is not match")
	}

	sq.UpdateSubrectangle(0, 0, 2, 2, 100)
	expected = 100
	actual = sq.GetValue(0, 0)
	if actual != expected {
		t.Errorf("value (%v %v) is not match", actual, expected)
	}

	expected = 100
	actual = sq.GetValue(2, 2)
	if actual != expected {
		t.Errorf("value (%v %v) is not match", actual, expected)
	}

	sq.UpdateSubrectangle(1, 1, 2, 2, 20)
	expected = 20
	actual = sq.GetValue(2, 2)
	if actual != expected {
		t.Errorf("value (%v %v) is not match", actual, expected)
	}
}
