package main

import (
	"fmt"
)

func main() {
	fmt.Println(defangIPaddr("1.1.1.1"))
}

func defangIPaddr(address string) string {
	var str []rune
	for _, v := range address {
		if v == '.' {
			str = append(str, '[', v, ']')
			continue
		}
		str = append(str, v)
	}
	return string(str)
}
