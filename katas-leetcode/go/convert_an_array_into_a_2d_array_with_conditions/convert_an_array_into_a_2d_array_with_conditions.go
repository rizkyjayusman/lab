package main

type TwoDimensionArray struct{}

func (tda TwoDimensionArray) FindMatrix(nums []int) [][]int {
	var res []map[int]struct{}
	for _, v := range nums {
		if len(res) == 0 {
			res = append(res, make(map[int]struct{}))
		}

		for i := 0; i < len(res); i++ {
			if _, ok := res[i][v]; ok {
				if len(res)-1 == i {
					res = append(res, make(map[int]struct{}))
				}
				continue
			}

			res[i][v] = struct{}{}
			break
		}

	}

	var arr [][]int
	for _, v := range res {
		var inarr []int
		for kk := range v {
			inarr = append(inarr, kk)
		}
		arr = append(arr, inarr)
	}

	return arr
}
