package main

import "testing"

var (
	s Shop = Shop{}
)

func TestFinalPrice(t *testing.T) {
	expected := []int{4, 2, 4, 2, 3}
	actual := s.FinalPrices([]int{8, 4, 6, 2, 3})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v, %v) is not match", v, expected[k])
		}
	}
}

func TestFinalPrice2(t *testing.T) {
	expected := []int{1, 2, 3, 4, 5}
	actual := s.FinalPrices([]int{1, 2, 3, 4, 5})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v, %v) is not match", v, expected[k])
		}
	}
}

func TestFinalPrice3(t *testing.T) {
	expected := []int{9, 0, 1, 6}
	actual := s.FinalPrices([]int{10, 1, 1, 6})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		if v != expected[k] {
			t.Errorf("value (%v, %v) is not match", v, expected[k])
		}
	}
}
