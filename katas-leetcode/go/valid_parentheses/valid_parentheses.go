package main

import "fmt"

func main() {
	fmt.Println(isValid("()"))
	fmt.Println(isValid("()[]{}"))
	fmt.Println(isValid("(]"))
	fmt.Println(isValid("{{}}"))
	fmt.Println(isValid("{"))
}

func isValid(s string) bool {
	var stack []string
	res := true
	for i := 0; i < len(s); i++ {
		el := string(s[i])
		if el == "[" || el == "(" || el == "{" {
			stack = append(stack, el)
		} else if el == "]" || el == ")" || el == "}" {
			if len(stack) == 0 {
				return false
			}

			last_idx := len(stack) - 1
			val := string(stack[last_idx])
			if (val != "[" && el == "]") || (val != "{" && el == "}") || (val != "(" && el == ")") {
				return false
			}

			stack = stack[:last_idx]
		} else {
			return false
		}
	}

	if len(stack) != 0 {
		return false
	}

	return res
}
