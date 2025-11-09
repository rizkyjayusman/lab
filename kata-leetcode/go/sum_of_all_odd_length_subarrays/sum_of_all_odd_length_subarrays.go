package main

import (
	"fmt"
)

func main() {
	// fmt.Println(sumOddLengthSubarrays([]int{1, 4, 2, 5, 3})) // 58
	// fmt.Println(sumOddLengthSubarrays([]int{1, 2})) // 3
	fmt.Println(sumOddLengthSubarrays([]int{10, 11, 12})) // 66
}

func sumOddLengthSubarrays(arr []int) int {
	count := 0
	odd := 1
	for odd <= len(arr) {
		strt := 0
		x := 0
		for x < len(arr) {
			y := x
			if y < len(arr) {
				y += odd
			}
			for x < y && y <= len(arr) {
				count += arr[x]
				x++
			}
			strt++
			x = strt
		}
		odd += 2
	}

	return count
}
