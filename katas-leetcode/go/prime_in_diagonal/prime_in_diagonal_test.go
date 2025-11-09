package main

import "testing"

var (
	pid PrimeInDiagonal = PrimeInDiagonal{}
)

func TestDiagonalPrimes(t *testing.T) {
	expected := 7
	actual := pid.DiagonalPrime([][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})
	t.Logf("expected : %v", expected)
	t.Logf("actual : %v", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestDiagonalPrimes2(t *testing.T) {
	expected := 11
	actual := pid.DiagonalPrime([][]int{{1, 2, 3}, {5, 6, 7}, {9, 10, 11}})
	t.Logf("expected : %v", expected)
	t.Logf("actual : %v", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}

func TestDiagonalPrimes3(t *testing.T) {
	expected := 17
	actual := pid.DiagonalPrime([][]int{{1, 2, 3}, {5, 17, 7}, {9, 11, 10}})
	t.Logf("expected : %v", expected)
	t.Logf("actual : %v", actual)

	if expected != actual {
		t.Error("value is not match")
	}
}
