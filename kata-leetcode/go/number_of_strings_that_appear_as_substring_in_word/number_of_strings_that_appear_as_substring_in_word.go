package main

import "fmt"

func main() {
	fmt.Println(numOfStrings([]string{"a", "abc", "bc", "d"}, "abc"))
	fmt.Println(numOfStrings([]string{"a", "b", "c"}, "aaaaabbbbb"))
	fmt.Println(numOfStrings([]string{"a", "a", "a"}, "ab"))
}

func numOfStrings(patterns []string, word string) int {
	res := 0
	for _, v := range patterns {
		s := make(map[string]struct{})
		for i := 0; i < len(word); i++ {
			lenV := len(v)
			substr := word[i:]
			if len(substr) < lenV {
				continue
			}

			if len(substr) > lenV {
				substr = word[i : i+lenV]
			}

			if substr == v {
				s[v] = struct{}{}
			}
		}

		res += len(s)
	}
	return res
}
