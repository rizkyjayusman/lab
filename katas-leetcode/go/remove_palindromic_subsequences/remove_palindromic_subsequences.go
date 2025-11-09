package main

import "fmt"

type Palindromic struct{}

func (p Palindromic) RemovePalindromeSub(s string) int {
	res := 0
	i, j := 0, len(s)-1
	check := true
	for {
		if i > j {
			break
		}

		if s[i] != s[j] {
			check = false
			break
		}

		fmt.Println(i, j)
		i++
		j--
	}

	if check {
		res = 1
	}

	return res
}
