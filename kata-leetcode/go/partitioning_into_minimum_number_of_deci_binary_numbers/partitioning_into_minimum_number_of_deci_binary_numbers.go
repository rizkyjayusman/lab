package main

type BinaryNumber struct{}

func (bn BinaryNumber) MinPartitions(n string) int {
	res := 0

	var arr []rune
	for _, v := range n {
		arr = append(arr, v)
	}

	var zeroCount int
	for {
		zeroCount = 0
		for k, v := range arr {
			if v == '0' {
				zeroCount++
			} else {
				v := v - 1
				arr[k] = v
			}
		}

		if zeroCount == len(n) {
			break
		}

		res++
	}

	return res
}
