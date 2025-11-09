package main

type MaxSum struct{}

func (ms MaxSum) MaximizeSum(nums []int, k int) int {
	max := 0
	for _, v := range nums {
		if v > max {
			max = v
		}
	}

	var res int
	for i := 0; i < k; i++ {
		res += max + i
	}

	return res
}
