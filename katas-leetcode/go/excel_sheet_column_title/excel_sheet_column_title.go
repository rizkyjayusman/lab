package main

import (
	"fmt"
)

func main() {
	fmt.Println(convertToTitle(1))
	fmt.Println(convertToTitle(28))
	fmt.Println(convertToTitle(701))
	fmt.Println(convertToTitle(2759))
}

func convertToTitle(columnNumber int) string {
	res := ""
	for columnNumber > 0 {
		mod := columnNumber % 26
		if mod > 0 {
			res = string(rune((mod)+64)) + res
			columnNumber -= mod
		} else if mod == 0 {
			div := columnNumber / 26
			if div > 26 {
				columnNumber = div
			} else {
				res = string(rune((columnNumber/26)+64)) + res
				columnNumber -= columnNumber
			}
		}
	}
	return res
}
