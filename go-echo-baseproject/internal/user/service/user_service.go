package service

import (
	"go-echo-baseproject/internal/user/model"
	"go-echo-baseproject/internal/user/repo"
)

type UserService interface {
	GetAll() ([]model.User, error)
	GetUser(id string) (string, error)
}

type userServiceImpl struct {
	repo repo.UserRepository
}

func (s *userServiceImpl) GetAll() ([]model.User, error) {
	return s.repo.GetAll()
}

func (s *userServiceImpl) GetUser(id string) (string, error) {
	return s.repo.GetUser(id)
}

func NewUserService(r repo.UserRepository) UserService {
	return &userServiceImpl{repo: r}
}
