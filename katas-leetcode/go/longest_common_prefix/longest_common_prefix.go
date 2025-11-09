package main

import (
	"fmt"
)

func main() {
	fmt.Printf("res :: %v\n", longestCommonPrefix([]string{"flower", "flow", "flight"}))
}

func longestCommonPrefix(strs []string) string {
	if len(strs) <= 0 {
		return ""
	}

	current := strs[0]
	i := 0
	next := true
	for i < len(current) && next {
		for j := 1; j < len(strs); j++ {
			if i == len(strs[j]) || string(current[i]) != string(strs[j][i]) {
				next = false
			}
			if !next {
				break
			}
		}
		if next {
			i++
		}
	}
	return current[:i]
}
