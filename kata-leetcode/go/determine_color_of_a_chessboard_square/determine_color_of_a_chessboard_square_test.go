package main

import "testing"

var (
	cb ChessBoardSquare = ChessBoardSquare{}
)

func TestSquareIsWhite(t *testing.T) {
	expected := false
	actual := cb.SquareIsWhite("a1")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)
	if expected != actual {
		t.Error("value is not match")
	}
}

func TestSquareIsWhite2(t *testing.T) {
	expected := true
	actual := cb.SquareIsWhite("h3")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)
	if expected != actual {
		t.Error("value is not match")
	}
}

func TestSquareIsWhite3(t *testing.T) {
	expected := false
	actual := cb.SquareIsWhite("c7")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)
	if expected != actual {
		t.Error("value is not match")
	}
}
