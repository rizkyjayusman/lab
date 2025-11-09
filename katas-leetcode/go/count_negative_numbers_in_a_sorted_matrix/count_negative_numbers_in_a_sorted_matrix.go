package main

type Counter struct{}

func (c Counter) CountNegatives(grid [][]int) int {
	res := 0
	for _, v := range grid {
		for i := len(v) - 1; i >= 0; i-- {
			if v[i] > -1 {
				break
			}
			res++
		}
	}
	return res
}
