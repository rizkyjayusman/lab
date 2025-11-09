package main

import (
	"testing"
)

var (
	ts TrainScheduler = TrainScheduler{}
)

func TestFindDelayedArrivalTime(t *testing.T) {
	expected := 20
	actual := ts.FindDelayedArrivalTime(15, 5)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestFindDelayedArrivalTime2(t *testing.T) {
	expected := 0
	actual := ts.FindDelayedArrivalTime(13, 11)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
