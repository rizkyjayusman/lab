package main

type CheckIfTheSentenceIsPangram struct{}

func (citsip CheckIfTheSentenceIsPangram) CheckIfPangram(sentence string) bool {
	m := make(map[rune]struct{})
	for _, v := range sentence {
		if _, ok := m[v]; !ok {
			m[v] = struct{}{}
		}
	}
	return len(m) == 26
}
