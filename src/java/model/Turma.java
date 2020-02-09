package model;

import java.sql.Date;

public class Turma {
    private int id, instrutores_id, cursos_id, carga_horaria;
    private Date data_inicio, data_final;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInstrutores_id() {
        return instrutores_id;
    }

    public void setInstrutores_id(int instrutores_id) {
        this.instrutores_id = instrutores_id;
    }

    public int getCursos_id() {
        return cursos_id;
    }

    public void setCursos_id(int cursos_id) {
        this.cursos_id = cursos_id;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }
}
