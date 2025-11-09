package main

import "fmt"

func main() {
	// fmt.Println(differenceOfSum([]int{1, 15, 6, 3}))
	fmt.Println(differenceOfSum([]int{1, 2, 3, 4}))
}

func differenceOfSum(nums []int) int {
	elementSum, digitSum := 0, 0

	for _, num := range nums {
		elementSum += num
		for num > 0 {
			digitSum += num % 10
			num /= 10
		}
	}
	return elementSum - digitSum
}
