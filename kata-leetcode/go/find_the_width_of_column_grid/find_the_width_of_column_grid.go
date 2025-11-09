package main

type Grid struct{}

func (g Grid) FindColumnWidth(grid [][]int) []int {
	var res []int
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			v := grid[i][j]
			cnt := cntWidth(v)

			if i == 0 {
				res = append(res, cnt)
			} else if cnt > res[j] {
				res[j] = cnt
			}
		}
	}

	return res
}

func cntWidth(v int) int {
	cnt := 0
	if v < 0 {
		v *= -1
		cnt++
	}

	x := 1
	for v > 0 {
		cnt++
		v /= x * 10
	}

	return cnt
}
