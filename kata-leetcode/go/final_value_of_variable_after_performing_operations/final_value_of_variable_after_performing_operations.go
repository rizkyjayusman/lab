package main

import "fmt"

func main() {
	// fmt.Println(finalValueAfterOperations([]string{"--X", "X++", "X++"}))
	fmt.Println(finalValueAfterOperations([]string{"++X", "++X", "X++"}))
}

func finalValueAfterOperations(operations []string) int {
	res := 0
	for _, op := range operations {
		if op[0:2] == "--" || op[1:3] == "--" {
			res--
		} else if op[0:2] == "++" || op[1:3] == "++" {
			res++
		}
	}
	return res
}
