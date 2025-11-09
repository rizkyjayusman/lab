package main

import "strings"

type CountingWord struct{}

func (cw CountingWord) PrefixCount(words []string, pref string) int {
	cnt := 0
	for _, v := range words {
		if strings.HasPrefix(v, pref) {
			cnt++
		}
	}
	return cnt
}
