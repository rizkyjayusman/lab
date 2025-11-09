package main

type Ball struct{}

func (b Ball) MinOperations(boxes string) []int {
	var existBoxes []int
	for k, v := range boxes {
		if v == '1' {
			existBoxes = append(existBoxes, k)
		}
	}

	res := make([]int, len(boxes))
	for _, v := range existBoxes {
		for i := 0; i < len(boxes); i++ {
			x := v - i
			if x < 0 {
				x = -x
			}

			res[i] += x
		}
	}

	return res
}
