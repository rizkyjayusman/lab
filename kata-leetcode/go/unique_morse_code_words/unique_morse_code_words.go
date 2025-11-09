package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(uniqueMorseRepresentations([]string{"gin", "zen", "gig", "msg"}))
}

func uniqueMorseRepresentations(words []string) int {
	m := []string{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."}
	m2 := make(map[string]struct{})
	for _, i := range words {
		str := []string{}
		for _, e := range i {
			str = append(str, m[e-97])
		}
		res := strings.Join(str[:], "")
		if _, ok := m2[res]; !ok {
			m2[res] = struct{}{}
		}
	}

	return len(m2)
}
