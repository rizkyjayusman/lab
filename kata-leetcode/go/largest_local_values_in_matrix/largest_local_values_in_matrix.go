package main

import "fmt"

func main() {
	fmt.Println(largestLocal([][]int{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}}))
	fmt.Println(largestLocal([][]int{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}}))
}

func largestLocal(grid [][]int) [][]int {
	var maxLocal [][]int
	lenGrid := len(grid)
	for i := 0; i < lenGrid-2; i++ {
		var arrRow []int
		for j := 0; j < lenGrid-2; j++ {
			max := 0
			for x := i; x < i+3; x++ {
				for y := j; y < j+3; y++ {
					if grid[x][y] > max {
						max = grid[x][y]
					}
				}
			}
			arrRow = append(arrRow, max)
		}
		maxLocal = append(maxLocal, arrRow)
	}
	return maxLocal
}
