package main

import "fmt"

func main() {
	fmt.Println(diagonalSum([][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}))
	fmt.Println(diagonalSum([][]int{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}))
	fmt.Println(diagonalSum([][]int{{5}}))
}

func diagonalSum(mat [][]int) int {
	res := 0
	x := 0
	y := len(mat) - 1
	for i := 0; i < len(mat); i++ {
		if x == y {
			res += mat[i][x]
		} else {
			res += mat[i][x] + mat[i][y]
		}
		x++
		y--
	}
	return res
}
