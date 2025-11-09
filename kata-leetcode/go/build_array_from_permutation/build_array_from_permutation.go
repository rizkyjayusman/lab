package main

type BuildArrayFromPermutation struct{}

func (bafp BuildArrayFromPermutation) BuildArray(nums []int) []int {
	var arr []int
	for _, v := range nums {
		arr = append(arr, nums[v])
	}
	return arr
}
