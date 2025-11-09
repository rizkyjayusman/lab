package main

import (
	"fmt"
)

func main() {
	fmt.Println(pivotInteger(8))
	fmt.Println(pivotInteger(1))
	fmt.Println(pivotInteger(49))
	fmt.Println(pivotInteger(4))
}

func pivotInteger(n int) int {
	if n == 1 {
		return n
	}

	i, j, count_i, count_j := 1, n, 0, 0
	for {
		if count_i < count_j {
			count_i += i
			i++
		} else {
			count_j += j
			j--
		}
		fmt.Println(i, j, count_i, count_j)
		if count_i == count_j && i == j || i > n || j == 0 {
			break
		}
	}

	if i == j {
		return i
	}

	return -1
}
