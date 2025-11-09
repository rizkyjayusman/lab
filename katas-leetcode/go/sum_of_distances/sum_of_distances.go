package main

type SumOfDistances struct{}

func (sd SumOfDistances) Distance(nums []int) []int64 {
	var res []int64
	m := make(map[int][]int)
	for i := 0; i < len(nums); i++ {
		var arr []int
		if _, ok := m[nums[i]]; ok {
			arr = m[nums[i]]
		}

		sum := 0
		tmp := 0
		if len(arr) == 0 {
			for kk, vv := range nums {
				if vv == nums[i] {
					arr = append(arr, kk)
					tmp += abs(i - kk)
				}
			}
			m[nums[i]] = arr
		} else {
			for _, vv := range arr {
				tmp += abs(i - vv)
			}
		}
		sum += tmp
		res = append(res, int64(sum))
	}

	return res
}

func abs(val int) int {
	if val < 0 {
		return val * -1
	}
	return val
}
