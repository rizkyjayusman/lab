package main

import (
	"fmt"
)

func main() {
	fmt.Println(missingNumber([]int{3, 0, 1}))
	// fmt.Println(missingNumber([]int{0, 1}))
	// fmt.Println(missingNumber([]int{9, 6, 4, 2, 3, 5, 7, 0, 1}))
}

func missingNumber(nums []int) int {
	a := 0
	b := 0
	len := len(nums)
	for i := 0; i <= len; i++ {
		b += i
		if i < len {
			a += nums[i]
		}
	}

	return b - a
}
