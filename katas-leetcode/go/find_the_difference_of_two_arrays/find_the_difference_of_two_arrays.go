package main

type TwoArray struct{}

func (ta TwoArray) FindDifference(nums1 []int, nums2 []int) [][]int {
	m1 := make(map[int]bool)
	for _, v := range nums1 {
		if _, ok := m1[v]; !ok {
			m1[v] = false
		}
	}

	m2 := make(map[int]bool)
	for _, v := range nums2 {
		if _, ok := m1[v]; !ok {
			m2[v] = false
			continue
		}

		m1[v] = true
		m2[v] = true
	}

	res := make([][]int, 2)
	for k, v := range m1 {
		if !v {
			res[0] = append(res[0], k)
		}
	}

	for k, v := range m2 {
		if !v {
			res[1] = append(res[1], k)
		}
	}

	return res
}
