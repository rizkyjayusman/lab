package main

type GetMoneySpent struct{}

func (gms GetMoneySpent) GetMoneySpent(keyboards []int32, drives []int32, b int32) int32 {
	res := int32(-1)
	for _, v := range keyboards {
		for _, iv := range drives {
			sum := v + iv
			if sum <= b && sum > res {
				res = sum
			}
		}
	}

	return res
}
