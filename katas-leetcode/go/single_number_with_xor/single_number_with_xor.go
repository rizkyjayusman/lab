package main

import "fmt"

func main() {
	// fmt.Println(singleNumber([]int{2, 2, 1}))
	fmt.Println(singleNumber([]int{4, 1, 2, 1, 2}))
	// fmt.Println(singleNumber([]int{1}))
}

func singleNumber(nums []int) (res int) {
	for _, v := range nums {
		fmt.Printf("%v %v => %v\n", res, v, res^v)
		res ^= v
	}
	return res
}
