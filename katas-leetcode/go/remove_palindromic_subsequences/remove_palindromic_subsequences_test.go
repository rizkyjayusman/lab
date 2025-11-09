package main

import "testing"

var (
	p Palindromic = Palindromic{}
)

func TestRemovePalindromeSub(t *testing.T) {
	expected := 1
	actual := p.RemovePalindromeSub("ababa")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestRemovePalindromeSub2(t *testing.T) {
	expected := 2
	actual := p.RemovePalindromeSub("abb")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestRemovePalindromeSub3(t *testing.T) {
	expected := 2
	actual := p.RemovePalindromeSub("baabb")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}
