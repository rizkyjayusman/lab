package main

import "fmt"

type PickingNumbers struct{}

func (pn PickingNumbers) PickingNumbers(a []int32) int32 {
	var res [][]int32
	var arr []int32
	last := -1
	x, y := 0, 1
	for x < len(a) && y < len(a) {
		c := a[x] - a[y]
		if c < 0 {
			c *= -1
		}

		if c <= 1 {
			arr = append(arr, a[y])
			if x != last {
				arr = append(arr, a[x])
			}
			last = y
		} else {
			res = append(res, arr)
			arr = make([]int32, 0)
		}
		x++
		y++
	}

	if len(arr) > 0 {
		res = append(res, arr)
	}

	max := 0
	for k, v := range res {
		fmt.Printf("[%v] = %v\n", k, v)
		if len(v) > max {
			max = len(v)
		}
	}

	return int32(max)
}
