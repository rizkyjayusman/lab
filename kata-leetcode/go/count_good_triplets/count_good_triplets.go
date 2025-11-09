package main

import (
	"fmt"
)

func main() {
	fmt.Println(countGoodTriplets([]int{3, 0, 1, 1, 9, 7}, 7, 2, 3))
	fmt.Println(countGoodTriplets([]int{1, 1, 2, 2, 3}, 0, 0, 1))
}

func countGoodTriplets(arr []int, a int, b int, c int) int {
	res := 0
	lenArr := len(arr)
	for i := 0; i < lenArr-2; i++ {
		for j := i + 1; j < lenArr-1; j++ {
			if abs(arr[i]-arr[j]) > a {
				continue
			}

			for k := j + 1; k < lenArr; k++ {
				if abs(arr[j]-arr[k]) > b || abs(arr[i]-arr[k]) > c {
					continue
				}
				res++
			}
		}
	}
	return res
}

func abs(val int) int {
	if val < 0 {
		val *= -1
	}
	return val
}
