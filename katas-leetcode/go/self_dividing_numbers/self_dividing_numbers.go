package main

type DividingNumber struct{}

func (dn DividingNumber) SelfDividingNumbers(left int, right int) []int {
	var res []int
	for left <= right {
		input := left
		x := 10

		isAppend := true
		for input > 0 {
			diff := input % x
			if diff == 0 || left%diff != 0 {
				isAppend = false
				break
			}

			input /= x
		}

		if isAppend {
			res = append(res, left)
		}

		left++
	}
	return res
}
