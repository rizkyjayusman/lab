package main

import "testing"

var (
	cw CountingWord = CountingWord{}
)

func TestPrefixCount(t *testing.T) {
	expected := 2
	actual := cw.PrefixCount([]string{"pay", "attention", "practice", "attend"}, "at")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Log("value is not match")
	}
}

func TestPrefixCount2(t *testing.T) {
	expected := 0
	actual := cw.PrefixCount([]string{"leetcode", "win", "loops", "success"}, "code")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Log("value is not match")
	}
}
