package main

import "fmt"

func main() {
	fmt.Println(findCenter([][]int{{1, 2}, {2, 3}, {4, 2}}))
	fmt.Println(findCenter([][]int{{1, 2}, {5, 1}, {1, 3}, {1, 4}}))
}

func findCenter(edges [][]int) int {
	m := make(map[int]int)
	for _, i := range edges {
		for _, j := range i {
			if _, ok := m[j]; ok {
				m[j] = m[j] + 1
			} else {
				m[j] = 1
			}
		}
	}

	for k, v := range m {
		if v == len(edges) {
			return k
		}
	}
	return -1
}
