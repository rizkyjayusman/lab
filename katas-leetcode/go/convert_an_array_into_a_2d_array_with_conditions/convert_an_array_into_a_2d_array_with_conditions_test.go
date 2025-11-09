package main

import (
	"fmt"
	"testing"
)

var (
	tarr TwoDimensionArray = TwoDimensionArray{}
)

func TestFindMatrix(t *testing.T) {
	expected := [][]int{{1, 3, 4, 2}, {1, 3}, {1}}
	actual := tarr.FindMatrix([]int{1, 3, 4, 1, 2, 3, 1})

	fmt.Println(expected, "\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		if len(v) != len(expected[k]) {
			t.Error("value is not match")
		}

		for kk, vv := range v {
			if vv != expected[k][kk] {
				t.Errorf("value (%v %v) is not match", vv, expected[k][kk])
			}
		}
	}
}
