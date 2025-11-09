package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(deleteGreatestValue([][]int{{1, 2, 4}, {3, 3, 1}}))
}

func deleteGreatestValue(grid [][]int) int {
	var arr []int
	for _, v := range grid {
		sort.Ints(v)
		if len(arr) == 0 {
			arr = append(arr, v...)
		} else {
			for ik, iv := range v {
				if iv > arr[ik] {
					arr[ik] = iv
				}
			}
		}
	}

	res := 0
	for _, v := range arr {
		res += v
	}

	return res
}
