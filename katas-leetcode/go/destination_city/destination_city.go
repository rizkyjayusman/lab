package main

type DestinationCity struct{}

func (dc DestinationCity) destCity(paths [][]string) string {
	m := make(map[string]struct{})
	for _, v := range paths {
		if _, ok := m[v[0]]; ok {
			continue
		}
		m[v[0]] = struct{}{}
	}

	for _, v := range paths {
		if _, ok := m[v[1]]; !ok {
			return v[1]
		}
	}
	return ""
}
