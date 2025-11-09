package main

import "fmt"

func main() {
	fmt.Println(countMatches([][]string{{"phone", "blue", "pixel"}, {"computer", "silver", "lenovo"}, {"phone", "gold", "iphone"}}, "color", "silver"))
}

func countMatches(items [][]string, ruleKey string, ruleValue string) int {
	key := 0
	switch ruleKey {
	case "type":
		key = 0
	case "color":
		key = 1
	case "name":
		key = 2
	}

	count := 0
	for _, v := range items {
		if v[key] == ruleValue {
			count++
		}
	}

	return count
}
