package main

import "fmt"

func main() {
	// fmt.Println(xorOperation(5, 0))
	fmt.Println(xorOperation(4, 3))
}

func xorOperation(n int, start int) int {
	x := start
	for i := 1; i < n; i++ {
		x ^= (start + 2*i)
	}
	return x
}
