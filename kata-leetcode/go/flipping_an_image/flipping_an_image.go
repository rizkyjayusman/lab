package main

import (
	"fmt"
)

func main() {
	fmt.Println(flipAndInvertImage([][]int{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}}))
	// [[0,1,1],[1,0,1],[0,0,0]] -> [1,0,0],[0,1,0],[1,1,1]]
	fmt.Println(flipAndInvertImage([][]int{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}})) // [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
}

func flipAndInvertImage(image [][]int) [][]int {
	for k, i := range image {
		var arr []int
		for j := len(i) - 1; j >= 0; j-- {
			elm := i[j]
			if elm == 1 {
				elm = 0
			} else {
				elm = 1
			}
			arr = append(arr, elm)
		}
		image[k] = arr
	}
	return image
}
