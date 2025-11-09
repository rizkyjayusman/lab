package main

import (
	"testing"
)

var (
	citsip CheckIfTheSentenceIsPangram = CheckIfTheSentenceIsPangram{}
)

func TestCheckIfTheSentenceIsPangram1(t *testing.T) {
	expected := true
	actual := citsip.CheckIfPangram("thequickbrownfoxjumpsoverthelazydog")

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestCheckIfTheSentenceIsPangram2(t *testing.T) {
	expected := false
	actual := citsip.CheckIfPangram("leetcode")

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}
