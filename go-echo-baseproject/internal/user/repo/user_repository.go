package repo

import (
	"database/sql"
	"go-echo-baseproject/internal/user/model"
)

type UserRepository interface {
	GetUser(id string) (string, error)
	GetAll() ([]model.User, error)
}

type sqlUserRepositoryImpl struct {
	DB *sql.DB
}

func NewUserRepository(db *sql.DB) UserRepository {
	return &sqlUserRepositoryImpl{
		DB: db,
	}
}

func (r *sqlUserRepositoryImpl) GetAll() ([]model.User, error) {
	query := `SELECT id, first_name, last_name, age FROM users`
	rows, err := r.DB.Query(query)
	if err != nil {
		return nil, err
	}
	defer rows.Close()

	var users []model.User
	for rows.Next() {
		var u model.User
		if err := rows.Scan(&u.ID, &u.FirstName, &u.LastName, &u.Age); err != nil {
			return nil, err
		}
		users = append(users, u)
	}
	return users, nil
}

func (s *sqlUserRepositoryImpl) GetUser(id string) (string, error) {
	return id, nil
}
