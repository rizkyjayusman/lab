package main

import "fmt"

func main() {
	fmt.Println(isPalindrome(12131))
}

func isPalindrome(x int) bool {
	input := x

	// parse
	res := 0
	diff := 0
	for x > 0 {
		diff = x % 10
		res = (res * 10) + diff
		x /= 10
	}

	fmt.Printf("(%v) (%v)", input, res)
	return input == res
}
