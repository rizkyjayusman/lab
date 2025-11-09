package main

import "fmt"

func main() {
	fmt.Println(decompressRLElist([]int{1, 2, 3, 4}))
}

func decompressRLElist(nums []int) []int {
	var arr []int
	for i := 0; i < len(nums); i++ {
		x := nums[i]
		i++
		y := nums[i]
		for j := 0; j < x; j++ {
			arr = append(arr, y)
		}
	}
	return arr
}
