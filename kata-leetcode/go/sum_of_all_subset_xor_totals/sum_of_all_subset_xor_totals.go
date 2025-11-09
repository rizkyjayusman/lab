package main

import "fmt"

type SumSubset struct{}

func (s SumSubset) SubsetXORSum(nums []int) int {
	res := 0
	fmt.Println(nums[1:])
	return res
}

func (s SumSubset) MakeSubset(nums []int) [][]int {
	var res [][]int
	if len(nums) == 0 {
		return res
	}

	var arr []int
	for k, v := range nums {
		arr = append(arr, v)
		res = append(res, s.MakeSubset(nums[k:])...)
	}

	res = append(res, arr)

	return res
}
