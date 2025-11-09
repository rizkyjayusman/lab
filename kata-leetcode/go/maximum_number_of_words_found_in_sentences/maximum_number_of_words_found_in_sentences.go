package main

import "fmt"

func main() {
	fmt.Println(mostWordsFound([]string{"alice and bob love leetcode", "i think so too", "this is great thanks very much"}))
	fmt.Println(mostWordsFound([]string{"please wait", "continue to fight", "continue to win"}))
}

func mostWordsFound(sentences []string) int {
	high := 0
	for _, sentence := range sentences {
		count := 1
		for _, letter := range sentence {
			if letter == ' ' {
				count++
			}
		}

		if count > high {
			high = count
		}
	}

	return high
}
