package main

import "fmt"

func main() {
	// fmt.Println(countDigits(7))
	fmt.Println(countDigits(121))
	// fmt.Println(countDigits(1248))
}

func countDigits(num int) int {
	var count int
	x := num
	for x > 0 {
		if num%(x%10) == 0 {
			count++
		}
		x /= 10
	}
	return count
}
