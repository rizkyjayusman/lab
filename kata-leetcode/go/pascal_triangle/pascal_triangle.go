package main

import "fmt"

func main() {
	fmt.Println(generate(10))
}

func generate(numRows int) [][]int {
	var arr [][]int
	for i := 0; i < numRows; i++ {
		var arrm []int
		for j := 0; j <= i; j++ {
			put := 1
			if j > 0 && j != i {
				put = arr[i-1][j-1] + arr[i-1][j]
			}
			arrm = append(arrm, put)
		}
		arr = append(arr, arrm)
	}
	return arr
}
