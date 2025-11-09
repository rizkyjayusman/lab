package main

import "testing"

var (
	sd SumOfDistances = SumOfDistances{}
)

func TestSumOfDistances(t *testing.T) {
	expected := []int64{5, 0, 3, 4, 0}
	actual := sd.Distance([]int{1, 3, 1, 1, 2})

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v,%v) is not match", expected[k], v)
		}
	}
}
