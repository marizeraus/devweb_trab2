package model;

import java.sql.Date;

public class Matricula {
    private int id, turmas_id, alunos_id;
    private Date data_matricula;
    private double nota;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurmas_id() {
        return turmas_id;
    }

    public void setTurmas_id(int turmas_id) {
        this.turmas_id = turmas_id;
    }

    public int getAlunos_id() {
        return alunos_id;
    }

    public void setAlunos_id(int alunos_id) {
        this.alunos_id = alunos_id;
    }

    public Date getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(Date data_matricula) {
        this.data_matricula = data_matricula;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
