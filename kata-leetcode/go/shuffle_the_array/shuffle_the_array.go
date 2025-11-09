package main

import "fmt"

func main() {
	fmt.Println(shuffle([]int{2, 5, 1, 3, 4, 7}, 3))
	// fmt.Println(shuffle([]int{1, 2, 3, 4, 4, 3, 2, 1}, 4))
	// fmt.Println(shuffle([]int{1, 1, 2, 2}, 2))
}

func shuffle(nums []int, n int) []int {
	var arr []int
	j := n
	for i := 0; i < n && j < len(nums); i++ {
		arr = append(arr, nums[i])
		arr = append(arr, nums[j])
		j++
	}
	return arr
}
