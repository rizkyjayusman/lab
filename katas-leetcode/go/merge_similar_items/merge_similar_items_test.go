package main

import "testing"

var (
	i Item = Item{}
)

func TestMergeSimilarItems(t *testing.T) {
	expected := [][]int{{1, 6}, {3, 9}, {4, 5}}
	actual := i.MergeSimilarItems([][]int{{1, 1}, {4, 5}, {3, 8}}, [][]int{{3, 1}, {1, 5}})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		for kk, vv := range v {
			if vv != expected[k][kk] {
				t.Errorf("value (%v, %v) is not match\n", v, expected[k])
			}
		}
	}
}

func TestMergeSimilarItems2(t *testing.T) {
	expected := [][]int{{1, 4}, {2, 4}, {3, 4}}
	actual := i.MergeSimilarItems([][]int{{1, 1}, {3, 2}, {2, 3}}, [][]int{{2, 1}, {3, 2}, {1, 3}})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		for kk, vv := range v {
			if vv != expected[k][kk] {
				t.Errorf("value (%v, %v) is not match\n", v, expected[k])
			}
		}
	}
}

func TestMergeSimilarItems3(t *testing.T) {
	expected := [][]int{{1, 7}, {2, 4}, {7, 1}}
	actual := i.MergeSimilarItems([][]int{{1, 3}, {2, 2}}, [][]int{{7, 1}, {2, 2}, {1, 4}})
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if len(expected) != len(actual) {
		t.Error("value is not match")
	}

	for k, v := range actual {
		for kk, vv := range v {
			if vv != expected[k][kk] {
				t.Errorf("value (%v, %v) is not match\n", v, expected[k])
			}
		}
	}
}
