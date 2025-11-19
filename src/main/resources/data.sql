DELETE FROM inscricoes;
DELETE FROM trilhas;
DELETE FROM usuarios;

-- TABELA: usuarios
INSERT INTO usuarios (id, nome, email, profissao, nivel) VALUES
(1, 'Gustavo Almeida', 'gustavo.almeida@example.com', 'Desenvolvedor', 'JUNIOR'),
(2, 'Larissa Carvalho', 'larissa.carvalho@example.com', 'Analista', 'PLENO'),
(3, 'Thiago Moreira', 'thiago.moreira@example.com', 'Designer', 'SENIOR'),
(4, 'Camila Duarte', 'camila.duarte@example.com', 'Gerente de Projetos', 'PLENO'),
(5, 'Rafael Silveira', 'rafael.silveira@example.com', 'DevOps', 'SENIOR'),
(6, 'Beatriz Nogueira', 'beatriz.nogueira@example.com', 'Engenheira de Dados', 'PLENO'),
(7, 'Lucas Menezes', 'lucas.menezes@example.com', 'Product Owner', 'PLENO'),
(8, 'Amanda Oliveira', 'amanda.oliveira@example.com', 'Analista de QA', 'JUNIOR'),
(9, 'Pedro Martins', 'pedro.martins@example.com', 'Full Stack Developer', 'PLENO'),
(10, 'Isabela Rocha', 'isabela.rocha@example.com', 'Arquiteta de Software', 'SENIOR');

-- TABELA: trilhas
INSERT INTO trilhas (id, titulo, descricao, carga_horaria) VALUES
(1, 'Back-end Java Developer', 'Trilha focada em desenvolvimento backend com Java e Spring Boot.', 40),
(2, 'Data Engineering Fundamentals', 'Introdução a engenharia de dados e pipelines modernos.', 50),
(3, 'UX/UI Design Essentials', 'Fundamentos do design centrado no usuário.', 35);

-- TABELA: inscricoes
-- (fk_usuario, fk_trilha)
INSERT INTO inscricoes (id, usuario_id, trilha_id, data_inscricao) VALUES
(1, 1, 1, NOW()),
(2, 2, 3, NOW()),
(3, 3, 2, NOW()),
(4, 4, 1, NOW()),
(5, 5, 2, NOW());
