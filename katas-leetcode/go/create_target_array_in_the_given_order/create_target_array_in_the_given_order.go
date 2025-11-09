package main

import "fmt"

func main() {
	fmt.Println(createTargetArray([]int{0, 1, 2, 3, 4}, []int{0, 1, 2, 2, 1}))
	// fmt.Println(createTargetArray([]int{1, 2, 3, 4, 0}, []int{0, 1, 2, 3, 0}))
	// fmt.Println(createTargetArray([]int{1}, []int{0}))
}

func createTargetArray(nums []int, index []int) []int {
	arr := make([]int, len(nums))
	for k, v := range nums {
		if k != index[k] {
			left := append(append([]int{}, arr[:index[k]]...), v)
			right := append([]int{}, arr[index[k]:len(nums)-1]...)
			arr = append(left, right...)
		} else {
			arr[k] = v
		}
	}
	return arr
}
