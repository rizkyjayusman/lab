package main

import "fmt"

func main() {
	fmt.Println(fibonacci(1))
	// fmt.Println(fibonacci(30))
	// fmt.Println(fibonacci(4))
	// fmt.Println(fibonacci(2))
}

func fibonacci(n int32) []int32 {
	arr := []int32{}
	for i := int32(0); i < n; i++ {
		var res int32
		if i-2 > 0 {
			res += arr[i-2]
		}

		if i-1 > 0 {
			res += arr[i-1]
		}

		if i == 1 {
			res++
		}

		arr = append(arr, res)
	}
	return arr
}
