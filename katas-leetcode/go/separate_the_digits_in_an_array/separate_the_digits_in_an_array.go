package main

import "fmt"

func main() {
	fmt.Println(separateDigits([]int{13, 25, 83, 77}))
}

func separateDigits(nums []int) []int {
	var arr []int
	for _, v := range nums {
		var inarr []int
		for v > 0 {
			inarr = append([]int{v % 10}, inarr...)
			v /= 10
		}
		arr = append(arr, inarr...)
	}

	return arr
}
