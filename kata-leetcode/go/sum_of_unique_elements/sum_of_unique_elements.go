package main

type Element struct{}

func (e Element) SumOfUnique(nums []int) int {
	m := make(map[int]int)
	for _, v := range nums {
		if _, ok := m[v]; ok {
			m[v] = m[v] + 1
			continue
		}
		m[v] = 1
	}

	res := 0
	for k, v := range m {
		if v == 1 {
			res += k
		}
	}
	return res
}
