package main

import "fmt"

func main() {
	fmt.Println(truncateSentence("Hello how are you Contestant", 4))
}

func truncateSentence(s string, k int) string {
	count := 0
	for i := 0; i < len(s); i++ {
		if s[i] == ' ' {
			count++
		}

		if count == k {
			s = s[:i]
		}
	}
	return s
}
