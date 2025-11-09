package main

import "fmt"

func main() {
	fmt.Println(leftRigthDifference([]int{10, 4, 8, 3}))
}

func leftRigthDifference(nums []int) []int {
	total := 0
	for i := 0; i < len(nums); i++ {
		total += nums[i]
	}

	totalRight := total
	sumLeft := make([]int, len(nums))
	sumRight := make([]int, len(nums))
	i, j := 0, len(nums)-1
	for i < len(nums) && j >= 0 {
		sumLeft[i] = totalRight - nums[i]
		sumRight[j] = total - nums[j]
		totalRight -= nums[i]
		total -= nums[j]
		i++
		j--
	}

	var arr []int
	for x := 0; x < len(sumLeft); x++ {
		res := sumRight[x] - sumLeft[x]
		if res < 0 {
			res = 0 - res
		}
		arr = append(arr, res)
	}

	return arr
}
