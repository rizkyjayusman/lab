package main

import (
	"fmt"
)

func main() {
	// fmt.Println(numberOfMatches(7))
	// fmt.Println(numberOfMatches(14))
	// fmt.Println(numberOfMatches(1))
	fmt.Println(numberOfMatches(2))
}

func numberOfMatches(n int) int {
	match := 0
	count := 0
	for {
		fmt.Println(n, match, count)
		if n%2 == 0 {
			n /= 2
			match = n
		} else {
			match = (n - 1) / 2
			n = (n-1)/2 + 1
		}

		count += match

		if n <= 1 {
			break
		}
	}
	return count
}
