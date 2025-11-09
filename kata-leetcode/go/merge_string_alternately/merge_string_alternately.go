package main

type String struct{}

func (s String) MergeAlternately(word1 string, word2 string) string {
	i := 0
	var str []byte
	for {
		if i >= len(word1) && i >= len(word2) {
			break
		}

		if i < len(word1) {
			str = append(str, word1[i])
		}

		if i < len(word2) {
			str = append(str, word2[i])
		}

		i++
	}

	return string(str)
}
