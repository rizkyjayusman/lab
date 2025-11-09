package main

import "fmt"

func main() {
	fmt.Println(removeDuplicates([]int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}))
}

func removeDuplicates(nums []int) int {

	last_el := -101
	current_idx := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] > last_el {
			last_el = nums[i]
			nums[current_idx] = nums[i]
			current_idx++
		}
	}

	fmt.Println(nums)

	return current_idx
}
