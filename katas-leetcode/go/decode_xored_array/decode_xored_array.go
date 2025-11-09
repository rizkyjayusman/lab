package main

import "fmt"

func main() {
	// fmt.Println(decode([]int{1, 2, 3}, 1))
	fmt.Println(decode([]int{6, 2, 7, 3}, 4))
}

func decode(encoded []int, first int) []int {
	arr := []int{first}
	for _, e := range encoded {
		first ^= e
		arr = append(arr, first)
	}
	return arr
}
