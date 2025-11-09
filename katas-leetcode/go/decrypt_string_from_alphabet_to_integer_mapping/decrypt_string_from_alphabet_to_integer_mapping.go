package main

import (
	"fmt"
	"strconv"
)

func main() {
	fmt.Println(freqAlphabets("10#11#12"))
	fmt.Println(freqAlphabets("10#1311#12"))
	fmt.Println(freqAlphabets("1326#"))
}

func freqAlphabets(s string) string {
	// 97 - 105
	// 106 - 122
	foundHashTag := false
	var str []byte
	var tmp []byte
	for i := len(s) - 1; i >= 0; i-- {
		if s[i] == '#' {
			foundHashTag = true
			continue
		}

		sbstr := ""
		if foundHashTag {
			tmp = append(append([]byte{}, s[i]), tmp...)
			if len(tmp) == 2 {
				sbstr = string(tmp)

				tmp = make([]byte, 0)
				foundHashTag = false
			}
		} else {
			sbstr = string(s[i])
		}

		if len(sbstr) > 0 {
			if v, err := strconv.Atoi(sbstr); err == nil {
				str = append(append([]byte{}, byte(97+v-1)), str...)
			}
		}
	}
	return string(str)
}
