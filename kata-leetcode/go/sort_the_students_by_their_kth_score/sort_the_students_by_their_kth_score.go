package main

type StudentScore struct{}

func (s StudentScore) SortTheStudents(score [][]int, k int) [][]int {
	var temp []int
	for i := 0; i <= len(score)-1; i++ {
		for j := 0; j < len(score)-i-1; j++ {
			if score[j][k] < score[j+1][k] {
				temp = score[j]
				score[j] = score[j+1]
				score[j+1] = temp
			}
		}
	}
	return score
}
