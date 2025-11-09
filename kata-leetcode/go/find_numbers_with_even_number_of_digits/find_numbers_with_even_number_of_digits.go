package main

type FindNumber struct{}

func (fn FindNumber) FindNumbers(nums []int) int {
	res := 0
	for _, v := range nums {
		cnt := 0
		for v > 0 {
			cnt++
			v /= 10
		}

		if cnt%2 == 0 {
			res++
		}
	}

	return res
}
