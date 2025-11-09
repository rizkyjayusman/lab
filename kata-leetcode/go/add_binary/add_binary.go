package main

type AddBinary struct{}

func (ab AddBinary) addBinary(a string, b string) string {
	// 1 :: 49
	i := len(a) - 1
	j := len(b) - 1
	add := 0

	var str string
	for add > 0 || i >= 0 || j >= 0 {
		res := add
		if i >= 0 {
			if a[i] == 49 {
				res++
			}
			i--
		}

		if j >= 0 {
			if b[j] == 49 {
				res++
			}
			j--
		}

		add = 0
		if res >= 2 {
			add = 1
		}

		r := "0"
		if res%2 == 1 {
			r = "1"
		}

		str = r + str
	}
	return str
}
