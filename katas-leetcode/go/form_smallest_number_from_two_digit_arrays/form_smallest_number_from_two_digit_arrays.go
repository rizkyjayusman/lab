package main

type FormSmallestNumberFromTwoDigitArrays struct{}

func (fsnftda FormSmallestNumberFromTwoDigitArrays) MinNumber(nums1 []int, nums2 []int) int {
	res := 99
	for _, v := range nums1 {
		for _, iv := range nums2 {
			sum := v
			if v > iv {
				sum += (iv * 10)
			} else if v < iv {
				sum = (sum * 10) + iv
			}

			if sum < res {
				res = sum
			}
		}
	}
	return res
}
