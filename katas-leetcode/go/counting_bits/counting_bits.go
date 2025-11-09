package main

import (
	"fmt"
)

func main() {
	fmt.Println(countBits(5))
}

func countBits(n int) []int {
	x := 1
	for {
		if x > n {
			x /= 2
			break
		}
		x *= 2
	}

	arr := make([]int, n+1)
	i := len(arr) - 1
	for i > 0 {
		r := n
		if r < x {
			x /= 2
		}

		y := x

		count := 0
		for y > 0 {
			if r-y >= 0 {
				r -= y
				count++
			}
			y /= 2
		}

		arr[i] = count
		n--
		i--
	}

	return arr
}
