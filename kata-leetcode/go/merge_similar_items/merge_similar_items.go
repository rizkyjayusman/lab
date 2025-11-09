package main

import "sort"

type Item struct{}

func (i Item) MergeSimilarItems(items1 [][]int, items2 [][]int) [][]int {
	m := make(map[int]int)
	for _, v := range items1 {
		if vv, ok := m[v[0]]; ok {
			m[v[0]] = v[1] + vv
			continue
		}

		m[v[0]] = v[1]
	}

	for _, v := range items2 {
		if vv, ok := m[v[0]]; ok {
			m[v[0]] = v[1] + vv
			continue
		}

		m[v[0]] = v[1]
	}

	var arr []int
	for k := range m {
		arr = append(arr, k)
	}

	sort.Ints(arr)

	var res [][]int
	for _, v := range arr {
		res = append(res, []int{v, m[v]})
	}

	return res
}
