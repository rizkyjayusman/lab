package main

import "fmt"

func main() {
	fmt.Println(plusOne([]int{1, 2, 3}))
	fmt.Println(plusOne([]int{4, 3, 2, 1}))
	fmt.Println(plusOne([]int{9}))
	fmt.Println(plusOne([]int{1, 1, 9}))
	fmt.Println(plusOne([]int{9, 9}))
}

func plusOne(digits []int) []int {
	for i := len(digits) - 1; i >= 0; i-- {
		if i == len(digits)-1 {
			digits[i] = digits[i] + 1
		}

		if digits[i] > 9 {
			if i > 0 {
				digits[i-1] = digits[i-1] + 1
				digits[i] = digits[i] - 10
			} else {
				digits = append(digits, digits[i]-10)
				digits[i] = 1
			}
		}
	}
	return digits
}
