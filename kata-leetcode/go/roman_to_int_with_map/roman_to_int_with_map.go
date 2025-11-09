package main

import "fmt"

var rule_map = map[string]int{
	"I": 1,
	"V": 5,
	"X": 10,
	"L": 50,
	"C": 100,
	"D": 500,
	"M": 1000,
}

var rule_combine_map = map[string]int{
	"IV": 4,
	"IX": 9,
	"XL": 40,
	"XC": 90,
	"CD": 400,
	"CM": 900,
}

func main() {
	fmt.Println(romanToInt("MCMXCIV"))
}

func romanToInt(s string) int {
	res := 0
	for j := 0; j < len(s); j++ {
		if j+2 <= len(s) {
			if val, ok := rule_combine_map[s[j:j+2]]; ok {
				res += val
				j++
				continue
			}
		}

		if val, ok := rule_map[s[j:j+1]]; ok {
			res += val
		}
	}

	return res
}
