package main

type HeightChecker struct{}

func (c HeightChecker) HeightChecker(heights []int) int {
	var arr []int
	for _, v := range heights {
		arr = append(arr, v)
	}

	var isDone = false
	for !isDone {
		isDone = true
		var i = 0
		for i < len(arr)-1 {
			if arr[i] > arr[i+1] {
				arr[i], arr[i+1] = arr[i+1], arr[i]
				isDone = false
			}
			i++
		}
	}

	cnt := 0
	for k, v := range heights {
		if v != arr[k] {
			cnt++
		}
	}

	return cnt
}
