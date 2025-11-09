package main

import (
	"fmt"
)

func main() {
	fmt.Println(isHappy(2))
}

func isHappy(n int) bool {
	for {
		if n == 1 {
			return true
		} else if n == 4 {
			return false
		}

		res := 0
		for n != 0 {
			modv := n % 10
			res += modv * modv
			n /= 10
		}

		n = res
	}
}
