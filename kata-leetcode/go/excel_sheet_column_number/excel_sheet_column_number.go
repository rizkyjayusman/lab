package main

import (
	"fmt"
)

func main() {
	fmt.Println(titleToNumber("A"))
	// fmt.Println(titleToNumber("AB"))
	// fmt.Println(titleToNumber("ZY"))
}

func titleToNumber(columnTitle string) int {
	// A :: 65
	x := 1
	counter := 0
	for i := len(columnTitle) - 1; i >= 0; i-- {
		fmt.Printf("%c\n", columnTitle[i])
		counter += (int(columnTitle[i]-64) * x)
		x *= 26
	}

	return counter
}
