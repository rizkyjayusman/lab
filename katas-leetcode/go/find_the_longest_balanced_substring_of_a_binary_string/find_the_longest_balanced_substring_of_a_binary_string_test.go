package main

import "testing"

var (
	ftlb FindTheLongestBalancedSubstringOfABinaryString = FindTheLongestBalancedSubstringOfABinaryString{}
)

func TestFindTheLongestBalancedSubstring1(t *testing.T) {
	expected := 6
	actual := ftlb.FindTheLongestBalancedSubstring("01000111")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestFindTheLongestBalancedSubstring2(t *testing.T) {
	expected := 4
	actual := ftlb.FindTheLongestBalancedSubstring("00111")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestFindTheLongestBalancedSubstring3(t *testing.T) {
	expected := 0
	actual := ftlb.FindTheLongestBalancedSubstring("111")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestFindTheLongestBalancedSubstring4(t *testing.T) {
	expected := 0
	actual := ftlb.FindTheLongestBalancedSubstring("10")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestFindTheLongestBalancedSubstring5(t *testing.T) {
	expected := 2
	actual := ftlb.FindTheLongestBalancedSubstring("001")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestFindTheLongestBalancedSubstring6(t *testing.T) {
	expected := 2
	actual := ftlb.FindTheLongestBalancedSubstring("00101")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}

func TestFindTheLongestBalancedSubstring7(t *testing.T) {
	expected := 4
	actual := ftlb.FindTheLongestBalancedSubstring("001101")
	t.Logf("expected : %v\n", expected)
	t.Logf("actual : %v\n", actual)

	if expected != actual {
		t.Error("FAIL ~ value is not match")
	}
}
