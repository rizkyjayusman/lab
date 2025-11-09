package main

type StringMatcher struct{}

func (sm StringMatcher) DiStringMatch(s string) []int {
	min := 0
	max := len(s)
	var res []int
	for _, v := range s {
		if v == 'I' {
			res = append(res, min)
			min++
		} else if v == 'D' {
			res = append(res, max)
			max--
		}
	}

	if min == max {
		res = append(res, min)
	}

	return res
}
