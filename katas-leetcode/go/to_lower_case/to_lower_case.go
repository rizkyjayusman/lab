package main

import "fmt"

func main() {
	fmt.Println(toLowerCase("Hello"))
	fmt.Println(toLowerCase("here"))
	fmt.Println(toLowerCase("LOVELY"))
	fmt.Println(toLowerCase("NeVer LeT u G0"))
}

func toLowerCase(s string) string {
	var r []rune
	// A : 65 - Z = 90
	for _, v := range s {
		if v >= 65 && v <= 90 {
			v += 32
		}
		r = append(r, v)
	}
	return string(r)
}
