package main

import (
	"bytes"
	"fmt"
	"strings"
)

func main() {
	fmt.Println(reverseWords("Let's take LeetCode contest"))
	fmt.Println(reverseWords("God Ding"))

	// fmt.Println(reverseWords2("Let's take LeetCode contest"))
	// fmt.Println(reverseWords2("God Ding"))
}

func reverseWords(s string) string {
	splt := strings.Split(s, " ")
	return strings.Join(reverse(splt), " ")
}

func reverseWords2(s string) string {
	splt := split(s)
	return join(reverse(splt), ' ')
}

func join(arr []string, sep rune) string {
	var buffer bytes.Buffer
	for k, w := range arr {
		buffer.WriteString(w)

		if k < len(arr)-1 {
			buffer.WriteRune(' ')
		}
	}
	return buffer.String()
}

func reverse(splt []string) []string {
	for k, w := range splt {
		var str []byte
		for i := len(w) - 1; i >= 0; i-- {
			str = append(str, w[i])
		}
		splt[k] = string(str)
	}
	return splt
}

func split(s string) []string {
	var res []string
	var w []rune
	for _, v := range s {
		if v == ' ' {
			res = append(res, string(w))
			w = make([]rune, 0)
			continue
		}
		w = append(w, v)
	}

	if len(w) > 0 {
		res = append(res, string(w))
	}

	return res
}
