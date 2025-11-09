package main

type FindTheLongestBalancedSubstringOfABinaryString struct{}

func (flb FindTheLongestBalancedSubstringOfABinaryString) FindTheLongestBalancedSubstring(s string) int {
	var arr []rune
	max, tmp := 0, 0
	for k, v := range s {
		if v == '0' {
			arr = append(arr, v)
			continue
		}

		if len(arr) > 0 {
			arr = arr[:len(arr)-1]
			tmp++

			if len(arr) > 0 && ((k+1 > len(s)-1) || (s[k+1] == '0')) {
				arr = []rune{}
			}

			if len(arr) == 0 {
				if tmp > max {
					max = tmp
				}

				tmp = 0
			}
		}
	}

	return max * 2
}

func (flb FindTheLongestBalancedSubstringOfABinaryString) FindTheLongestBalancedSubstring2(s string) int {
	check := true
	i := 1
	for check {
		var arr []rune
		for j := 0; j < i; j++ {
			arr = append(arr, '0')
		}

		for j := 0; j < i; j++ {
			arr = append(arr, '1')
		}

		check = false
		str := string(arr)
		for x := 0; x < len(s); x++ {
			if s[x] == '1' {
				continue
			}

			if x+len(str) > len(s) {
				break
			}

			if s[x:x+len(str)] == str {
				i++
				check = true
				break
			}
		}
	}

	if !check {
		i--
	}

	return i * 2
}
