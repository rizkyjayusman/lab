package main

import (
	"testing"
)

var (
	gc GarbageCollector = GarbageCollector{}
)

func TestGarbageCollection(t *testing.T) {
	expected := 21
	actual := gc.GarbageCollection([]string{"G", "P", "GP", "GG"}, []int{2, 4, 3})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
