package main

import (
	"fmt"
	"sort"
)

func main() {
	// fmt.Println(minimumSum(2932))
	fmt.Println(minimumSum(4009))
}

func minimumSum(num int) int {
	var arr []int
	for num > 0 {
		arr = append(arr, num%10)
		num /= 10
	}

	sort.Slice(arr, func(i, j int) bool {
		return arr[i] < arr[j]
	})

	return ((arr[0] * 10) + arr[2]) + (arr[1] * 10) + arr[3]
}
