package main

import "fmt"

func main() {
	// fmt.Println(replaceDigits("a1c1e1"))
	fmt.Println(replaceDigits("a1b2c3d4e"))
}

func replaceDigits(s string) string {
	var arr []rune
	// 0 :: 48
	for k := range s {
		v := s[k]
		if k%2 == 1 {
			r := s[k-1]
			l := byte(v - 48)
			v = r + l
		}
		arr = append(arr, rune(v))
	}
	return string(arr)
}
