package main

import (
	"fmt"
)

func main() {
	// fmt.Println(numberOfSteps(14))
	fmt.Println(numberOfSteps(8))
}

func numberOfSteps(num int) int {
	var cnt int
	for num > 0 {
		cnt++
		if num%2 == 0 {
			num /= 2
			continue
		}

		num--
	}
	return cnt
}
