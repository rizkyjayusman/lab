package main

type SumMultiple struct{}

func (sm SumMultiple) SumOfMultiples(n int) int {
	res := 0
	for i := 3; i <= n; i++ {
		if i%3 == 0 || i%5 == 0 || i%7 == 0 {
			res += i
			continue
		}
	}

	return res
}
