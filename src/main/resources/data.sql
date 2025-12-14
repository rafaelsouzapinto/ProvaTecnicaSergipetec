-- Garante que as tabelas estejam vazias antes de inserir
DELETE FROM pagamento_tb;
DELETE FROM ferias_tb;
DELETE FROM servidor_tb;

-- Inserção de Servidores
INSERT INTO servidor_tb (id, nome, email, matricula, senha) VALUES
(100, 'João Silva (Teste)', 'joao@hotmail.com', '123456', '123'),
(101, 'Maria Souza (Teste)', 'maria@gmail.com', '789012', '456');

-- Inserção de Ferias
INSERT INTO ferias_tb (id, data_inicio, data_fim, status, servidor_id) VALUES
(200, '2025-02-01', '2025-02-28', 'APROVADA', 100);

INSERT INTO ferias_tb (id, data_inicio, data_fim, status, servidor_id) VALUES
(201, '2026-06-15', '2026-07-15', 'SOLICITADA', 100);

INSERT INTO ferias_tb (id, data_inicio, data_fim, status, servidor_id) VALUES
(202, '2025-01-01', '2025-01-30', 'APROVADA', 101);

-- Pagamento para Férias Aprovadas
INSERT INTO pagamento_tb (id, data_pagamento, descricao, valor, ferias_id) VALUES
(500, '2025-01-25', 'Salário Bruto + Abono Pecuniário (10 dias)', 3600.45, 200),
(501,'2024-12-20', 'Salário Base de Férias', 4000.00, 202);
