package main

type MaxOne struct{}

func (mo MaxOne) RowAndMaximumOnes(mat [][]int) []int {
	idx := 0
	maxOnes := 0
	for i := 0; i < len(mat); i++ {
		cnt := 0
		for j := 0; j < len(mat[i]); j++ {
			if mat[i][j] == 1 {
				cnt++
			}
		}

		if cnt > maxOnes {
			idx = i
			maxOnes = cnt
		}
	}

	return []int{idx, maxOnes}
}
