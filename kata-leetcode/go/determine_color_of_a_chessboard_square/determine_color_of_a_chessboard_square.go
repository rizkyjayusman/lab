package main

type ChessBoardSquare struct{}

func (cb ChessBoardSquare) SquareIsWhite(coordinates string) bool {
	return !(coordinates[0]%2 == 0) == (coordinates[1]%2 == 0)
}
