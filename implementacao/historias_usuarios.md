## H1: Matrícula em disciplinas obrigatórias
**Como** aluno  
**Eu quero** me matricular em até 4 disciplinas obrigatórias  
**Para que** eu possa seguir o currículo do meu curso no semestre seguinte.

### Critérios de Aceitação:
- O aluno deve visualizar todas as disciplinas disponíveis.
- O aluno deve poder selecionar até 4 disciplinas obrigatórias.
- O sistema deve verificar se as disciplinas têm vagas disponíveis (limite de 60 alunos).
- O sistema deve permitir cancelar a matrícula antes do final do período de inscrições.

---

## H2: Matrícula em disciplinas optativas
**Como** aluno  
**Eu quero** me matricular em até 2 disciplinas optativas  
**Para que** eu tenha flexibilidade de escolher disciplinas complementares ao meu curso.

### Critérios de Aceitação:
- O aluno deve visualizar as disciplinas optativas disponíveis.
- O aluno deve poder selecionar até 2 disciplinas optativas.
- O sistema deve verificar a disponibilidade de vagas e permitir cancelar a matrícula.

---

## H3: Cancelamento de matrícula em disciplina
**Como** aluno  
**Eu quero** cancelar minha matrícula em uma disciplina  
**Para que** eu possa reorganizar minha carga de matérias antes do início das aulas.

### Critérios de Aceitação:
- O aluno deve poder visualizar suas disciplinas matriculadas.
- O aluno deve poder cancelar a matrícula em qualquer disciplina antes do término do período de matrícula.
- O sistema deve atualizar o número de vagas disponíveis na disciplina após o cancelamento.

---

## H4: Notificação do sistema de cobranças
**Como** sistema de matrículas  
**Eu quero** notificar o sistema de cobranças após a inscrição do aluno  
**Para que** o aluno seja cobrado pelas disciplinas em que se matriculou.

### Critérios de Aceitação:
- Após a confirmação da matrícula, o sistema de cobranças deve ser notificado.
- O sistema de cobranças deve receber as informações sobre o aluno e as disciplinas.

---

## H5: Consulta de matrículas pelos professores
**Como** professor  
**Eu quero** visualizar a lista de alunos matriculados nas minhas disciplinas  
**Para que** eu possa organizar meu planejamento de aulas.

### Critérios de Aceitação:
- O professor deve poder visualizar a lista de alunos inscritos em suas disciplinas.
- O sistema deve permitir ao professor acessar as informações de cada turma, incluindo nome do aluno e status da matrícula.

---

## H6: Validação de login por senha
**Como** usuário do sistema (aluno, professor ou administrador)  
**Eu quero** acessar o sistema utilizando uma senha  
**Para que** minhas informações sejam mantidas seguras.

### Critérios de Aceitação:
- O sistema deve exigir login com senha para todos os usuários.
- O sistema deve validar a senha informada.
- O acesso deve ser negado em caso de senha incorreta.

---

## H7: Ativação de disciplinas
**Como** sistema de matrículas  
**Eu quero** ativar uma disciplina apenas se houver, no mínimo, 3 alunos inscritos  
**Para que** a disciplina ocorra apenas quando houver alunos suficientes.

### Critérios de Aceitação:
- O sistema deve verificar o número de alunos inscritos no final do período de matrícula.
- O sistema deve cancelar disciplinas com menos de 3 alunos.
- O sistema deve informar aos alunos sobre o cancelamento de disciplinas.
