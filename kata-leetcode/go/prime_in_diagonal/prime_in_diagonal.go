package main

import (
	"math"
)

type PrimeInDiagonal struct{}

func (pid PrimeInDiagonal) DiagonalPrime(nums [][]int) int {
	max := 0
	next := 0
	for i := 0; i < len(nums); i++ {
		left := nums[i][next]
		if isPrime(left) && left > max {
			max = left
		}

		right := nums[i][len(nums)-1-next]
		if isPrime(right) && right > max {
			max = right
		}

		next++
	}
	return max
}

func isPrime(num int) bool {
	if num < 2 {
		return false
	}
	sq_root := int(math.Sqrt(float64(num)))
	for i := 2; i <= sq_root; i++ {
		if num%i == 0 {
			return false
		}
	}

	return true
}
