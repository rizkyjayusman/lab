package main

type FindScore struct{}

func (fs FindScore) FindPrefixScore(nums []int) []int64 {
	var res []int64
	var max int64
	var sum int64
	for _, v := range nums {
		cmpr := int64(v)
		if cmpr > max {
			max = cmpr
		}

		sum += cmpr + max
		res = append(res, sum)
	}

	return res
}
