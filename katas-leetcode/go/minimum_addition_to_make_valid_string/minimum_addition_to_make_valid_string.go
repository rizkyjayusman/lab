package main

type StringValidator struct{}

func (v StringValidator) AddMinimum(word string) int {
	i, j := 0, 1

	res := 0
	for i < len(word) {
		if word[i] == 'a' {
			res += 2
		} else if word[i] == 'b' {
			res += 2
		} else if word[i] == 'c' {
			res += 2
		}

		if j >= len(word) {
			break
		}

		if (word[i] == 'a' && (word[j] == 'b' || word[j] == 'c')) ||
			(word[i] == 'b' && word[j] == 'c') {
			res -= 1
			i = j + 1
			j += 2
			continue
		}

		i++
		j++
	}
	return res
}
