package main

import (
	"fmt"
	"unicode"
)

func main() {
	fmt.Println(isPalindrome("A man, a plan, a canal: Panama"))
}

func isPalindrome(s string) bool {
	i := 0
	j := len(s) - 1

	for i <= j {
		l := rune(s[i])
		r := rune(s[j])

		if !unicode.IsLetter(l) && !unicode.IsDigit(l) {
			i++
		} else if !unicode.IsLetter(r) && !unicode.IsDigit(r) {
			j--
		} else if unicode.ToLower(l) == unicode.ToLower(r) {
			i++
			j--
		} else {
			return false
		}

	}
	return true
}
