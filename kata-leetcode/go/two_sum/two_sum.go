package main

import "fmt"

func main() {
	fmt.Println(twoSum([]int{2, 7, 4, 15}, 9))
}

func twoSum(nums []int, target int) []int {
	hmap := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		if v, ok := hmap[target-nums[i]]; ok {
			return []int{v, i}
		}

		hmap[nums[i]] = i

	}

	return []int{}
}
