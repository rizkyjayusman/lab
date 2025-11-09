package main

import (
	"fmt"
)

func main() {
	// fmt.Println(balancedStringSplit("RLRRLLRLRL"))
	// fmt.Println(balancedStringSplit("RLRRRLLRLL"))
	fmt.Println(balancedStringSplit("LLLLRRRR"))
}

func balancedStringSplit(s string) int {
	count := 0
	var arr []rune
	for _, v := range s {
		if len(arr) > 0 {
			last := arr[len(arr)-1]
			if (last == 'L' && v == 'R') || (last == 'R' && v == 'L') {
				arr = arr[:len(arr)-1]
				if len(arr) == 0 {
					count++
				}
				continue
			}
		}

		arr = append(arr, v)
	}
	return count
}
