package cmd

type Config struct{}

type Default struct {
	cfg Config
}

func New(cfg Config) (*Default, error) {
	cmd := &Default{
		cfg: cfg,
	}

	return cmd, nil
}
