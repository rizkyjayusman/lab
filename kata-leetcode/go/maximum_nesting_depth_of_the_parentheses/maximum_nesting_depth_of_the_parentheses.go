package main

import "fmt"

func main() {
	// fmt.Println(maxDepth("(1+(2*3)+((8)/4))+1"))
	fmt.Println(maxDepth("(1)+((2))+(((3)))"))
}

func maxDepth(s string) int {
	var arr []rune

	count := 0
	for _, v := range s {
		if v == '(' {
			arr = append(arr, v)
			if len(arr) > count {
				count = len(arr)
			}
		} else if v == ')' {
			arr = arr[:len(arr)-1]
		}
	}
	return count
}
