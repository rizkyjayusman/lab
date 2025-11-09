package main

type FindTheSubstringWithMaximumCost struct{}

func (ftswmc FindTheSubstringWithMaximumCost) MaximumCostSubstring(s string, chars string, vals []int) int {
	tmp, res := 0, 0
	m := make(map[rune]int)
	for k, v := range chars {
		m[v] = vals[k]
	}

	for _, v := range s {
		r := int(v - 96)
		if rplc, ok := m[v]; ok {
			r = rplc
		}

		x := tmp + r
		if x < 0 {
			tmp = 0
			continue
		}

		tmp = x
		if tmp > res {
			res = tmp
		}
	}
	return res
}
