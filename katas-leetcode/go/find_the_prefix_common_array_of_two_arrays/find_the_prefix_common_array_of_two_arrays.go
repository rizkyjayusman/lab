package main

type CommonPrefix struct{}

func (cp CommonPrefix) FindThePrefixCommonArray(A []int, B []int) []int {
	var res []int
	m := make(map[int]struct{})
	for i := 0; i < len(A); i++ {
		if _, ok := m[A[i]]; !ok {
			m[A[i]] = struct{}{}
		}

		count := 0
		for j := 0; j <= i; j++ {
			if _, ok := m[B[j]]; ok {
				count++
			}
		}
		res = append(res, count)
	}
	return res
}
