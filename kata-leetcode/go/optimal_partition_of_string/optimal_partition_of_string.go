package main

type OptimalString struct{}

func (o OptimalString) PartitionString(s string) int {
	cnt := 0
	m := make(map[rune]int)
	for _, v := range s {
		if _, ok := m[v]; ok {
			cnt++
			m = make(map[rune]int)
		}

		m[v] = cnt
	}

	return cnt + 1
}
