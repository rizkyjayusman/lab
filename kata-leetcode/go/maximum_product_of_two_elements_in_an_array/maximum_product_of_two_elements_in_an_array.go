package main

import "fmt"

func main() {
	fmt.Println(maxProduct([]int{3, 4, 5, 2}))
	fmt.Println(maxProduct([]int{1, 5, 4, 5}))
	fmt.Println(maxProduct([]int{3, 7}))
}

func maxProduct(nums []int) int {
	// find by the result
	max := 0
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			count := (nums[i] - 1) * (nums[j] - 1)
			if max < count {
				max = count
			}
		}
	}

	return max
}
