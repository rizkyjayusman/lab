package main

import (
	"fmt"
)

func main() {
	print([]int{0, 1, 0, 3, 12})
	// print([]int{0})
	// print([]int{4, 2, 4, 0, 0, 3, 0, 5, 1, 0})
	// print([]int{1, 0, 1})
}

func print(i []int) {
	moveZeroes(i)
	fmt.Println(i)
}

func moveZeroes(nums []int) {
	i := 0
	j := 1
	for i < len(nums) && j < len(nums) {
		if nums[i] == 0 {
			if nums[j] != 0 {
				tmp := nums[j]
				nums[i] = tmp
				nums[j] = 0
			} else {
				j++
				continue
			}
		}
		i++
		j++
	}
}
