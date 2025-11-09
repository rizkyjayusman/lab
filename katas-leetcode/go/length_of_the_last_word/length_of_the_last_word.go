package main

import "fmt"

func main() {
	fmt.Println(lengthOfLastWord("luffy is still joyboy"))
}

func lengthOfLastWord(s string) int {
	count := 0
	tmp := 0
	for i := 0; i < len(s); i++ {
		if string(s[i]) == " " {
			tmp = 0
		} else {
			tmp++
		}

		if tmp > 0 {
			count = tmp
		}
	}

	return count
}
