package main

import (
	"sort"
)

type SlideSubArray struct{}

func (ss SlideSubArray) GetSubarrayBeauty(nums []int, k int, x int) []int {
	strt, strtcnt, i := 0, 0, 0
	chck := make([]int, x)
	var res []int
	for {
		if strt+k > len(nums) {
			break
		}

		// TODO :: need sort it on fly
		chck[strtcnt] = nums[i]

		if i == strt+k-1 {
			strt++
			i = strt
			strtcnt = 0
			sort.Ints(chck)
			c := chck[x-1]
			if c > 0 {
				c = 0
			}

			res = append(res, c)
			continue
		}

		i++
		strtcnt++
	}
	return res
}
