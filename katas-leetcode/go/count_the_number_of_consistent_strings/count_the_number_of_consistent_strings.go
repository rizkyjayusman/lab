package main

import "fmt"

func main() {
	fmt.Println(countConsistentStrings("ab", []string{"ad", "bd", "aaab", "baa", "badab"}))
	fmt.Println(countConsistentStrings("abc", []string{"a", "b", "c", "ab", "ac", "bc", "abc"}))
	fmt.Println(countConsistentStrings("cad", []string{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}))
}

func countConsistentStrings(allowed string, words []string) int {
	m := make(map[rune]struct{})
	for _, v := range allowed {
		if _, ok := m[v]; !ok {
			m[v] = struct{}{}
		}
	}

	count := 0
	for _, i := range words {
		b := true
		for _, v := range i {
			if _, ok := m[v]; !ok {
				b = false
				break
			}
		}

		if b {
			count++
		}
	}
	return count
}
