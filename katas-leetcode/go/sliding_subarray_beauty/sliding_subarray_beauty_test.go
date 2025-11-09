package main

import "testing"

var (
	ss SlideSubArray = SlideSubArray{}
)

func TestGetSubarrayBeauty(t *testing.T) {
	expected := []int{-1, -2, -2}
	actual := ss.GetSubarrayBeauty([]int{1, -1, -3, -2, 3}, 3, 2)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match\n")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v %v) is not match\n", v, expected[k])
		}
	}
}

func TestGetSubarrayBeauty2(t *testing.T) {
	expected := []int{-1, -2, -3, -4}
	actual := ss.GetSubarrayBeauty([]int{-1, -2, -3, -4, -5}, 2, 2)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match\n")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v %v) is not match\n", v, expected[k])
		}
	}
}

func TestGetSubarrayBeauty3(t *testing.T) {
	expected := []int{-3, 0, -3, -3, -3}
	actual := ss.GetSubarrayBeauty([]int{-3, 1, 2, -3, 0, -3}, 2, 1)
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match\n")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v %v) is not match\n", v, expected[k])
		}
	}
}
