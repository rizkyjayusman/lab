package main

import "fmt"

func main() {
	fmt.Println(removeElement([]int{0, 1, 2, 2, 3, 0, 4, 2}, 2))
}

func removeElement(nums []int, val int) int {
	count := 0
	for j := range nums {
		if nums[j] != val {
			nums[count] = nums[j]
			count++
		}
	}
	return count
}
