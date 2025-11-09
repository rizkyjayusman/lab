package main

import "fmt"

func main() {
	fmt.Println(mySqrt(12))
}

func mySqrt(x int) int {
	i := 1
	res := 0
	for {
		x = x - i
		i += 2
		if x < 0 {
			break
		}
		res++
	}

	return res
}
