package main

import "strings"

type WordPattern struct{}

func (wp WordPattern) WordPattern(pattern string, s string) bool {
	splittedStr := strings.Split(s, " ")
	if len(splittedStr) != len(pattern) {
		return false
	}

	mstr := make(map[string]rune)
	mrune := make(map[rune]string)
	for k, v := range pattern {
		if val, ok := mstr[splittedStr[k]]; ok {
			if v != val {
				return false
			}
			continue
		}

		if val, ok := mrune[v]; ok {
			if splittedStr[k] != val {
				return false
			}
			continue
		}

		mstr[splittedStr[k]] = v
		mrune[v] = splittedStr[k]
	}

	return true
}
