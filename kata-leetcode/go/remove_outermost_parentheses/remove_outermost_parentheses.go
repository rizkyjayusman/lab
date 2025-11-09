package main

import "fmt"

func main() {
	fmt.Println(removeOuterParentheses("(()())(())")) // ()()()
	// fmt.Println(removeOuterParentheses("(()())(())(()(()))")) // ()()()()(())
	// fmt.Println(removeOuterParentheses("(()())(())(()(()))")) // ()()()()(())
	// fmt.Println(removeOuterParentheses("()()"))               //
}

func removeOuterParentheses(s string) string {
	var stack []rune
	var str []rune
	for _, v := range s {
		if v == '(' {
			stack = append(stack, v)
			if len(stack) == 1 {
				continue
			}
		}

		if v == ')' {
			stack = stack[:len(stack)-1]
		}

		if len(stack) > 0 {
			str = append(str, v)
		}
	}
	return string(str)
}
