package main

type FirstPalindrome struct{}

func (fp FirstPalindrome) firstPalindrome(words []string) string {
	for _, v := range words {
		isPalindrome := true
		i, j := 0, len(v)-1
		for i <= j && isPalindrome {
			if v[i] != v[j] {
				isPalindrome = false
			}
			i++
			j--
		}

		if isPalindrome {
			return v
		}
	}

	return ""
}
