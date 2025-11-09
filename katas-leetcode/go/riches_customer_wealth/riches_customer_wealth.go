package main

import "fmt"

func main() {
	// fmt.Println(maximumWealth([][]int{{1, 2, 3}, {3, 2, 1}}))
	// fmt.Println(maximumWealth([][]int{{1, 5}, {7, 3}, {3, 5}}))
	fmt.Println(maximumWealth([][]int{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}))
}

func maximumWealth(accounts [][]int) int {
	var high int
	for _, x := range accounts {
		var count int
		for _, y := range x {
			count += y
		}

		if count > high {
			high = count
		}
	}
	return high
}
