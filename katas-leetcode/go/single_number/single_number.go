package main

import "fmt"

func main() {
	fmt.Println(singleNumber([]int{2, 2, 1}))
	// fmt.Println(singleNumber([]int{4, 1, 2, 1, 2}))
	// fmt.Println(singleNumber([]int{1}))
}

func singleNumber(nums []int) int {
	hmap := make(map[int]int)
	for _, v := range nums {
		if _, ok := hmap[v]; !ok {
			hmap[v] = 1
			continue
		}

		hmap[v]++
	}

	for k, v := range hmap {
		if v == 1 {
			return k
		}
	}
	return -1
}
