package main

import "fmt"

func main() {
	stack()
}

func stack() {
	var stack []string

	stack = append(stack, "a")
	stack = append(stack, "b")

	if len(stack) != 0 {
		idx := len(stack) - 1
		el := stack[idx]
		stack = stack[:idx]
		fmt.Println(el)
	}
	stack = append(stack, "b")

	fmt.Print(stack)
}
