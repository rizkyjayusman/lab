package main

import "fmt"

type ConcatenationOfArray struct{}

func (coa ConcatenationOfArray) GetConcatenation(nums []int) []int {
	l := len(nums)
	for i := 0; i < l; i++ {
		fmt.Println(i)
		nums = append(nums, nums[i])
	}
	return nums
}
