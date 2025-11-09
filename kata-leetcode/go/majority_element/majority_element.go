package main

import "fmt"

func main() {
	fmt.Printf("res::%v", majorityElement([]int{3, 2, 3}))
	// fmt.Println(majorityElement([]int{2, 2, 1, 1, 1, 2, 2}))
}

func majorityElement(nums []int) int {
	hmap := make(map[int]int)
	for _, v := range nums {
		hmap[v] += 1
		if hmap[v] > len(nums)/2 {
			return v
		}
	}

	return -1
}
