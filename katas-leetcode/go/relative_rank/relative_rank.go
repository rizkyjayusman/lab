package main

import "fmt"

func main() {
	fmt.Println(findRelativeRanks([]int{5, 4, 3, 2, 1}))
	// fmt.Println(findRelativeRanks([]int{1, 3, 2, 5, 4}))
}

func findRelativeRanks(score []int) []string {
	g := 0
	s := 0
	b := 0
	for _, v := range score {
		if v > g {
			tmp := g
			g = v
			v = tmp
		}

		if v > s {
			tmp := s
			s = v
			v = tmp
		}

		if v > b {
			b = v
		}
	}

	arr := make([]string, len(score))
	for k, v := range score {
		val := fmt.Sprint(v)
		if v == g {
			val = "Gold Medal"
		} else if v == s {
			val = "Silver Medal"
		} else if v == b {
			val = "Bronze Medal"
		}
		arr[k] = val
	}

	return arr
}
