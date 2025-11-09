package main

import "fmt"

func main() {
	fmt.Println(romanToInt("LVIII"))
}

func romanToInt(s string) int {
	res := 0
	for i := len(s) - 1; i >= 0; i-- {
		curr_c := s[i : i+1]
		if curr_c == "M" {
			res += 1000

			if i > 0 && s[i-1:i] == "C" {
				res -= 100
				i--
			}
		} else if curr_c == "D" {
			res += 500

			if i > 0 && s[i-1:i] == "C" {
				res -= 100
				i--
			}
		} else if curr_c == "C" {
			res += 100

			if i > 0 && s[i-1:i] == "X" {
				res -= 10
				i--
			}
		} else if curr_c == "L" {
			res += 50

			if i > 0 && s[i-1:i] == "X" {
				res -= 10
				i--
			}
		} else if curr_c == "X" {
			res += 10

			if i > 0 && s[i-1:i] == "I" {
				res -= 1
				i--
			}
		} else if curr_c == "V" {
			res += 5

			if i > 0 && s[i-1:i] == "I" {
				res -= 1
				i--
			}
		} else if curr_c == "I" {
			res += 1
		}
	}

	return res
}
