package main

import "testing"

var (
	fp FirstPalindrome = FirstPalindrome{}
)

func TestFirstPalindrome(t *testing.T) {
	expected := "ada"
	actual := fp.firstPalindrome([]string{"abc", "car", "ada", "racecar", "cool"})
	t.Logf("expected : %s\n", expected)
	t.Logf("actual : %s\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestFirstPalindrome2(t *testing.T) {
	expected := "racecar"
	actual := fp.firstPalindrome([]string{"notapalindrome", "racecar"})
	t.Logf("expected : %s\n", expected)
	t.Logf("actual : %s\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestFirstPalindrome3(t *testing.T) {
	expected := ""
	actual := fp.firstPalindrome([]string{"def", "ghi"})
	t.Logf("expected : %s\n", expected)
	t.Logf("actual : %s\n", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
