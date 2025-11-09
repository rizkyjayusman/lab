package main

type Score struct{}

func (s Score) MaxDivScore(nums []int, divisors []int) int {
	arr := make([]int, len(divisors))
	for _, v := range nums {
		for k, div := range divisors {
			if v%div == 0 {
				arr[k] = arr[k] + 1
			}
		}
	}

	topIdx := 0
	max := 0
	for k, v := range arr {
		if v > max {
			topIdx = k
			max = v
		}
	}

	return divisors[topIdx]
}
