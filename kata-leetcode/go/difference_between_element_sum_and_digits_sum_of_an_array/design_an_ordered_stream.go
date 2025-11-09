package main

type OrderedStream struct {
	Ptr int
	Arr []string
}

func Constructor(n int) *OrderedStream {
	return &OrderedStream{
		Ptr: 0,
		Arr: make([]string, n),
	}
}

func (this *OrderedStream) Insert(idKey int, value string) []string {
	this.Arr[idKey] = value

	end := this.Ptr
	for end < len(this.Arr) {
		if this.Arr[end] == "" {
			break
		}

		end++
	}
	strt := this.Ptr
	this.Ptr = end

	return this.Arr[strt:end]
}
