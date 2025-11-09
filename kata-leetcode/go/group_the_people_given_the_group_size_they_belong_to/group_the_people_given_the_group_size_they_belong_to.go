package main

type Group struct{}

func (g Group) GroupThePeople(groupSizes []int) [][]int {
	m := make(map[int][]int)
	for k, v := range groupSizes {
		if _, ok := m[v]; ok {
			m[v] = append(m[v], k)
			continue
		}

		m[v] = append(m[v], k)
	}

	var res [][]int
	for k, v := range m {
		var arr []int
		for _, vv := range v {
			arr = append(arr, vv)
			if len(arr) == k {
				res = append(res, arr)
				arr = make([]int, 0)
			}
		}
	}

	return res
}
