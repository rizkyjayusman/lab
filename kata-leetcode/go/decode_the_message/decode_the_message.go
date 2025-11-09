package main

import (
	"fmt"
)

func main() {
	// fmt.Println(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"))
	fmt.Println(decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"))
}

func decodeMessage(key string, message string) string {
	// a -> 97 - z -> 122
	strt := 'a'
	hmap := map[rune]rune{}
	for _, v := range key {
		if v >= 97 && v <= 122 {
			if _, ok := hmap[v]; ok {
				continue
			}
			hmap[v] = strt
			strt++
		}
	}

	var str []rune
	for _, m := range message {
		if m >= 97 && m <= 122 {
			m = hmap[m]
		}
		str = append(str, m)
	}
	return string(str)
}
