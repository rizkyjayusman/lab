package main

import "fmt"

func main() {
	fmt.Println(searchInsert([]int{1, 3, 5, 6}, 5))
	fmt.Println(searchInsert([]int{1, 3, 5, 6}, 2))
	fmt.Println(searchInsert([]int{1, 3, 5, 6}, 7))
}

func searchInsert(nums []int, target int) int {
	i := 0
	for j := range nums {
		if nums[j] >= target {
			break
		}

		i++
	}
	return i
}
